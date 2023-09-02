public class TreeHuffmanDecoding 
{
	void decode(String s, Node root) {
        StringBuilder builder = new StringBuilder();

		Node currentNode = root;
		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);

			if (currentChar == '0') {
				currentNode = currentNode.left;
			} else {
				currentNode = currentNode.right;
			}

			if (currentNode.data != '\0') {
				builder.append(currentNode.data);
				currentNode = root;
			}
		}

		System.out.println(builder.toString());
    }

	private class Node {
		public int frequency;
		public char data;
		public Node left, right;
	}
}
