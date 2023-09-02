public class TreePreorderTraversal 
{
	public static void preOrder(Node root) {
		if (root != null) {
			System.out.printf("%d ", root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
    }
	
	private class Node {
		int data;
		Node left;
		Node right;
	}
}
