public class Registration {
    private Security security; // Reference to the Security object
    private LListPriorityQueue<BankAccount> priorityQueue; // Reference to the priority queue

    // Constructor to initialize the RegistrationFunction with a Security object and a priority queue
    public Registration(Security security, LListPriorityQueue<BankAccount> priorityQueue) {
        this.security = security;
        this.priorityQueue = priorityQueue;
    }

    // Method to register a new user with provided details
    public void registerUser(String firstName, String lastName, String username, int id, String password,
                             String address, String email, String phoneNumber, String accountNumber,
                             String dateOfBirth, String securityQuestion, String securityAnswer,
                             String accountType) {
        // Attempt to register the user
        security.registerUser(username, password);

        // Create a new Customer object with provided details
        Customer newCustomer = new Customer(firstName, lastName, username, id, password,
                address, email, phoneNumber, accountNumber,
                dateOfBirth, securityQuestion, securityAnswer);

        // Based on the account type chosen, create the corresponding account
        BankAccount newAccount;
        if (accountType.equalsIgnoreCase("Checking")) {
            newAccount = new CheckingsAccount(generateAccountNumber(), 0, newCustomer);
        } else if (accountType.equalsIgnoreCase("Savings")) {
            newAccount = new SavingsAccount(generateAccountNumber(), 0, newCustomer);
        } else {
            // Handle other account types or throw an exception for invalid types
            System.out.println("Invalid account type specified.");
            return;
        }

        // Add the new account to the customer
        newCustomer.addAccount(newAccount, accountType, priorityQueue);

        System.out.println("User registration successful for username: " + username);
    }

    // Method to generate a unique account number (You may implement your own logic here)
    private String generateAccountNumber() {
        // Implement your logic to generate a unique account number
        return "C" + System.currentTimeMillis(); // Example: Concatenating "C" with current timestamp
    }
}





