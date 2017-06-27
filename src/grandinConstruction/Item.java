package grandinConstruction;

public class Item {
		/* Generic wrapper class that inherits properties from any material */
	
	private int id;
	private String name;
	private double dollars;
	private String supplier;
	
	
	
	public Item(int id, String name, double dollars, String supplier) {
		super();
		this.id = id;
		this.name = name;
		this.dollars = dollars;
		this.supplier = supplier;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDollars() {
		return dollars;
	}
	public void setDollars(double dollars) {
		this.dollars = dollars;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	
}
