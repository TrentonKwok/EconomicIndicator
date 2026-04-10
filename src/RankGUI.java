import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RankGUI extends JFrame {

    private JTextField yearField;
    private JComboBox<String> datatypeBox;
    private JButton buildButton;
    private JButton buildBSTButton;
    private JTextArea treeArea;
    private JTextArea infoArea;

    private String findCSV(String filename){
        java.io.File f = new java.io.File(filename);
        if(f.exists()){
            return filename;
        }
        return "src/" + filename;
    }

    public RankGUI(){
        setTitle("OECD Economic Ranking System");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();

        topPanel.add(new JLabel("Year:"));
        yearField = new JTextField("2024", 8);
        topPanel.add(yearField);

        topPanel.add(new JLabel("Datatype:"));
        datatypeBox = new JComboBox<String>();
        datatypeBox.addItem("GDP");
        datatypeBox.addItem("GROWTH");
        datatypeBox.addItem("INFLATION");
        topPanel.add(datatypeBox);

        buildButton = new JButton("Build Tree");
        topPanel.add(buildButton);

        buildBSTButton = new JButton("Build BST");
        topPanel.add(buildBSTButton);

        add(topPanel, BorderLayout.NORTH);

        treeArea = new JTextArea();
        treeArea.setEditable(false);
        JScrollPane treeScroll = new JScrollPane(treeArea);
        add(treeScroll, BorderLayout.CENTER);

        infoArea = new JTextArea(6, 20);
        infoArea.setEditable(false);
        JScrollPane infoScroll = new JScrollPane(infoArea);
        add(infoScroll, BorderLayout.SOUTH);

        buildButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                buildTree();
            }
        });

        buildBSTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                buildBST();
            }
        });
    }

    private void buildTree(){
        String year = yearField.getText();
        String datatype = (String) datatypeBox.getSelectedItem();
        try{
            DataExtractor DE = new DataExtractor();
            SequenceList<Country> countries = DE.extractCountry(
                    findCSV("Z_GDP.csv"),
                    findCSV("Z_Growth.csv"),
                    findCSV("Z_CPI.csv"),
                    year
            );
            AVLTree<RankedCountry, Country> tree = new AVLTree<RankedCountry, Country>();
            for(int i = 0; i < countries.length(); i++){
                Country c = countries.get(i);
                RankedCountry key = new RankedCountry(c, datatype);
                tree.put(key, c);
            }

            treeArea.setText(tree.printTree());

            String info = "";
            info = info + "Group: OECD\n";
            info = info + "Year: " + year + "\n";
            info = info + "Datatype: " + datatype + "\n";
            info = info + "Country count: " + countries.length() + "\n";
            info = info + "Tree size: " + tree.size() + "\n";
            info = info + "Tree height: " + tree.height() + "\n";
            infoArea.setText(info);
        }
        catch (Exception e){
            e.printStackTrace();
            treeArea.setText("");
            infoArea.setText("Error: " + e.getMessage());
        }
    }

    private void buildBST(){
        String year = yearField.getText();
        String datatype = (String) datatypeBox.getSelectedItem();
        try{
            DataExtractor DE = new DataExtractor();
            SequenceList<Country> countries = DE.extractCountry("src/Z_GDP.csv", "src/Z_Growth.csv", "src/Z_CPI.csv", year);
            BST<RankedCountry, Country> tree = new BST<RankedCountry, Country>();
            for(int i = 0; i < countries.length(); i++){
                Country c = countries.get(i);
                RankedCountry key = new RankedCountry(c, datatype);
                tree.put(key, c);
            }

            treeArea.setText(tree.printTree());

            String info = "";
            info = info + "Group: OECD\n";
            info = info + "Year: " + year + "\n";
            info = info + "Datatype: " + datatype + "\n";
            info = info + "Country count: " + countries.length() + "\n";
            info = info + "Tree size: " + tree.size() + "\n";
            info = info + "Tree height: " + tree.height() + "\n";
            infoArea.setText(info);
        }
        catch (Exception e){
            treeArea.setText("");
            infoArea.setText("Error happened.");
        }
    }

    public static void main(String[] args){
        RankGUI gui = new RankGUI();
        gui.setVisible(true);
    }
}