public class Country {
    private String name;
    private double nominalGDP;
    private double GDPGrowthRate;
    private double inflationRate;

    public Country(String name, double nominalGDP, double GDPGrowthRate, double inflationRate){
        this.name = name;
        this.nominalGDP = nominalGDP;
        this.GDPGrowthRate = GDPGrowthRate;
        this.inflationRate = inflationRate;
    }

    public String getName(){
        return name;
    }

    public double getNominalGDP(){
        return nominalGDP;
    }

    public double getGDPGrowthRate(){
        return GDPGrowthRate;
    }

    public double getInflationRate(){
        return inflationRate;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setInflationRate(double inflationRate){
        this.inflationRate = inflationRate;
    }

    public void setGDPGrowthRate(double GDPGrowthRate){
        this.GDPGrowthRate = GDPGrowthRate;
    }

    public void setNominalGDP(double nominalGDP){
        this.nominalGDP = nominalGDP;
    }
}
