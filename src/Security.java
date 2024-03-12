import java.util.HashMap;
import java.util.Map;

public class Security {
    private Map<String, String> userCredentials; // Map of username to password

    public Security() {
        userCredentials = new HashMap<>();
    }

    // Method to register a new user with their credentials
    public void registerUser(String username, String password) {
        userCredentials.put(username, password);
    }

    // Method to authenticate a user upon login
    public boolean authenticateUser(String username, String password) {
        if (userCredentials.containsKey(username)) {
            String storedPassword = userCredentials.get(username);
            if (storedPassword.equals(password)) {
                System.out.println("Welcome, " + username + "!");
                return true;
            }
        }
        System.out.println("Invalid credentials. Please try again.");
        return false;
    }
}



