public class LoginFunction {
    public Security security = new Security(); // Initialize the Security object

    public LoginFunction(Security security) {
    }

    // Method to handle the login process with provided username and password
    public boolean login(String username, String password) {
        // Attempt to authenticate the user
        boolean isAuthenticated = security.authenticateUser(username, password);

        if (isAuthenticated) {
            System.out.println("Login successful for user: " + username);
            // Proceed with whatever action comes after successful login
        } else {
            System.out.println("Login failed for user: " + username);
        }
        return isAuthenticated;
    }
}


