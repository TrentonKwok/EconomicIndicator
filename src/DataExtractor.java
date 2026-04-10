import java.io.BufferedReader;
import java.io.FileReader;

public class DataExtractor {
    private class TempCountry{
        String countryName;
        Double nominalGDP;
        Double GDPGrowthRate;
        Double inflationRate;

        public TempCountry(String countryName){
            this.countryName = countryName;
            nominalGDP = null;
            GDPGrowthRate = null;
            inflationRate = null;
        }

        public boolean isComplete(){
            return (nominalGDP != null && GDPGrowthRate != null && inflationRate != null);
        }
    }

    public SequenceList<Country> extractCountry(String GDPFile, String growthFile, String inflationFile, String year) throws Exception{
        CountryList oecdlist = new CountryList();
        AVLTree<String, TempCountry> table = new AVLTree<>();
        SequenceList<String> countryNames = new SequenceList<>(100);

        readFile(GDPFile, year, oecdlist, table, countryNames, "GDP");
        readFile(growthFile, year, oecdlist, table, countryNames, "GROWTH");
        readFile(inflationFile, year, oecdlist, table, countryNames, "INFLATION");

        SequenceList<Country> countries = new SequenceList<Country>(100);

        for(int i = 0; i < countryNames.length(); i++){
            String countryName = countryNames.get(i);
            TempCountry temp =table.get(countryName);
            if (temp.isComplete()){
                Country c = new Country(temp.countryName, temp.nominalGDP, temp.GDPGrowthRate, temp.inflationRate);;
                countries.insert(c);
            }
        }
        return countries;
    }

    private void readFile(String file, String year, CountryList choiceCountries, AVLTree<String, TempCountry> table, SequenceList<String> countryNames, String dataType) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String topicLine = reader.readLine();
        String[] topicList = splitLine(topicLine);

        int countryNameIndex = -1;
        int yearIndex = -1;
        int valueIndex = -1;

        for(int i = 0; i < topicList.length; i++){
            String topic = topicList[i].trim().toUpperCase();
            if(topic.equals("REF_AREA_LABEL")){
                countryNameIndex = i;
            }else if(topic.equals("TIME_PERIOD")){
                yearIndex = i;
            } else if(topic.equals("OBS_VALUE")){
                valueIndex = i;
            }
        }

        String line;
        while((line = reader.readLine()) != null){
            String[] dataList = splitLine(line);

            if (dataList.length <= valueIndex) {
                continue;
            }

            String countryName = dataList[countryNameIndex].trim();
            String yearDatum = dataList[yearIndex].trim();
            String gottenValue = dataList[valueIndex].trim();

            if(!choiceCountries.isOECD(countryName)){
                continue;
            }

            if(!yearDatum.equals(year)){
                continue;
            }

            double value = Double.parseDouble(gottenValue);
            TempCountry temp = table.get(countryName);
            if(temp == null){
                temp = new TempCountry(countryName);
                table.put(countryName, temp);
                countryNames.insert(countryName);
            }

            if(dataType.equals("GDP")){
                temp.nominalGDP = value;
            } else if(dataType.equals("GROWTH")){
                temp.GDPGrowthRate = value;
            } else if(dataType.equals("INFLATION")){
                temp.inflationRate = value;
            }
        }
        reader.close();

    }

    private String[] splitLine(String line){
        SequenceList<String> parts = new SequenceList<String>(100);
        String part = "";
        boolean protection = false;

        for(int i = 0; i < line.length(); i++){
            char ch = line.charAt(i);
            if(ch == '"'){
                protection = !protection;
            }
            else if(ch == ',' && !protection){
                parts.insert(part);
                part = "";
            }
            else{
                part = part + ch;
            }
        }
        parts.insert(part);

        String[] result = new String[parts.length()];
        for (int i = 0; i < parts.length(); i++){
            result[i] = parts.get(i);
        }
        return result;
    }
}
