
// abstract base class for users
public abstract class User {
    private final int id;
    private String name;
    private String email;
    private String password;

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    
    public boolean checkPassword(String attempt) {
        return password.equals(attempt);
    }
    protected void setPassword(String newPassword) {
        this.password = newPassword;
    }
   
}


// testing commit
