

public class Customer extends User {
    private String address;

    public Customer(int id, String name, String email, String password, String address) {
        super(id, name, email, password);
        this.address = address;
    }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}

