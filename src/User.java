public class User {

    private String firstName;
    private String lastName;
    private String username;

    private int id;
    private String password;

    // Constructors
    public User() {
        // Default constructor
    }

    public User(String firstName, String lastName, String username, int id, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.id = id;
        this.password = password;
    }

    // Getters and setters

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }




    public double getBalance() {
        return 0;
    }
}
