package assignment3;

enum State {NSW, QLD, SA, TAS, VIC, WA};
public class Address 
{
    private int unit;
    private int street_no;
    private String streetName;
    private String suburb;
    private String city;
    private State state;
    private int postCode;

    public Address(int unit, int street_no, String streetName, String suburb, String city, State state, int postCode) 
    {
        this.unit = unit;
        this.street_no = street_no;
        this.streetName = streetName;
        this.suburb = suburb;
        this.city = city;
        this.state = state;
        this.postCode = postCode;
    }

    public int getUnit() {
        return unit;
    }

    public int getStreet_no() {
        return street_no;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getCity() {
        return city;
    }

    public State getState() {
        return state;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public void setStreet_no(int street_no) {
        this.street_no = street_no;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return String.format("%d,%d,%s,%s,%s,%s,%d", unit,street_no, streetName, suburb, city, state, postCode);
    }
    
    
}
