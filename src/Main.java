public class Main {
    public static void main(String[] args) {
        // Create two mock users
        Customer user1 = new Customer("John", "Doe", "johndoe", "password",
                "123 Main St", "john@example.com", "123-456-7890",
                "123456789", "1990-01-01", "What's your pet's name?", "Fido");
        Customer user2 = new Customer("Jane", "Smith", "janesmith", "password",
                "456 Oak St", "jane@example.com", "987-654-3210",
                "987654321", "1985-05-15", "What's your mother's maiden name?", "Johnson");

        // Create bank accounts for users
        BankAccount checking1 = new CheckingsAccount("001", 1000, user1);
        BankAccount checking2 = new CheckingsAccount("002", 2000, user2);
        BankAccount savings = new SavingsAccount("003", 5000, user2);


        // Add accounts to users
        user1.addAccount(checking1);
        user2.addAccount(checking2);
        user2.addAccount(savings);

        // Test functionalities
        System.out.println("Initial balances:");
        System.out.println("User 1 checking balance: $" + checking1.getBalance());
        System.out.println("User 2 checking balance: $" + checking2.getBalance());
        System.out.println("User 2 savings balance: $" + savings.getBalance());

        // Perform transactions
        System.out.println("\nPerforming transactions:");
        System.out.println("Depositing $500 into User 1 checking account...");
        checking1.deposit(500);
        System.out.println("Withdrawing $200 from User 2 checking account...");
        checking2.withdraw(200);
        System.out.println("Transferring $1000 from User 2 checking to savings account...");
        checking2.transfer(savings, 1000);

        // Display updated balances
        System.out.println("\nUpdated balances:");
        System.out.println("User 1 checking balance: $" + checking1.getBalance());
        System.out.println("User 2 checking balance: $" + checking2.getBalance());
        System.out.println("User 2 savings balance: $" + savings.getBalance());
    }
}

