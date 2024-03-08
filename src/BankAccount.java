import java.util.Date;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private Customer customer; // Reference to the customer who owns this account
    private Date creationDate;

    public BankAccount(String accountNumber, double balance, Customer customer, Date creationDate) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
        this.creationDate = creationDate;
    }

    // Getters and setters

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}

