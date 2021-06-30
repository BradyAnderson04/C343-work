
public class Taco extends item implements Scannable, Comparable<Object>{
	// instance variables
	private Double price;
	private Integer barcode;
	private String name;
	
	public Taco(double p, Integer bar, String n) {
		super(p, bar, n);
		this.price = getPrice();
		this.barcode = getBarcode();
		this.name = getName();
	}
	
	// interface stuff here
	@Override
	public int compareTo(Object t) {
		Taco other = (Taco) t;
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
