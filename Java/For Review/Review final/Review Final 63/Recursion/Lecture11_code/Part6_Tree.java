class Node {
	public int id;
	public Node left = null;
	public Node right = null;
	
	public Node(int _id, Node _left, Node _right){
		id = _id;
		left = _left;
		right = _right;
	}
}

public class Part6_Tree {
	
	public static void main(String[] args) {
		// construct binary tree
		Node n1 = new Node(1, null, null);	// leaf node
		Node n3 = new Node(3, null, null);	// leaf node
		Node n2 = new Node(2, n1, n3);		// sub-tree
		Node n5 = new Node(5, null, null);	// another leaf node
		Node btree = new Node(4, n2, n5);	// whole btree
		
		System.out.println("Root tree ID: " + btree.id);

		//To get left and right Node, just access left and right instance fields 
		System.out.println("Left tree object: " + btree.left);
		System.out.println("Right tree object: " + btree.right);
		System.out.println("Root of left tree ID: " + btree.left.id);
		System.out.println("Root of right tree ID: " + btree.right.id);
		
		System.out.println("\ntraverse preorder");
		preorder(btree);
		System.out.println("\ntraverse in-order");
		inorder(btree);
		System.out.println("\ntraverse postorder");
		postorder(btree);

	}
	
	static void preorder(Node root) {
		if(root == null)
			return;
		else {
			System.out.print(root.id + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	static void inorder(Node root) {
		if(root == null)
			return;
		else {
			inorder(root.left);
			System.out.print(root.id + " ");
			inorder(root.right);
		}
	}
	
	static void postorder(Node root) {
		if(root == null)
			return;
		else {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.id + " ");
		}
	}
	
}

