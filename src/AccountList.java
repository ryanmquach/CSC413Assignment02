import java.util.ArrayList;
import java.util.List;

public class AccountList {
    private List<Account> accounts;

    // Constructor
    public AccountList() {
        this.accounts = new ArrayList<>();
    }

    // Method to add an account to the list
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Method to remove an account from the list
    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    // Method to retrieve all accounts from the list
    public List<Account> getAccounts() {
        return accounts;
    }
}

