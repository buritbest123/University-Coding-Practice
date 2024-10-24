public class TreeCalculator {

		
	public static int findMax(Node root) {
		//****YOUR CODE HERE**
		if (root == null) { // If the tree pointed by root is null, return -1.
			return -1;
		}
		int Max = root.id; // Initialization Max = root.id || Root's data = root.id

		if (findMax(root.left) > Max) { // Max in Left Subtree
			Max = findMax(root.left);
		}

		if (findMax(root.right) > Max) { // Max in right subtree
			Max = findMax(root.right);
		}

		return Max; // Recursively traverse the tree from root and return the maximum node id in the tree.
	}
//*********************
	
	
	public static int findMin(Node root)
	{
		//****YOUR CODE HERE**
		if (root == null) { // If the tree pointed by root is null, return -1.
			return -1;
		}

		int Min = root.id; // Initialization Min = root.id || Root's data = root.id

		if (findMax(root.left) != -1) {
			if (findMax(root.left) < Min){ // Min Left Subtree
				Min = findMax(root.left);
			}
		}

		if (findMax(root.right) != -1) {
			if (findMax(root.right) < Min) { // Min right Subtree
				Min = findMax(root.right);
			}
		}

		return Min; // return the minimum node id in the tree.
		//*********************
	}
	
	//************* BONUS ****************//
	public static double sumTree(Node root)
	{	
		//****YOUR CODE HERE**
		if (root == null) { // If root is null, return 0.
			return 0;
		}

		return root.id + (sumTree(root.left) + sumTree(root.right)); // Return the sum of all nodes.
		//*********************
	}

	public static int countNode(Node root){ // Method countNode
		if(root == null) { // If root is null, return 0.
			return 0;
		}

		return countNode(root.left) + countNode(root.right) + 1; // Return the count of nodes in current
	}
	
	public static double avgTree(Node root)
	{
		//****YOUR CODE HERE**
		if (root == null) {  // If root is null, return 0.
			return 0;
		}
		return sumTree(root) / countNode(root); // Return the average of all the nodes.
		//*********************
	}
	
}