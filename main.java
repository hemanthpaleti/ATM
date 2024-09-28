package atm;

public class main 
{
	 public static void main(String[] args) {
	        // Create a new user with username and password
	        User user = new User("john_doe", "password123");

	        // Create a new account with an initial balance
	        Account account = new Account();

	        // Create an ATM instance and start it
	        ATM atm = new ATM(user, account);
	        atm.start();
	    }
}
