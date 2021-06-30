import java.util.*;

/**
 * @author brady anderson
 *
 * February 19, 2019
 * 
 *  bulgarian solitaire class
 * 
 * This class plays a classic game of bulgarian solitaire
 */

public class bulgarianSolitaire {
	
	public static ArrayList<Integer> changePileSize(ArrayList<Integer> piles){
//		System.out.println(piles);
		ArrayList<Integer> intList = new ArrayList<Integer>();
		// adding some randomness 
		Random rand = new Random();
		// get all the numbers already in piles in 1 - 9
		for(int i = 1; i < 10; i++) {
			if(piles.contains(i)) {
				intList.add(i);
				int index = piles.indexOf(i);
				piles.remove(index);
			}
		}
		// add # not in list 
		while(intList.size() != 9) {
			Integer remainder = piles.get(0) % 9;
			if(remainder == 0) {
				remainder = 9;
			}
			if(!intList.contains(remainder)) {
				if(piles.get(0) - remainder > 0) {
					piles.set(0, piles.get(0)-remainder);
				} else if(piles.get(0) - remainder == 0) {
					piles.remove(0);
				} else {
					// add any number below zero to next element in stack
					Integer extra = piles.get(0)-remainder;
					piles.remove(0);
					piles.set(0, piles.get(0) + extra);
				}
				intList.add(remainder);
			} else {
				// number already in list -> change the remainder logic
				if(piles.size() > 1) {
					piles.set(0, piles.get(0) + piles.get(1));
					piles.remove(piles.get(1));
				} else {
					Integer num = rand.nextInt(9);
					piles.set(0, piles.get(0)-num);
					piles.add(num);
				}
			}
		}
		// result cleaning
		Integer sum = 0;
		for(int i = 0; i < intList.size(); i++) {
			sum += intList.get(i);
		}
		if(intList.contains(-1)) {
			intList.set(intList.indexOf(-1), 45 - sum);
		}
		// return final result
		return intList;
	}

	public static void main(String[] args) {
		// create random number(1 - 9) of piles of random size
		Integer size = 45;
		ArrayList<Integer> piles = new ArrayList<Integer>();
		Random rn = new Random();
		while(size > 0) {
			Integer number = rn.nextInt(size)+1;
			size -= number;
			piles.add(number);
		}
		System.out.println(piles);
		System.out.println(changePileSize(piles));
	}

}
