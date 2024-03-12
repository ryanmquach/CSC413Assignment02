import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAOConcrete implements CustomerDAO {

    static Connection connection = null;
    PreparedStatement pStatement;
    ResultSet result;
    static String url = CustomerDataConnection.getURL();
    static String username = CustomerDataConnection.getURL();
    static String pwd = CustomerDataConnection.getURL();

    public CustomerDAOConcrete() {
        try {
            connection = CustomerDataConnection.getDBConnection();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }

    // Method to disconnect from the database
    public static void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    // Method to insert a customer into the database
    @Override
    public int insert(Customer customer) throws SQLException {
        int res = -1;
        pStatement = connection.prepareStatement(CustomerDataConnection.getInsert());
        pStatement.setString(1, customer.getFirstName());
        pStatement.setString(2, customer.getLastName());
        pStatement.setString(3, customer.getUsername());
        pStatement.setString(4, customer.getEmail());
        pStatement.setString(5, customer.getAddress());
        pStatement.setString(6, customer.getPhoneNumber());
        pStatement.setString(7, customer.getAccountNumber());
        pStatement.setString(8, customer.getDateOfBirth());
        pStatement.setString(9, customer.getSecurityQuestion());
        pStatement.setString(10, customer.getSecurityAnswer());
        res = pStatement.executeUpdate();
        disconnect();
        return res;
    }

    // Method to retrieve a customer from the database by ID
    @Override
    public Customer get(int id) throws SQLException {
        pStatement = connection.prepareStatement(CustomerDataConnection.getSelect());
        pStatement.setInt(1, id);
        result = pStatement.executeQuery();
        Customer updatedCustomer = null;
        if (result.next()) {
            updatedCustomer = new Customer( result.getString("first_name"), result.getString("last_name"), result.getString("username"), result.getInt("id"), result.getString("password"),result.getString("email"), result.getString("address"), result.getString("phone_number"), result.getString("account_number"), result.getString("date_of_birth"), result.getString("security_question"), result.getString("security_answer"));
        }
        return updatedCustomer;
    }

    // Method to update a customer in the database
    public int update(Customer customer) throws SQLException {
        int result = -1;
        pStatement = connection.prepareStatement(CustomerDataConnection.getUpdate());
        pStatement.setString(1, customer.getFirstName());
        pStatement.setString(2, customer.getLastName());
        pStatement.setString(3, customer.getUsername());
        pStatement.setString(4, customer.getEmail());
        pStatement.setString(5, customer.getAddress());
        pStatement.setString(6, customer.getPhoneNumber());
        pStatement.setString(7, customer.getAccountNumber());
        pStatement.setString(8, customer.getDateOfBirth());
        pStatement.setString(9, customer.getSecurityQuestion());
        pStatement.setString(10, customer.getSecurityAnswer());
        pStatement.setInt(11, customer.getId());
        result = pStatement.executeUpdate();
        return result;
    }

    // Method to delete a customer from the database
    @Override
    public int delete(Customer customer) throws SQLException {
        int res = -1;
        pStatement = connection.prepareStatement(CustomerDataConnection.getDelete());
        pStatement.setInt(1, customer.getId());
        res = pStatement.executeUpdate();
        return res;
    }

    // Method to save a customer in the database
    @Override
    public int save(Customer customer) throws SQLException {
        int res = -1;
        pStatement = connection.prepareStatement(CustomerDataConnection.getInsert());
        pStatement.setString(1, customer.getFirstName());
        pStatement.setString(2, customer.getLastName());
        pStatement.setString(3, customer.getUsername());
        pStatement.setString(4, customer.getEmail());
        pStatement.setString(5, customer.getAddress());
        pStatement.setString(6, customer.getPhoneNumber());
        pStatement.setString(7, customer.getAccountNumber());
        pStatement.setString(8, customer.getDateOfBirth());
        pStatement.setString(9, customer.getSecurityQuestion());
        pStatement.setString(10, customer.getSecurityAnswer());
        res = pStatement.executeUpdate();
        return res;
    }
}
