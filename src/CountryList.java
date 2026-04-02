public class CountryList {
    private SequenceList<String> countryList;

    public CountryList(){
        countryList = new SequenceList<String>(50);
        OECDCountryList();
    }

    private void OECDCountryList(){
        countryList.insert("Australia");
        countryList.insert("Austria");
        countryList.insert("Belgium");
        countryList.insert("Canada");
        countryList.insert("Chile");
        countryList.insert("Colombia");
        countryList.insert("Costa Rica");
        countryList.insert("Czech Republic");
        countryList.insert("Denmark");
        countryList.insert("Estonia");
        countryList.insert("Finland");
        countryList.insert("France");
        countryList.insert("Germany");
        countryList.insert("Greece");
        countryList.insert("Hungary");
        countryList.insert("Iceland");
        countryList.insert("Ireland");
        countryList.insert("Israel");
        countryList.insert("Italy");
        countryList.insert("Japan");
        countryList.insert("Korea");
        countryList.insert("Latvia");
        countryList.insert("Lithuania");
        countryList.insert("Luxembourg");
        countryList.insert("Mexico");
        countryList.insert("Netherlands");
        countryList.insert("New Zealand");
        countryList.insert("Norway");
        countryList.insert("Poland");
        countryList.insert("Portugal");
        countryList.insert("Slovak Republic");
        countryList.insert("Slovenia");
        countryList.insert("Spain");
        countryList.insert("Sweden");
        countryList.insert("Switzerland");
        countryList.insert("Türkiye");
        countryList.insert("United Kingdom");
        countryList.insert("United States");
    }

    public boolean isOECD(String countryName){
        return countryList.indexOf(countryName) != -1;
    }

    public int getCountryListNumber(){
        return countryList.length();
    }

    @Override
    public String toString(){
        String result = "";

        for(String country : countryList){
            result = result + country + "\n";
        }

        return result.trim();
    }
}
