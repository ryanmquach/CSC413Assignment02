import java.util.Iterator;

public class Main{
    public static void main(String[] args) {
        // 1. Start with an empty priority queue
        LListPriorityQueue<BankAccount> priorityQueue = new LListPriorityQueue<>();
        Teller teller = new Teller();

        // 2. Create Customer 1 with a checking account with $200
        Customer customer1 = new Customer("John", "Doe", "john.doe", "password", "123 Main St", "john.doe@example.com", "1234567890", "C001", "01-01-1980", "What is your favorite color?", "Blue");
        CheckingsAccount checkingAccount1 = new CheckingsAccount("C001A001", 200, customer1);
        // Add checking account to Customer 1
        customer1.addAccount(checkingAccount1, "Checking", priorityQueue);


        // 3. Show the updated list
        System.out.println("Updated list after creating Customer 1:");
        printPriorityQueue(priorityQueue);

        // 4. Create Customer 2 with a checking and savings account, both with $200 each
        Customer customer2 = new Customer("Jane", "Smith", "jane.smith", "password", "456 Oak St", "jane.smith@example.com", "9876543210", "C002", "02-02-1990", "What is your pet's name?", "Fluffy");
        CheckingsAccount checkingAccount2 = new CheckingsAccount("C002A001", 200, customer2);
        SavingsAccount savingsAccount2 = new SavingsAccount("C002A002", 200, customer2);
        customer2.addAccount(checkingAccount2, "Checking", priorityQueue);
        customer2.addAccount(savingsAccount2, "Savings", priorityQueue);

        // 5. Show the updated list
        System.out.println("Updated list after creating Customer 2:");
        printPriorityQueue(priorityQueue);

        // 6. Create Customer 3 with a savings account with $100
        Customer customer3 = new Customer("Alice", "Johnson", "alice.johnson", "password", "789 Pine St", "alice.johnson@example.com", "5551234567", "C003", "03-03-2000", "What is your mother's maiden name?", "Smith");
        SavingsAccount savingsAccount3 = new SavingsAccount("C003A001", 100, customer3);
        // Add savings account to Customer 3
        customer3.addAccount(savingsAccount3, "Savings", priorityQueue);

        // 7. Show the updated list
        System.out.println("Updated list after creating Customer 3:");
        printPriorityQueue(priorityQueue);

        // 8. // Perform transactions
        // Withdraw $50 from Customer 1's checking account
        teller.withdraw(customer1.getCheckingAccount(), 50);

        // Transfer $100 from Customer 2's checking to Customer 3's savings
        teller.transfer(customer2.getCheckingAccount(), customer3.getSavingsAccount(), 100);

        // Deposit $150 to Customer 2's savings account
        teller.deposit(customer2.getSavingsAccount(), 150);

        // 9. Show transaction details
        System.out.println("Transaction details:");
        // You would need to implement this part based on your Transaction class implementation
    }

    // Utility method to print the priority queue
    private static void printPriorityQueue(LListPriorityQueue<BankAccount> priorityQueue) {
        System.out.println("Priority Queue:");
        Iterator<BankAccount> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            BankAccount account = iterator.next();
            System.out.println(account.toString());
        }
    }
}
