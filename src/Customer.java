import java.util.List;

public class Customer extends User {
    private List<Account> accounts;
    private List<String> accountNumbers;

    // Constructors
    public Customer() {
        super(); // Call superclass constructor
    }

    public Customer(String username, String email, String phone, String sex, String birthday, String password, int id, List<Account> accounts, List<String> accountNumbers) {
        super(username, email, phone, sex, birthday, password, id); // Call superclass constructor
        this.accounts = accounts;
        this.accountNumbers = accountNumbers;
    }

    // Getters and setters
    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<String> getAccountNumbers() {
        return accountNumbers;
    }

    public void setAccountNumbers(List<String> accountNumbers) {
        this.accountNumbers = accountNumbers;
    }
}

