public class Admin extends User {
    // Constructors
    public Admin() {
        super(); // Call superclass constructor
    }

    public Admin(String username, String email, String phone, String sex, String birthday, String password, int id) {
        super(username, email, phone, sex, birthday, password, id); // Call superclass constructor
    }
}

