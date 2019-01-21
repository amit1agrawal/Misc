import java.util.ArrayList;
import java.util.List;

/**
 * Problem statement: Create a BST from an array. The array is sorted in increasing order.
 * @author Amit Agrawal
 *
 */

class BSTNode{
	int key;
	BSTNode left, right;
	
	public BSTNode(int item) {
		key = item;
		left = right = null;
	}
}


public class CreateBST {

	ArrayList<Integer> list =null;
	
	/**
	 * create the Binary Search tree and return the root node
	 * @return
	 */
	
	CreateBST(){
		list = new ArrayList<Integer>();
		
	}
	
	public BSTNode createTree(List<Integer> list2) {
		int length = list2.size();
		if (length <= 1) {
			BSTNode root = new BSTNode(list2.get(0));
			root.left = root.right = null;
			return root;
		}
		int rootElement = Math.abs(length/2);
		BSTNode root = new BSTNode(list2.get(rootElement));
		root.left = createTree(list2.subList(0, rootElement));
		if ((rootElement + 1) < length) {
			root.right = createTree(list2.subList(rootElement+1, length));
		}
		return root;
	}
	
	void printInOrder( BSTNode root) {
		if (root == null) {
			return;
		}
		printInOrder(root.left);
		System.out.println(root.key);
		printInOrder(root.right);
	}
	
	public void populateList() {
		this.list.add(5);
		this.list.add(7);
		this.list.add(12);
		this.list.add(15);
		this.list.add(16);
		this.list.add(30);
		this.list.add(41);
		this.list.add(99);
		this.list.add(101);
	}
	
	public ArrayList<Integer> getList() {
		return this.list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateBST tree = new CreateBST();
		tree.populateList();
		BSTNode root = tree.createTree(tree.getList());
		tree.printInOrder(root);
	}
}
