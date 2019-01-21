/**
 * Problem statement: Give a binary tree, design an algorithm which creaes a linked list of all the nodes at each depth(eg if you have a tree with depth D, you will
 * have D linked list
 */
import java.util.ArrayList;
class LinkedList{
	int value;
	LinkedList next;
	
	public LinkedList(int value) {
		this.value = value;
		next = null;
	}
}


/**
 * Just another name for BinaryTree
 * @author Amit.Agrawal2
 *
 */
class BTree {

	Node root;
	private ArrayList<LinkedList> array = new ArrayList<LinkedList>();
	
	BTree(){
		root = null;
	}
	
	public ArrayList<LinkedList> getListOfDepths(){
		return array;
	}
	
	
	
	void createListofDepthsInternal(Node root, int level) {
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
	}
	
	ArrayList<LinkedList> createListofDepths() {
		this.createListofDepthsInternal(this.root, 0);
		return array;
	}
	
}

public class ListofDepths {
	
	static void printLinkedList(LinkedList root){
		while(root != null) {
			System.out.println(root.value);
			root = root.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BTree tree = new BTree();
		tree.root = new Node(1);
		tree.root.left	= new Node(2);
		tree.root.right	= new Node(3);
		tree.root.left.left	= new Node(4);
		tree.root.left.right	= new Node(5);
		tree.root.left.left.left = new Node(8);
		tree.root.left.left.right = new Node(9);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		
		ArrayList<LinkedList> array = tree.createListofDepths();
		for (int i = 0 ; i <array.size() ; i++) {
			printLinkedList(array.get(i));
		}
	}

}
