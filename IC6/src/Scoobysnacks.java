
public class Scoobysnacks implements Scannable, Comparable<Object>{
	// instance variables
	private Double price;
	private Integer barcode;
	private String name;
	
	public Scoobysnacks(double p, Integer bar, String n) {
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
	@Override
	public int compareTo(Object s) {
		Scoobysnacks other = (Scoobysnacks) s;
		double comparePrice = (other.getPrice()); 
		
		if(this.getPrice() > comparePrice) {
			return 1;
		}else if(this.getPrice() < comparePrice) {
			return -1;
		}
		else {
			return 0;
		}
	}
	public double scanMe() {
		return getPrice();
	}
}
