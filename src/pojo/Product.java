package pojo;

public class Product {

	private String name;
	private int id;
	private double price;
	private String description;
	
	public Product(String name, int id, double price, String description) {
		super();
		this.name = name;
		this.id = id;
		this.price = price;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public double getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}
	
}
