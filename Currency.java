
public class Currency {
    private String name;
    private double value;
    private String country;

    public Currency(String name, double value, String country) {
        this.name = name;
        this.value = value;
        this.country = country;
    }
    public String currencyRepresentation(){
        return "Currency: " + this.name + "\nValue: " + this.value + "\nCountry: " + this.country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

//    public static void main(String[] args) {
//        Currency moeda1 = new Currency("real", 3.5, "Brasil");
//        System.out.println(moeda1.currencyRepresentation());
//    }
}

