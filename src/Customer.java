import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private String address;
    private String email;
    private String phoneNumber;
    private String accountNumber;
    private String dateOfBirth;
    private List<BankAccount> accounts; // Collection to store associated accounts

    public Customer() {
        // Default constructor
        this.accounts = new ArrayList<>(); // Initialize the list
    }

    public Customer(String firstName, String lastName, String username, String password,
                    String address, String email, String phoneNumber, String accountNumber, String dateOfBirth) {
        super(firstName, lastName, username, password);
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accountNumber = accountNumber;
        this.dateOfBirth = dateOfBirth;
        this.accounts = new ArrayList<>(); // Initialize the list
    }

    // Getters and setters for additional fields

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Getters and setters for the account list

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    // Method to add an account to the customer
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    // Method to remove an account from the customer
    public void removeAccount(BankAccount account) {
        accounts.remove(account);
    }
}

