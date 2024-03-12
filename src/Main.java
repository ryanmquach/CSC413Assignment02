import java.lang.*;
import java.io.*;
import java.util.List;
import java.util.Iterator;
import java.net.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.type.TypeReference;

import javax.json.stream.*;
import javax.json.JsonReader;
import javax.json.JsonObject;
import javax.json.JsonArray;
import javax.json.Json;

public class Main {

    static ObjectMapper objectMapper = null;

    static String jsonCustomerString = "{ \"firstName\" : \"Alice\", \"lastName\" : \"Johnson\", \"username\" : \"alice.johnson\"," +
            " \"password\" : \"password\", \"address\" : \"123 Main St\", \"email\" : \"alice.johnson@example.com\", \"phoneNumber\" :" +
            " \"1234567890\", \"accountNumber\" : \"C001\", \"dateOfBirth\" : \"01-01-1980\", \"securityQuestion\" : \"What is your favorite color?\"," +
            " \"securityAnswer\" : \"Blue\" }";
    static String jsonCustomersString = "[{ \"firstName\" : \"Alice\", \"lastName\" : \"Johnson\", \"username\" : \"alice.johnson\", " +
            "\"password\" : \"password\", \"address\" : \"123 Main St\", \"email\" : \"alice.johnson@example.com\", \"phoneNumber\" : " +
            "\"1234567890\", \"accountNumber\" : \"C001\", \"dateOfBirth\" : \"01-01-1980\", \"securityQuestion\" : \"What is your favorite color?\", " +
            "\"securityAnswer\" : \"Blue\" }, { \"firstName\" : \"Bob\", \"lastName\" : \"Smith\", \"username\" : \"bob.smith\", \"password\" : \"password\"," +
            " \"address\" : \"456 Oak St\", \"email\" : \"bob.smith@example.com\", \"phoneNumber\" : \"9876543210\", \"accountNumber\" : \"C002\", \"dateOfBirth\" :" +
            " \"02-02-1990\", \"securityQuestion\" : \"What is your pet's name?\", \"securityAnswer\" : \"Fluffy\" }]";

    public static void main(String[] args) {
        // Start with an empty priority queue
        LListPriorityQueue<BankAccount> priorityQueue = LListPriorityQueue.getInstance();
        Teller teller = new Teller();

        // Create Customer 1 with a checking account with $100
        Customer customer1 = new Customer("Alice", "Johnson", "alice.johnson", "password", "123 Main St", "alice.johnson@example.com", "1234567890", "C001", "01-01-1980", "What is your favorite color?", "Blue");
        CheckingsAccount checkingAccount1 = new CheckingsAccount("C001A001", 100, customer1);
        // Add checking account to Customer 1
        customer1.addAccount(checkingAccount1, "Checking", priorityQueue);
        System.out.println("Account created successfully for Customer 1");

        // Show the updated list
        System.out.println("Updated list after creating Customer 1");
        printPriorityQueue(priorityQueue);
        System.out.println(); // Add spacing after printing the priority queue

        // Create Customer 2 with a checking and savings account, both with $300 each
        Customer customer2 = new Customer("Bob", "Smith", "bob.smith", "password", "456 Oak St", "bob.smith@example.com", "9876543210", "C002", "02-02-1990", "What is your pet's name?", "Fluffy");
        CheckingsAccount checkingAccount2 = new CheckingsAccount("C002A001", 300, customer2);
        SavingsAccount savingsAccount2 = new SavingsAccount("C002A002", 300, customer2);
        customer2.addAccount(checkingAccount2, "Checking", priorityQueue);
        customer2.addAccount(savingsAccount2, "Savings", priorityQueue);
        System.out.println("Account created successfully for Customer 2");

        // Show the updated list
        System.out.println("Updated list after creating Customer 2");
        printPriorityQueue(priorityQueue);
        System.out.println(); // Add spacing after printing the priority queue

        // Create Customer 3 with a savings account with $200
        Customer customer3 = new Customer("Charlie", "Brown", "charlie.brown", "password", "789 Pine St", "charlie.brown@example.com", "5551234567", "C003", "03-03-2000", "What is your mother's maiden name?", "Smith");
        SavingsAccount savingsAccount3 = new SavingsAccount("C003A001", 200, customer3);
        // Add savings account to Customer 3
        customer3.addAccount(savingsAccount3, "Savings", priorityQueue);
        System.out.println("Account created successfully for Customer 3");

        // Show the updated list
        System.out.println("Updated list after creating Customer 3");
        printPriorityQueue(priorityQueue);
        System.out.println(); // Add spacing after printing the priority queue

        // Create Customer 4 with a checking account with $250
        Customer customer4 = new Customer("David", "Lee", "david.lee", "password", "101 Elm St", "david.lee@example.com", "9998887777", "C004", "04-04-2010", "What city were you born in?", "New York");
        CheckingsAccount checkingAccount4 = new CheckingsAccount("C004A001", 250, customer4);
        // Add checking account to Customer 4
        customer4.addAccount(checkingAccount4, "Checking", priorityQueue);
        System.out.println("Account created successfully for Customer 4");

        // Show the updated list
        System.out.println("Updated list after creating Customer 4");
        printPriorityQueue(priorityQueue);
        System.out.println(); // Add spacing after printing the priority queue

        // Perform transactions
        System.out.println("Now testing transaction functionalities...");
        // Withdraw $50 from Customer 1's checking account
        teller.withdraw(customer1.getCheckingAccount(), 50);
        System.out.println("Withdrawal of $50 from Customer 1's checking account successful");

        // Transfer $100 from Customer 2's checking to Customer 2's savings
        teller.transfer(customer2.getCheckingAccount(), customer2.getSavingsAccount(), 100);
        System.out.println("Transfer of $100 from Customer 2's checking to Customer 2's savings successful");

        // Deposit $50 to Customer 3's savings account
        teller.deposit(customer3.getSavingsAccount(), 50);
        System.out.println("Deposit of $50 to Customer 3's savings account successful");

        // Transfer $50 from Customer 3's savings to Customer 4's checking
        teller.transfer(customer3.getSavingsAccount(), customer4.getCheckingAccount(), 50);
        System.out.println("Transfer of $50 from Customer 3's savings to Customer 4's checking successful");

        // Show JSON strings for each customer
        System.out.println();
        System.out.println("JSON strings for each customer:");
        // You would need to implement this part based on your Transaction class implementation

        // Delete Customer 2's checking account
        customer2.removeAccount(checkingAccount2, priorityQueue);
        System.out.println("Customer 2's checking account deleted successfully");

        // Show the updated list
        System.out.println("Updated list after deleting Customer 2's checking account");
        printPriorityQueue(priorityQueue);


        // Attempt login with invalid credentials
        System.out.println();
        System.out.println("Attempting login with invalid credentials of 'invalidUsername' and 'invalidPassword'...");
        LoginFunction loginFunction = new LoginFunction(new Security());
        loginFunction.login("invalidUsername", "invalidPassword");


        objectMapper = new ObjectMapper();

        System.out.println();
        System.out.println("\nCreating separate Customer object to perform JSON test requirement in assignment");

        // Create Customer object
        Customer customer = new Customer("Alice", "Johnson", "alice.johnson", "password",
            "123 Main St", "alice.johnson@example.com", "1234567890", "C001",
            "01-01-1980", "What is your favorite color?", "Blue");
        String customerString = "";

        // Convert Customer object to JSON string
            try {
            customerString = objectMapper.writeValueAsString(customer);
        } catch (JsonProcessingException jpe) {
        System.out.println(jpe.getMessage());
        }

        System.out.println("\nJSON String version of Customer object\n" + customerString);

        try {
        // Parse JSON strings to JsonNode
        JsonNode jsonNode1 = objectMapper.readTree(jsonCustomerString);
        JsonNode jsonNode2 = objectMapper.readTree(jsonCustomersString);

        // Accessing JSON properties
        String firstName = jsonNode1.get("firstName").asText();
        String lastName = jsonNode1.get("lastName").asText();
        String username = jsonNode1.get("username").asText();
        String email = jsonNode1.get("email").asText();
        String phoneNumber = jsonNode1.get("phoneNumber").asText();
        String accountNumber = jsonNode1.get("accountNumber").asText();
        String dateOfBirth = jsonNode1.get("dateOfBirth").asText();
        String securityQuestion = jsonNode1.get("securityQuestion").asText();
        String securityAnswer = jsonNode1.get("securityAnswer").asText();

        System.out.println("\nSingle Customer Detail JSON String:");
        String treeString = jsonNode1.toPrettyString();
        System.out.println(treeString);

        System.out.println("\nMultiple Customer Detail JSON String:");
        treeString = jsonNode2.toPrettyString();
        System.out.println(treeString);

        System.out.println("\nNow printing each customer detail: ");

        Iterator<JsonNode> it = jsonNode2.elements();
        while (it.hasNext()) {
            JsonNode jNode = it.next();

            // Printing JSON properties for the current node
            System.out.println("\nName: " + jNode.get("firstName").asText() + " " + jNode.get("lastName").asText());
            System.out.println("Username: " + jNode.get("username").asText());
            System.out.println("Email: " + jNode.get("email").asText());
            System.out.println("Phone Number: " + jNode.get("phoneNumber").asText());
            System.out.println("Account Number: " + jNode.get("accountNumber").asText());
            System.out.println("Date of Birth: " + jNode.get("dateOfBirth").asText());
            System.out.println("Security Question: " + jNode.get("securityQuestion").asText());
            System.out.println("Security Answer: " + jNode.get("securityAnswer").asText());
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    // Working with Customer Objects
    readJsonCustomer();
    readJsonCustomers();
}

    public static void readJsonCustomer() {
        Customer customerObj = null;

        try {
            customerObj = objectMapper.readValue(jsonCustomerString, Customer.class);
        } catch (JsonProcessingException jpe) {
            System.out.println(jpe.getMessage());
        }

        // Getting data from Customer object created from JSON String
        System.out.println("\nReading data from JSON String of single customer:");
        if (customerObj != null) {
            System.out.println(customerObj.toString());
        }
    }

    public static void readJsonCustomers() {
        List<Customer> customerList = null;

        try {
            customerList = objectMapper.readValue(jsonCustomersString, new TypeReference<List<Customer>>() {
            });
        } catch (JsonProcessingException jpe) {
            System.out.println(jpe.getMessage());
        }

        System.out.println("\nReading data from multiple customers in JSON array:");
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }

    // Utility method to print the priority queue
    private static void printPriorityQueue(LListPriorityQueue<BankAccount> priorityQueue) {
        System.out.println("Priority Queue:");
        Iterator iterator = priorityQueue.new PQIterator();
        while (iterator.hasNext()) {
            BankAccount account = (BankAccount) iterator.next();
            System.out.println(account.toString());
        }
    }
}


