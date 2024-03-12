import java.util.ArrayList;
import java.util.List;

public class Customer extends User implements Comparable<Customer> {
    private String address;
    private String email;
    private String phoneNumber;
    private String accountNumber;
    private String dateOfBirth;
    private String securityQuestion;
    private String securityAnswer;
    private List<BankAccount> accounts; // Collection to store associated accounts

    public Customer() {
        // Default constructor
        this.accounts = new ArrayList<>(); // Initialize the list
    }

    public Customer(String firstName, String lastName, String username, String password,
                    String address, String email, String phoneNumber, String accountNumber,
                    String dateOfBirth, String securityQuestion, String securityAnswer) {
        super(firstName, lastName, username, password);
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accountNumber = accountNumber;
        this.dateOfBirth = dateOfBirth;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
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

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    // Getters and setters for the account list

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    // Method to add an account to the customer and the priority queue

    public void addAccount(BankAccount account, String accountType, LListPriorityQueue<BankAccount> priorityQueue) {
        accounts.add(account);
        priorityQueue.add(account);

    }

    // Method to remove an account from the customer and the priority queue
    public void removeAccount(BankAccount account, LListPriorityQueue<BankAccount> priorityQueue) {
        accounts.remove(account);
        priorityQueue.remove(account);
        // You might need to remove the account from the priority queue as well if needed
    }

    // Method to retrieve the checking account of the customer
    public BankAccount getCheckingAccount() {
        for (BankAccount account : accounts) {
            if (account instanceof CheckingsAccount) {
                return account;
            }
        }
        return null; // Return null if no checking account is found
    }

    // Method to retrieve the savings account of the customer
    public BankAccount getSavingsAccount() {
        for (BankAccount account : accounts) {
            if (account instanceof SavingsAccount) {
                return account;
            }
        }
        return null; // Return null if no savings account is found
    }

    @Override
    public int compareTo(Customer o) {
        return 0;
    }

    @Override
    public String toString() {
        String customerString =
                "Name: " + getFirstName() + " " + getLastName() +
                        ", Username: " + getUsername() +
                        ", Address: " + getAddress() + "\n" + // New line after the address
                        "Email: " + getEmail() +
                        ", Phone Number: " + getPhoneNumber() +
                        ", Account Number: " + getAccountNumber() +
                        ", Date of Birth: " + getDateOfBirth() + "\n" +
                        "Security Question: " + getSecurityQuestion() +
                        ", Security Answer: " + getSecurityAnswer();
        return customerString;
    }

}


