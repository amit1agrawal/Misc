
class Node{
	int key;
	Node left, right;
	
	public Node(int item) {
		key = item;
		left = right = null;
	}
}
public class BinaryTree {

	Node root;
	BinaryTree(){
		root = null;
	}
	
	
	void printPostOrder(Node root) {
		if (root == null) {
			return;
		}
		
		printPostOrder(root.right);
		printPostOrder(root.left);
		System.out.println(root.key);
	}
	
	void printPreOrder(Node root) {
		if (root == null) {
			return;
		}
		
		System.out.println(root.key);
		printPreOrder(root.left);
		printPreOrder(root.right);
	}
	
	void printInOrder( Node root) {
		if (root == null) {
			return;
		}
		
		printInOrder(root.left);
		System.out.println(root.key);
		printInOrder(root.right);
	}
	
	boolean checkBST(Node root) {
		if (root == null) {
			return true;
		}
		
		if (! checkBST(root.left)){
			return false;
		}
		
		if ( (root.right != null && root.right.key < root.key) || (root.left != null && root.left.key > root.key)) {
			return false;
		}
		if (!checkBST(root.right)) {
			return false;
		}
		
		return true;
	}
	
	public static void main (String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left	= new Node(2);
		tree.root.right	= new Node(3);
		tree.root.left.left	= new Node(4);
		tree.root.left.right	= new Node(5);
		/*tree.root.left	= new Node(6);
		tree.root.left	= new Node(2);
		tree.root.left	= new Node(2);
		tree.root.left	= new Node(2);*/
		
		System.out.println("Preorder traversal of binary tree is "); 
        tree.printPreOrder(tree.root); 
  
        System.out.println("\nInorder traversal of binary tree is "); 
        tree.printInOrder(tree.root); 
  
        System.out.println("\nPostorder traversal of binary tree is "); 
        tree.printPostOrder(tree.root);
        
        // Create a non-BST tree and check whether it's BST or not
        
        tree = null;
        tree = new BinaryTree();
        tree.root = new Node(1);
		tree.root.left	= new Node(2);
		tree.root.right	= new Node(3);
		tree.root.left.left	= new Node(4);
		tree.root.left.right	= new Node(5);
		
		if (tree.checkBST(tree.root)) {
			System.out.println("The tree is a proper Binary Search Tree");
		}
		else {
			System.out.println("The tree is NOT a proper Binary Search Tree");
		}
		
		tree = null;
        tree = new BinaryTree();
        tree.root = new Node(20);
		tree.root.left	= new Node(15);
		tree.root.right	= new Node(30);
		tree.root.left.left	= new Node(10);
		tree.root.left.right	= new Node(17);
		tree.root.right.left = new Node(25);
		tree.root.right.right = new Node(40);
		
		if (tree.checkBST(tree.root)) {
			System.out.println("The tree is a proper Binary Search Tree");
		}
		else {
			System.out.println("The tree is NOT a proper Binary Search Tree");
		}
	}
	
}
