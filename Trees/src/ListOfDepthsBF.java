import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Problem statement: Give a binary tree, design an algorithm which creaes a linked list of all the nodes at each depth(eg if you have a tree with depth D, you will
 * have D linked list. Use Breadth First approach.
 */

class BTreeBF {

	Node root;
	private ArrayList<LinkedList> array = new ArrayList<LinkedList>();
	private java.util.LinkedList queue = new java.util.LinkedList<Node>();
	private int level = 0;
	
	BTreeBF(){
		root = null;
	}
	
	public ArrayList<LinkedList> getListOfDepths(){
		return array;
	}
	
	void create(Node root) {
		if (root == null) { //base case
			return;
		}
		
		System.out.println(root.key);
		if (root.left != null) {
			queue.add(root.left);
		}
		if (root.right != null) {
			queue.add(root.right);
		}
		
		if (!queue.isEmpty()) {
			create((Node)queue.remove());
		}
	}
	
	/*void createListofDepthsInternal(Node root, int level) {
		if (root == null) {
			return;
		}
		
		
		
		if (array.size() >= (level+1)) {
			LinkedList list = new LinkedList(root.key);
			LinkedList elem = array.get(level);
			while (elem.next != null) {
				elem = elem.next;
			}
			elem.next = list;
		}
		else {
			LinkedList list = new LinkedList(root.key);
			array.add(list);
		}
		
		//System.out.println(root.key);
		createListofDepthsInternal(root.left, level+1);
		createListofDepthsInternal(root.right, level+1);
	}*/
	
	/*ArrayList<LinkedList> createListofDepths() {
		this.createListofDepthsInternal(this.root, 0);
		return array;
	}*/
	
}

public class ListOfDepthsBF {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BTreeBF tree = new BTreeBF();
		tree.root = new Node(1);
		tree.root.left	= new Node(2);
		tree.root.right	= new Node(3);
		tree.root.left.left	= new Node(4);
		tree.root.left.right	= new Node(5);
		tree.root.left.left.left = new Node(8);
		tree.root.left.left.right = new Node(9);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		
		tree.create(tree.root, 0);
		
		
	}

}
