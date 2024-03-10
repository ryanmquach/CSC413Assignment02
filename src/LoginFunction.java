public class LoginFunction {
    private Security securityControl;

    public LoginFunction(Security securityControl) {
        this.securityControl = securityControl;
    }

    public void login(String username, String password, String securityAnswer) {
        // Authenticate the user with the security control
        boolean isAuthenticated = securityControl.authenticateUser(username, password, securityAnswer);
        if (isAuthenticated) {
            // Proceed with the requested functionality
            // For example, allow the user to access their account
            // This part would be handled by the rest of your application logic
            System.out.println("User authenticated successfully!");
        } else {
            System.out.println("Authentication failed. Please try again.");
        }
    }
}
