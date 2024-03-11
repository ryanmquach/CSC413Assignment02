public class CheckingsAccount extends BankAccount {
    private boolean overdraftProtection;

    public CheckingsAccount(String accountNumber, double balance, Customer owner) {
        super(accountNumber, balance, owner);
    }

    public boolean isOverdraftProtection() {
        return overdraftProtection;
    }

    public void setOverdraftProtection(boolean overdraftProtection) {
        this.overdraftProtection = overdraftProtection;
    }

    @Override
    public String toString() {
        return "Checking Account - " + super.toString();
    }
}
