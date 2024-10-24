public class TreeManagement {

	//TASK1: Display all name in Tree using InOrderTraversal
    public static String printInorderName(Node root, String _result)
    {
		/*
		Complete a static method named printInorderName(Node root, String _result). This method
		performs in-order traversal and returns all names in the given Tree. The method takes two parameters
		Node root and String _result, then returns String of all name in a specific format. For example, by
		calling the method printInorderName(ts[0], result), the result returned from the method will
		be “Chailert|Bodin|Duanhatai|Anuwat|Chaiwat|Ekawat|“.
		 */

    	//CODE HERE
		if (root == null) { // If a binary tree node is NULL then it is a full binary tree.
			return _result;
		}
		_result = root.name; // Assignment _result = root.name
        return printInorderName(root.left,"" ) + _result + "|" + printInorderName(root.right,""); // in-order traversal
    }

	//TASK2: Count number of all name begin with a character 'P'
    public static int countName(Node root, char _char)
    {
		/*
		This method performs navigation and counting the number of persons whose name begins with the given parameter _char. The method
		takes Node root, and char _char as parameters, then returns the integer number of all names that begin
		with the character _char. For example, by calling the countName(root, ‘C’) method, the result will
		be an integer of 2 (by counting person name: Chailert and Chaiwat).
		*/

    	//CODE HERE
		if (root == null) { // If a binary tree node is NULL then it is a full binary tree.
			return 0;
		}

		if (root.name.charAt(0) != _char){ // if First character of name (String is not equal _char (parameter), Then
			return countName(root.left, _char) + countName(root.right,_char); // Return Method countName(root.left and root.right)
		}
    	return countName(root.left, _char) + countName(root.right,_char) + 1; // If First character of name (String is equal _char (parameter), Then +1
    }

	//TASK3: Find the index of a  given name in Tree
    public static int searchIDByName(Node root, String _name)
    {
		/*
		Find the ID of a specific person from the given name. The method takes a Node root, and String _name as parameters, then
		return the integer ID of the matched name. For example, by calling the method searchIDByName(Node
		root, “Duanhatai”), the result will be an integer of ID= 4.
		 */

    	//CODE HERE
		if (root == null) { // If a binary tree node is NULL then it is a full binary tree.
			return 0;
		}
		if (root.name == _name) { // If root.name == _name, Then return id
			return root.id;
		}
    	return searchIDByName(root.left, _name) +searchIDByName(root.right, _name); // Recursion is real XD
    }


	//TASK4: Find the longest name in Tree (using recursive function)
	public static Node findLongestName(Node root)
	{
		/*
		Complete a static method findLongestName(Node root) to find a person who has the longest name
		in the Tree. The method takes a Node root as a parameter and then returns the Node of a person who
		has the longest name in the Tree. For example, by calling the method findLongestName(Node root),
		the method must return the Node of person name “Duanhatai”.
		 */

    	//CODE HERE
		if (root == null) { // If a binary tree node is NULL then it is a full binary tree.
			return root;
		}

		String longest = root.name; // Initialization String longest = root.name
		try {
			if (findLongestName(root.left).name.length() > longest.length()){ // Recursion xD
				root = findLongestName(root.left);
			}
			if (findLongestName(root.right).name.length() > longest.length()){
				root = findLongestName(root.right);
			}
		} catch (Exception e) {

		}
		return root;
	}
}