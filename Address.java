public class Address {
    private String address1;
    private String address2;
    private String zipCode;
    private String state;

    Address() {
        this.address1 = "";
        this.address2 = "";
        this.zipCode = "";
        this.state = "";
    }
    
    Address(String address1, String address2, String zipCode, String state) {
        this.address1 = address1;
        this.address2 = address2;
        this.zipCode = zipCode;
        this.state = state;
    }

    public String getAddress1() {
        return this.address1;
    }

    public String getAddress2() {
        return this.address2;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public String getState() {
        return this.state;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String toString() {
        String address = this.getAddress1() + ", ";
        address += this.getAddress2() + ", ";
        address += this.getZipCode() + ", ";
        address += this.getState();
        return address;
    }
}
