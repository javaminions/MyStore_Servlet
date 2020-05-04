package pojo;

public class UserProfile {
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String cartProducts;
	
	public UserProfile(String firstName, String lastName, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public String getCartProducts() {
		return cartProducts;
	}
	
	public void setCartProducts(String cartProducts) {
		this.cartProducts = cartProducts;
	}
}
