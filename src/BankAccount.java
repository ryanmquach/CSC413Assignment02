import java.time.LocalDateTime;

abstract class BankAccount implements Comparable<BankAccount> {
    private String accountNumber;
    private double balance;
    private Customer owner;
    private LocalDateTime creationTime;

    public BankAccount(String accountNumber, double balance, Customer owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
        this.creationTime = LocalDateTime.now(); // Set the creation time to the current time
    }

    // Getters and setters for account number, balance, owner, and creation time

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

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public int compareTo(BankAccount other) {
        // Compare based on creation time first
        int compareCreationTime = this.creationTime.compareTo(other.creationTime);
        if (compareCreationTime != 0) {
            return compareCreationTime;
        }

        // If creation times are equal, compare based on balance
        return Double.compare(this.balance, other.balance);
    }
}

