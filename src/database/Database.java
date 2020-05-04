package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import pojo.Product;
import pojo.UserProfile;

public class Database {
	
	private static Database database = null;
	private Connection conn = null;
	private String url = "jdbc:mysql://localhost:3306/mystore_servlet";
	private String user = "test";
	private String pass = "test";
	private Properties props;
	private PreparedStatement pstmt = null;
	private List<Product> products = null;
	private ResultSet rset = null;
	
	public static synchronized Database getInstance() throws ClassNotFoundException, SQLException {
		if(database==null) {
			database = new Database();
		}
		return database;
	}
	
	private Database() throws ClassNotFoundException, SQLException {
		init();
	}
	
	private void init() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		props = new Properties();
		
		props.put("username", "test");
		props.put("password", "test");
		
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mystore_servlet?user=test&password=test");
	}
	
	public List<Product> getAll() throws SQLException{
		products = new ArrayList<Product>();
		String query = "SELECT * FROM product";
		
		pstmt = conn.prepareStatement(query);
		pstmt.execute();
		rset = pstmt.getResultSet();
		while(rset.next()==true) {
			products.add(new Product(
					rset.getString("code"),
					rset.getString("name"),
					rset.getString("description"),
					rset.getInt("inventory"),
					rset.getDouble("price"),
					rset.getString("category"),
					rset.getString("img")
					));
		}
		return products;
	}
	
	public void addUserIntoDB (UserProfile user) throws SQLException {
		//!!!Change this when DB is made!!!
		String query = "INSERT into userprofiles (userName, password, firstName, lastName, email)" + "VALUES (?,?,?,?,?)";
		
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getFirstName());
		ps.setString(4, user.getLastName());
		ps.setString(5, user.getEmail());
		
		ps.execute();
	}
	
	public UserProfile grabUserInfoFromDB (String userName) throws SQLException {
		//!!!Change this when DB is made!!!
		String query = "SELECT * FROM userprofiles WHERE userName='"+userName+"';" ;
	PreparedStatement ps = conn.prepareStatement(query);
	ps.execute();
	rset = ps.getResultSet();

		UserProfile user = new UserProfile(
				rset.getString("userName"),
				rset.getString("password"),
				rset.getString("firstName"),
				rset.getString("lastName"),
				rset.getString("email")
				);
		
		
		return user;
		
	}
	
}
