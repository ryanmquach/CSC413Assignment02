import java.util.HashMap;
import java.util.Map;

public class Security {
    private Map<String, String> userCredentials; // Map of username to password
    private Map<String, String[]> userSecurityInfo; // Map of username to security question and answer

    public Security() {
        userCredentials = new HashMap<>();
        userSecurityInfo = new HashMap<>();
    }

    // Method to register a new user with their credentials and security question/answer
    public void registerUser(String username, String password, String securityQuestion, String securityAnswer) {
        userCredentials.put(username, password);
        userSecurityInfo.put(username, new String[]{securityQuestion, securityAnswer});
    }

    // Method to authenticate a user upon login
    public boolean authenticateUser(String username, String password, String securityAnswer) {
        if (userCredentials.containsKey(username)) {
            String storedPassword = userCredentials.get(username);
            if (storedPassword.equals(password)) {
                String[] securityInfo = userSecurityInfo.get(username);
                String storedSecurityAnswer = securityInfo[1];
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



