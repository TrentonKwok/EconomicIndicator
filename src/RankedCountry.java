public class RankedCountry implements Comparable<RankedCountry> {
    private Country country;
    private String datatype;

    public RankedCountry(Country country, String datatype){
        this.country = country;
        this.datatype = datatype;
    }

    public Country getCountry(){
        return country;
    }

    public String getDatatype(){
        return datatype;
    }

    public double getDataValue(){
        if (datatype.equals("GDP")){
            return country.getNominalGDP();
        }
        else if(datatype.equals("GROWTH")){
            return country.getGDPGrowthRate();
        }
        else if(datatype.equals("INFLATION")){
            return country.getInflationRate();
        }
        else{
            throw new RuntimeException("Incorrect datatype");
        }
    }

    @Override
    public int compareTo(RankedCountry other){
        double thisValue = this.getDataValue();
        double otherValue = other.getDataValue();

        if(thisValue > otherValue){
            return -1;
        }
        else if (thisValue < otherValue){
            return 1;
        }
        else{
            return this.country.getName().compareTo(other.country.getName());
        }
    }

    @Override
    public String toString(){
        return country.getName() + ": " + getDataValue();
    }
}