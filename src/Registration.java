public class Registration {
    private Security security;
    private LListPriorityQueue<BankAccount> priorityQueue;

    public Registration(Security security, LListPriorityQueue<BankAccount> priorityQueue) {
        this.security = security;
        this.priorityQueue = priorityQueue;
    }

    public void registerCustomer(String username, String password, String securityQuestion, String securityAnswer,
                                 String firstName, String lastName, String address, String email,
                                 String phoneNumber, String accountNumber, String dateOfBirth) {
        // Register the user's credentials and security information
        security.registerUser(username, password, securityQuestion, securityAnswer);

        // Create a new bank account
        Customer customer = new Customer(firstName, lastName, username, password, address, email, phoneNumber,
                accountNumber, dateOfBirth, securityQuestion, securityAnswer);
        BankAccount bankAccount = new BankAccount(accountNumber, 0.0, customer);

        // Add the bank account to the priority queue
        priorityQueue.add(bankAccount);
    }
}




