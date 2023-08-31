import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int queryCount = scanner.nextInt();
		for (int i = 0; i < queryCount; i++) {
			int query = scanner.nextInt();
			switch (query) {
				case 1:
					String appendWord = scanner.next();
					TextEditor.append(appendWord);
					break;
				case 2:
					int lengthToDelete = scanner.nextInt();
					TextEditor.delete(lengthToDelete);
					break;
				case 3:
					int indexToPrint = scanner.nextInt();
					TextEditor.print(indexToPrint);
					break;
				case 4:
					TextEditor.undo();
					break;
				default:
					break;
			}
		}

		scanner.close();
	}

	private static class TextEditor {
		private static StringBuilder builder = new StringBuilder();
		private static Stack<Object> operationHistory = new Stack<Object>();

		public static void append(String appendWord) {
			builder.append(appendWord);
			Integer length = new Integer(appendWord.length());
			operationHistory.push(length);
		}

		public static void delete(int lengthToDelete) {
			int length = builder.length();
			String deletedWord = builder.substring(length - lengthToDelete, length);
			builder.delete(length - lengthToDelete, length);
			operationHistory.push(deletedWord);
		}

		public static void print(int indexToPrint) {
			if (indexToPrint >= 1)
				System.out.println(builder.charAt(indexToPrint - 1));
		}

		public static void undo() {
			Object lastOperation = operationHistory.pop();
			if (lastOperation instanceof String) {
				builder.append((String) lastOperation);
			} else if (lastOperation instanceof Integer) {
				int length = builder.length();
				builder.delete(length - (Integer) lastOperation, length);
			}
		}
	}
}
