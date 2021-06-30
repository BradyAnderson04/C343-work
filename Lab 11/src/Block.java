
public class Block {
	private int quantity;
	private double cost;
	static int totalBought;

	public Block(int quantity, double cost) {
		this.quantity = quantity;
		this.cost = cost;
		totalBought += quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int changeQuantity(int quantity) {
		/*
		 * given a value check if there are enough share
		 * and change block quantity accoringingly
		 * when there are not enough then return how much 
		 * shares you have left to sell
		 */
		if(quantity < getQuantity()) {
			setQuantity(getQuantity() - quantity);
			return -1;
		} else {
			return quantity - getQuantity();
		}
	}
		
	public double calcProfit(int quantity, double price) {
		/*
		 * if there is enough shares in the block
		 * then calculate profit w/ quantity
		 * 
		 * o.w. calculate w/ full stock amount of full block
		 */
		if(getQuantity() - quantity > 0) {
			return quantity * (price - cost);
		} else {
			return getQuantity() * cost;
		}
	}
	
	public Integer getTotalBought() {
		return totalBought;
	}
		

}
