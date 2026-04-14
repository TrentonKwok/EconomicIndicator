public class Test {
    public static void main(String[] args){
        dayA();    // basic class test
        dayB();    // get the data
        dayC();    // construct an AVL tree for test
    }

    private static void dayA(){
        CountryList oecdList = new CountryList("OECD");
        System.out.println("The " + oecdList.getCountryListNumber() + " OCED Countries: ");
        System.out.println(oecdList);

        System.out.println("-------------------");
        System.out.println("Is OECD?");

        System.out.println("Japan: " + (oecdList.contains("Japan") ? "Yes" : "No"));
        System.out.println("China: " + (oecdList.contains("China") ? "Yes" : "No"));

        System.out.println("-------------------");

        CountryList g20List = new CountryList("G20");
        System.out.println("The " + g20List.getCountryListNumber() + " G20 Countries: ");
        System.out.println(g20List);

        System.out.println("-------------------");

        CountryList developingList = new CountryList("DEVELOPING");
        System.out.println("The " + developingList.getCountryListNumber() + " Developing Countries: ");
        System.out.println(developingList);
    }

    private static void dayB(){
        DataExtractor DE = new DataExtractor();

        String CPIFile = "Z_CPI.csv";
        String GDPFile = "Z_GDP.csv";
        String growthFile = "Z_Growth.csv";

        try{
            SequenceList<Country> testData = DE.extractCountry(new CountryList("OECD"), findCSV(GDPFile), findCSV(growthFile), findCSV(CPIFile), "2023");
            for (Country c : testData){
                System.out.println("----------------");
                System.out.println(c);
            }

        }catch (Exception e){
            System.out.println("Error happen");
        }
    }

    private static void dayC(){
        Country japan = new Country("Japan", 4213000000000.0, 0.2, 2.1);
        Country germany = new Country("Germany", 4710000000000.0, 0.1, 2.4);
        Country france = new Country("France", 3900000000000.0, 1.1, 2.3);
        Country korea = new Country("Korea", 3000000000000.0, 0.9, 2.0);
        RankedCountry a = new RankedCountry(japan, "GDP");
        RankedCountry b = new RankedCountry(germany, "GDP");
        RankedCountry c = new RankedCountry(france, "GDP");
        RankedCountry d = new RankedCountry(korea, "GDP");

        AVLTree<RankedCountry, Country> tree = new AVLTree<RankedCountry, Country>();
        tree.put(a, japan);
        tree.put(b, germany);
        tree.put(c, france);
        tree.put(d, korea);

        System.out.println("----------------");
        System.out.println("Size: " + tree.size());
        System.out.println("Height: " + tree.height());
        System.out.println("Min: " + tree.min());
        System.out.println("Max: " + tree.max());

        System.out.print("Inorder: ");
        tree.inorder();

        System.out.print("Preorder: ");
        tree.preorder();

        System.out.print("Postorder: ");
        tree.postorder();
    }

    private static String findCSV(String filename){
        java.io.File f = new java.io.File(filename);
        if(f.exists()){
            return filename;
        }
        return "src/" + filename;
    }
}
