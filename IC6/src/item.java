
public abstract class item {
	private Double price;
	private Integer barcode;
	private String name;

	public item(double p, Integer bar, String n) {
		this.price = p;
		this.barcode = bar;
		this.name = n;
	}
	
	// Class getters and setters! 
	public Double getPrice() {
		return this.price;
	}
	public void setPrice(double value) {
		this.price = value;
	}
	public Integer getBarcode() {
		return this.barcode;
	}
	public void setBarcode(Integer number) {
		this.barcode = number;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String n) {
		this.name = n;
	}
	// interface stuff here
	abstract int compareTo(Object t);
	abstract double scanMe();
}
