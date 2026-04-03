public class Test {
    public static void main(String[] args){
        dayA();    // basic class test
        dayB();    // get the data
    }

    private static void dayA(){
        CountryList oecdList = new CountryList();
        System.out.println("The " + oecdList.getCountryListNumber() + " OCED Countries: ");
        System.out.println(oecdList);

        System.out.println("-------------------");
        System.out.println("Is OECD?");

        System.out.println("Japan: " + (oecdList.isOECD("Japan") ? "Yes" : "No"));
        System.out.println("China: " + (oecdList.isOECD("China") ? "Yes" : "No"));
    }

    private static void dayB(){
        DataExtractor DE = new DataExtractor();
        String CPIFile = "src/Z_CPI.csv";
        String GDPFile = "src/Z_GDP.csv";
        String growthFile = "src/Z_Growth.csv";

        try{
            SequenceList<Country> testData = DE.extractCountry(GDPFile, growthFile, CPIFile, "2023");
            for (Country c : testData){
                System.out.println("----------------");
                System.out.println(c);
            }

        }catch (Exception e){
            System.out.println("Error happen");
        }
    }
}
