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

public class Database {
	
	private static Database database;
	private Connection conn;
	private String url = "jdbc:mysql://localhost:3306/testproduct";
	private String user = "test";
	private String pass = "test";
	private Properties props;
	private PreparedStatement pstmt;
	private List<Product> products;
	private ResultSet rset;
	
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
		
		props.put("username", user);
		props.put("password", pass);
		
		conn = DriverManager.getConnection(url, props);
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
	
}
