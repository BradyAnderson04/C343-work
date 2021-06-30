import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BST<Key extends Comparable<Key>, Value> {
	
	private String order = "";

private Node root;

	// note: the outer class has direct access to values in this inner class
	//from some research of good use of java it seems like there should be private and public versions of methods
	 private class Node {
	    private Key key;
	    private Value value;
	    private Node lChild;
	    private Node rChild;
	
	    // number of nodes at this subtree
	    // N for the root == # of nodes in entire tree
	    // N for leaf node == 1
	    // N needs to be updated everytime a new node is inserted into the tree
	    private int N;
	
	    public Node(Key key, Value value, int N) {
		    this.key = key;
		    this.value = value;
		    this.lChild = null;
		    this.rChild = null;
		    this.N = N;
	   	}
	 }
	
	 public int size() {
		 return root.N;
	 }
	
	 public Value get(Key key) {
		 return get(key, root);
	 }
	 private Value get(Key key, Node n) {
		 if(n == null) {
			 // error 404
			 return null;
		 } else if(key.compareTo(n.key) < 0) {
			 // left
			 return get(key, n.lChild);
		 } else if(key.compareTo(n.key) > 0) {
			 // right
			 return get(key, n.rChild);
		 } else {
			 // found
			 return n.value;
		 }
	 }
	
	 public void put(Key key, Value val) {
		 // call out private method so we don't have to edit all the calls below
		 root = put(key, val, root);
	 }
	 private Node put(Key key, Value val, Node n) {
		 if(n == null) {
			 n = new Node(key, val, 1);
		 } else if(key.compareTo(n.key) < 0) {
			 // left - add to amount in tree
			 n.N ++;
			 n.lChild = put(key, val, n.lChild);
		 } else if(key.compareTo(n.key) > 0) {
			 // right
			 n.N ++;
			 n.rChild = put(key, val, n.rChild);
		 } 
		 else {
			 // value already in tree ... per project instruction allow duplicates
			 // get current left child in temp var
			 // reset current left child to this value
			 // use put method to add the child node
			 n.N ++;
			 Node temp = n.lChild;
			 n.lChild = new Node(key, val, 1);
			 // can assum it is left child bc we are going left so is already less than our val
			 n.lChild.lChild = temp;
		 }
		 return n;
	 }
	
	 private Node getNode(Key key, Node n) {
			if(n == null) {
				 // error 404
				 return null;
			 } else if(key.compareTo(n.key) > 0) {
				 // right
				 return getNode(key, n.rChild);
			 } else if(key.compareTo(n.key) < 0) {
				 // left
				 return getNode(key, n.lChild);
			 }else {
				 // found
				 return n;
			 }
		}
		
	 private Integer calcTree(String[] s) {
			Integer sum = 0;
			for(String c: s) {
				sum += (int) c.charAt(0);
			}
			return sum;
		}
	 
	 public String preOrder(Node node) {
		 /*
		  * preorder walk helper method
		  */
		 if(node == null) {
			 return order;
		 } else {
			 order += node.value;
			 preOrder(node.lChild);
			 preOrder(node.rChild);
		 }
		 return order;
	 }
	 
	 public String postOrder(Node node) {
		 /*
		  * postorder walk helper method
		  */
		 if(node != null) {
			 order += node.value;
			 preOrder(node.lChild);
			 preOrder(node.rChild);
		 } else {
			 return order;
		 }
		 return order.substring(1) + order.substring(0, 1);
	 }

	 public String inOrder(Node node) {
		 /*
		  * in order walk helper method
		  */
		 if (node == null) {
		      return null;
		    }

		    inOrder(node.lChild);
		    order += node.value;
		    inOrder(node.rChild);
		 return order;
	 }
	
	 public String walk(String choice, Node input) {
		 order = "";
		 // if choice is “pre” then perform pre-order walk
		 if(choice.equals("pre")){
			 // Root - Left - Right
			 return preOrder(input);
		 }
		 // if choice is “post” then perform post-order walk
		 else if(choice.equals("post")) {
			 // Left - Right - Root
			 return postOrder(input);
		 }
		 // any other choice or wrong choice will use default option 
		 else {
			  // if choice is “in” then perform in-order walk or command it not recognized (default)
			 // Root - Left - Right
			 return inOrder(input);
		 }
	 }
	
	 public String toString() {
		 String input = walk("pre") + walk("post") + walk("in");
		 return input;
	 }
	 
	 public boolean equals(Object obj) {
		// returns whether this tree (using root node) is exactly same as another BST
		return toString().equals(obj.toString());
	 }
	
	 // returns true if this tree (using root node) is perfectly balanced, return false otherwise.   
	 public boolean isBalanced() { 
		 /*
		  * if the left and right nodes subtree size are the same
		  * return true o.w. return false
		  */
		 if(root.rChild.N == root.lChild.N) {
			 return true;
		 }
		 return false;
	 } 

	 // returns the number of leaf nodes in the BST
	 public int countLeafNodes(){
		 
	 }

	// returns the number of nodes in BST with only one child
	public int getOneChildNodes(){
		// If tree is empty 
        if (root==null) 
            return 0; 
  
        // Do level order traversal starting from root 
        Queue<Node> queue = new LinkedList<Node>(); 
        queue.add(root); 
  
        int count=0; // Initialize count of half nodes 
        while (!queue.isEmpty()) 
        { 
            Node temp = queue.poll(); 
            if (temp.lChild!=null && temp.rChild==null || temp.lChild==null && temp.rChild!=null) 
                count++; 
  
            // Enqueue left child 
            if (temp.lChild != null) 
                queue.add(temp.lChild); 
  
            // Enqueue right child 
            if (temp.rChild != null) 
                queue.add(temp.rChild); 
        } 
        return count; 
	}

	// returns  the number of nodes in BST with two children.
	public int getTwoChildrenNodes(){
		// If tree is empty 
        if (root==null) 
            return 0; 
  
        // Do level order traversal starting from root 
        Queue<Node> queue = new LinkedList<Node>(); 
        queue.add(root); 
  
        int count=0; // Initialize count of half nodes 
        while (!queue.isEmpty()) 
        { 
            Node temp = queue.poll(); 
            if (temp.lChild!=null && temp.rChild!=null) 
                count++; 
  
            // Enqueue left child 
            if (temp.lChild != null) 
                queue.add(temp.lChild); 
  
            // Enqueue right child 
            if (temp.rChild != null) 
                queue.add(temp.rChild); 
        } 
        return count; 
	} 

	// returns a new BST with the duplicates removed from the original tree.
	public BST removeDuplicates(){
		/*
		 * use a set to keep track of all keys
		 */
		
	}

	// returns the sum of keys of nodes in the left branch of the passed key value
	public Integer sumLeft(Key key){
		Node rootNode = getNode(key, root);
		String nodeString = walk("in", rootNode);
		String[] nodes = nodeString.substring(0, nodeString.lastIndexOf(rootNode.value.toString())).split("");
		return calcTree(nodes);
	}

	// returns the sum of keys of nodes in the right branch of the passed key value
	public Integer sumRight(Key key){
		Node rootNode = getNode(key, root);
		String nodeString = walk("in", rootNode);
		String[] nodes = nodeString.substring(nodeString.lastIndexOf(rootNode.value.toString())).split("");
		return calcTree(nodes);
	}

	// returns a new BST with the height that is half of the original tree (including all the top nodes starting with root node and the ones connected to root node if needed).
	public BST getUpperHalf () { 
	  /*
	   * given the height of a bst
	   * make all the child / leaf nodes null of the n/2 row
	   */
		
	}

	public static void main(String[] args) {

	  // Test the 
	  BST<Integer, Character> bstTree = new BST<>();
	  bstTree.put((int) 'p','p');
	  bstTree.put((int) 'g','g');
	  bstTree.put((int) 'w','w');
	  bstTree.put((int) 'c','c');
	  bstTree.put((int) 'k','k');
	  bstTree.put((int) 's','s');
	  bstTree.put((int) 'c','c');
	  bstTree.put((int) 'y','y');
	  bstTree.put((int) 'a','a');
	  bstTree.put((int) 'a','a');
	  bstTree.put((int) 'e','e');
	  bstTree.put((int) 'i','i');
	  bstTree.put((int) 'q','q');
	  bstTree.put((int) 'u','u');
	  bstTree.put((int) 'q','q');
	  bstTree.put((int) 'x','x');

	  // test all implemented functions for bstTree
	  System.out.println(bstTree.sumLeft((int) 'c'));
	  System.out.println(bstTree.sumRight((int) 'c'));
	  System.out.println(bstTree.getOneChildNodes());
	  System.out.println(bstTree.getTwoChildrenNodes());
	  
	  Random rand = new Random();
	  BST<Integer, Character> randomTree = new BST<>();
	
	  for (int i = 0; i < 13; i++) {
	   int key = rand.nextInt(26) + 'a';
	   char val = (char) key;
	   randomTree.put(key, val);
	  }
	
	  // note: not all of these chars will end up being generated from the for loop
	  // some of these return values will be null
	  System.out.println(randomTree.get((int) 'a'));
	  System.out.println(randomTree.get((int) 'b'));
	  System.out.println(randomTree.get((int) 'c'));
	  System.out.println(randomTree.get((int) 'f'));
	  System.out.println(randomTree.get((int) 'k'));
	  System.out.println(randomTree.get((int) 'x'));
	
	  // test all implemented functions for randomTree
	  
	 }
}
