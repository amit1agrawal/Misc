
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
	}
	
}
