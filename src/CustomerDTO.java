import java.sql.SQLException;

public class CustomerDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String username;

    private String password;
    private String email;
    private String address;
    private String phoneNumber;
    private String accountNumber;
    private String dateOfBirth;
    private String securityQuestion;
    private String securityAnswer;

    static CustomerDAOConcrete customerDAO = new CustomerDAOConcrete();

    public CustomerDTO() {
        // Default constructor
    }

    public CustomerDTO(String firstName, String lastName, String username, int id, String password, String email, String address, String phoneNumber, String accountNumber, String dateOfBirth, String securityQuestion, String securityAnswer) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.id = id;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.accountNumber = accountNumber;
        this.dateOfBirth = dateOfBirth;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
    }

    // Getter and Setter methods
    // Getter and setter methods for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter methods for firstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and setter methods for lastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter and setter methods for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and setter methods for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // Getter and setter methods for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and setter methods for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and setter methods for phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Getter and setter methods for accountNumber
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Getter and setter methods for dateOfBirth
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Getter and setter methods for securityQuestion
    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    // Getter and setter methods for securityAnswer
    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    // Method to fetch customer by ID
    public static Customer getCustomerByID(int id) {
        Customer customer = null;
        try {
            customer = customerDAO.get(id);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        if(customer != null) {
            System.out.println(customer.toString());
        }
        return customer;
    }

    // Method to perform update on customer
    public static int performUpdate(Customer customer) {
        int updateResult = -1;
        try {
            updateResult = customerDAO.update(customer);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        if(updateResult != -1) {
            System.out.println("\nUpdate Successful");
            System.out.println("Customer Details:\n" + customer.toString());
        }
        return updateResult;
    }
}