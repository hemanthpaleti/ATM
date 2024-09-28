package atm;

public class User 
{
	private String username;
    private String password;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    // Method to validate password
    public boolean validatePassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }
}
