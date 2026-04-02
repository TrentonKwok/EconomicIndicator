public class Test {
    public static void main(String[] args){
        CountryList oecdList = new CountryList();
        System.out.println("The " + oecdList.getCountryListNumber() + " OCED Countries: ");
        System.out.println(oecdList);

        System.out.println("-------------------");
        System.out.println("Is OECD?");

        System.out.println("Japan: " + (oecdList.isOECD("Japan") ? "Yes" : "No"));
        System.out.println("China: " + (oecdList.isOECD("China") ? "Yes" : "No"));
    }
}
