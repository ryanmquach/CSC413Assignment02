import java.util.HashMap;
import java.util.Map;

public class Security {
    private Map<String, String> userCredentials; // Map of username to password
    private Map<String, String> securityQuestions; // Map of username to security question

    public Security() {
        userCredentials = new HashMap<>();
        securityQuestions = new HashMap<>();
    }

    // Method to register a new user with their credentials and security question
    public void registerUser(String username, String password, String securityQuestion, String securityAnswer) {
        userCredentials.put(username, password);
        securityQuestions.put(username, securityAnswer);
    }

    // Method to authenticate a user upon login
    public boolean authenticateUser(String username, String password, String securityAnswer) {
        if (userCredentials.containsKey(username)) {
            String storedPassword = userCredentials.get(username);
            if (storedPassword.equals(password)) {
                String storedSecurityAnswer = securityQuestions.get(username);
                if (storedSecurityAnswer.equals(securityAnswer)) {
                    System.out.println("Welcome, " + username + "!");
                    return true;
                }
            }
        }
        System.out.println("Invalid credentials. Please try again.");
        return false;
    }
}

