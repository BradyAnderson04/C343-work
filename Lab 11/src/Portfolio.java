import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Portfolio {
	
	private Map<String, Queue<Block>> stocks;
	private String user;

	public Portfolio(String name) {
		setStocks(new TreeMap<String, Queue<Block>>());
		this.user = name;
	}
	
	public void buyStock(String key, int Quantity, double price ) {
		if(getStocks().containsKey(key.toLowerCase())) {
			// stock already exists in map
			Queue<Block> stockList = getStocks().get(key.toLowerCase());
			stockList.add(new Block(Quantity, price));
			getStocks().replace(key, stockList);	
		} else {
			// stock doesn't exist in the Map
			Queue<Block> stockList = new LinkedList<Block>();
			stockList.add(new Block(Quantity, price));
			getStocks().put(key.toLowerCase(), stockList);
		}
	}
	
	public String sellStock(String key, int Quantity, double price) {
		/*
		 * look up stock in map 
		 * if exists - 
		 * iterate until the quantity desired to be sold is sold
		 * go block by block following fifo piece of queue
		 * 
		 * o.w. - tell user about stock not existing
		 */
		if(getStocks().containsKey(key.toLowerCase())) {
			Double profit = 0.0;
			int number = Quantity;
			while(number > 0) {
				Block block = getStocks().get(key.toLowerCase()).peek();
				profit += block.calcProfit(Quantity, price);
				number = block.changeQuantity(Quantity);
				if(number != -1) {
					// block has no more quantity so delete block
					getStocks().get(key).remove();
				} 
			return "Hey " + getUser() + ", you made " + profit.toString() + " Dollars!";
			}
		}
		return "Well, you don't own that stock mate. Try buying it next time!";
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public Map<String, Queue<Block>> getStockInfo() {
		return getStocks();
	}

	public Map<String, Queue<Block>> getStocks() {
		return stocks;
	}

	public void setStocks(Map<String, Queue<Block>> stocks) {
		this.stocks = stocks;
	}
	

}
