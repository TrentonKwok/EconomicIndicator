public class CountryList {
    private SequenceList<String> countryList;
    private String group;

    public static final String[] ALL_GROUPS = {
            "OECD", "G7", "G20", "BRICS", "EU", "CPTPP", "DEVELOPED", "DEVELOPING", "CUSTOM"
    };

    public CountryList(String group){
        countryList = new SequenceList<String>(50);
        this.group = group;

        if(group.equals("OECD")){
            addOECD();
        }else if(group.equals("G7")){
            addG7();
        }else if(group.equals("G20")){
            addG20();
        }else if(group.equals("BRICS")){
            addBRICS();
        }else if(group.equals("EU")){
            addEU();
        }else if(group.equals("CPTPP")){
            addCPTPP();
        }else if(group.equals("DEVELOPED")){
            addDeveloped();
        }else if(group.equals("DEVELOPING")){
            addDeveloping();
        }else if(group.equals("CUSTOM")){
        }else{
            throw new RuntimeException("Unknown group");
        }
    }

    public void addCountry(String name){
        if(countryList.indexOf(name) == -1){
            countryList.insert(name);
        }
    }

    public boolean contains(String countryName){
        return countryList.indexOf(countryName) != -1;
    }

    public String getGroup(){
        return group;
    }

    private void addOECD(){
        String[] arr = {
                "Australia", "Austria", "Belgium", "Canada", "Chile", "Colombia", "Costa Rica", "Czechia", "Denmark", "Estonia",
                "Finland", "France", "Germany", "Greece", "Hungary", "Iceland", "Ireland", "Israel", "Italy", "Japan",
                "Korea, Rep.", "Latvia", "Lithuania", "Luxembourg", "Mexico", "Netherlands", "New Zealand", "Norway", "Poland", "Portugal",
                "Slovak Republic", "Slovenia", "Spain", "Sweden", "Switzerland", "Türkiye", "United Kingdom", "United States"
        };
        for(int i = 0; i < arr.length; i++){
            countryList.insert(arr[i]);
        }
    }

    private void addG7(){
        String[] arr = {
                "Canada", "France", "Germany", "Italy",
                "Japan", "United Kingdom", "United States"
        };
        for(int i = 0; i < arr.length; i++){
            countryList.insert(arr[i]);
        }
    }

    private void addG20(){
        String[] arr = {
                "Argentina", "Australia", "Brazil", "Canada", "China", "France", "Germany", "India", "Indonesia", "Italy",
                "Japan", "Korea, Rep.", "Mexico", "Russian Federation", "Saudi Arabia", "South Africa", "Türkiye", "United Kingdom", "United States"
        };
        for(int i = 0; i < arr.length; i++){
            countryList.insert(arr[i]);
        }
    }

    private void addBRICS(){
        String[] arr = {
                "Brazil", "Russian Federation", "India", "China", "South Africa"
        };
        for(int i = 0; i < arr.length; i++){
            countryList.insert(arr[i]);
        }
    }

    private void addEU(){
        String[] arr = {
                "Austria", "Belgium", "Bulgaria", "Croatia", "Cyprus", "Czechia", "Denmark", "Estonia", "Finland", "France",
                "Germany", "Greece", "Hungary", "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands",
                "Poland", "Portugal", "Romania", "Slovak Republic", "Slovenia", "Spain", "Sweden"
        };
        for(int i = 0; i < arr.length; i++){
            countryList.insert(arr[i]);
        }
    }

    private void addCPTPP(){
        String[] arr = {
                "Australia", "Brunei Darussalam", "Canada", "Chile", "Japan",
                "Malaysia", "Mexico", "New Zealand", "Peru", "Singapore",
                "United Kingdom", "Vietnam"
        };
        for(int i = 0; i < arr.length; i++){
            countryList.insert(arr[i]);
        }
    }

    private void addDeveloped(){
        String[] arr = {
                "Andorra", "Australia", "Austria", "Belgium", "Canada", "Croatia", "Cyprus", "Czechia", "Denmark", "Estonia",
                "Finland", "France", "Germany", "Greece", "Hong Kong SAR, China", "Iceland", "Ireland", "Israel", "Italy", "Japan",
                "Korea, Rep.", "Latvia", "Lithuania", "Luxembourg", "Macao SAR, China", "Malta", "Netherlands", "New Zealand", "Norway", "Portugal",
                "Puerto Rico", "San Marino", "Singapore", "Slovak Republic", "Slovenia", "Spain", "Sweden", "Switzerland",
                "United Kingdom", "United States"
        };
        for(int i = 0; i < arr.length; i++){
            countryList.insert(arr[i]);
        }
    }

    private void addDeveloping(){
        String[] arr = {
                "Afghanistan", "Albania", "Algeria", "American Samoa", "Angola", "Antigua and Barbuda",
                "Argentina", "Armenia", "Aruba", "Azerbaijan", "Bahamas, The", "Bahrain",
                "Bangladesh", "Barbados", "Belarus", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegovina",
                "Botswana", "Brazil", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi",
                "Cabo Verde", "Cambodia", "Cameroon", "Cayman Islands", "Central African Republic", "Chad",
                "Channel Islands", "Chile", "China", "Colombia", "Comoros", "Congo, Dem. Rep.",
                "Congo, Rep.", "Costa Rica", "Cuba", "Curaçao", "Côte d'Ivoire", "Djibouti",
                "Dominica", "Dominican Republic", "Ecuador", "Egypt, Arab Rep.", "El Salvador", "Equatorial Guinea", "Eritrea", "Eswatini", "Ethiopia",
                "Faroe Islands", "Federal Republic of Somalia", "Fiji", "French Polynesia", "Gabon", "Gambia, The",
                "Georgia", "Ghana", "Greenland", "Grenada", "Guam", "Guatemala",
                "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary",
                "India", "Indonesia", "Iran, Islamic Rep.", "Iraq", "Isle of Man", "Jamaica", "Jordan", "Kazakhstan", "Kenya",
                "Kiribati", "Kosovo", "Kuwait", "Kyrgyz Republic", "Lao PDR", "Lebanon", "Lesotho", "Liberia", "Libya",
                "Liechtenstein", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Marshall Islands", "Mauritania", "Mauritius",
                "Mexico", "Micronesia, Fed. Sts.", "Moldova", "Monaco", "Mongolia", "Montenegro",
                "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "New Caledonia", "Nicaragua", "Niger", "Nigeria", "North Macedonia", "Northern Mariana Islands",
                "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland",
                "Qatar", "Romania", "Russian Federation", "Rwanda", "Samoa", "Saudi Arabia", "Senegal", "Serbia", "Seychelles",
                "Sierra Leone", "Sint Maarten (Dutch part)", "Solomon Islands", "South Africa", "South Sudan", "Sri Lanka",
                "St. Kitts and Nevis", "St. Lucia", "St. Martin (French part)", "St. Vincent and the Grenadines", "Sudan", "Suriname",
                "Syrian Arab Republic", "São Tomé and Príncipe", "Tajikistan",
                "Tanzania", "Thailand", "Timor-Leste", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkmenistan", "Turks and Caicos Islands",
                "Tuvalu", "Türkiye", "Uganda", "Ukraine", "United Arab Emirates", "Uruguay",
                "Uzbekistan", "Vanuatu", "Venezuela, RB", "Vietnam", "Virgin Islands (U.S.)", "West Bank and Gaza",
                "Yemen, Rep.", "Zambia", "Zimbabwe"
        };
        for(int i = 0; i < arr.length; i++){
            countryList.insert(arr[i]);
        }
    }

    public int getCountryListNumber(){
        return countryList.length();
    }

    public static String[] getAllAvailableCountries(){
        String[] groups = {"DEVELOPED", "DEVELOPING"};
        SequenceList<String> all = new SequenceList<String>(250);
        for(int g = 0; g < groups.length; g++){
            CountryList cl = new CountryList(groups[g]);
            for(int i = 0; i < cl.countryList.length(); i++){
                String name = cl.countryList.get(i);
                if(all.indexOf(name) == -1){
                    all.insert(name);
                }
            }
        }
        String[] result = new String[all.length()];
        for(int i = 0; i < all.length(); i++){
            result[i] = all.get(i);
        }

        selectionSort(result);
        return result;
    }

    @Override
    public String toString(){
        String result = "";

        for(String country : countryList){
            result = result + country + "\n";
        }

        return result.trim();
    }

    private static void selectionSort(String[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j].compareTo(arr[minIndex]) < 0){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                String tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
    }


}
