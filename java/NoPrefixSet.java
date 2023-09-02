import java.util.List;

public class NoPrefixSet {

	private static final int NUMBER_OF_CHARACTERS = 10;
	
	public static void noPrefix(List<String> words) {
		TrieNode root = new TrieNode(NUMBER_OF_CHARACTERS);
		TrieNode currentTrieNode = root;

		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				char currentChar = word.charAt(i);
				currentTrieNode = currentTrieNode.addCharacter(currentChar);

				if (currentTrieNode.endOfWord()) {
					fail(word);
					return;
				}
				
			}

			if (currentTrieNode.isPrefix()) {
				fail(word);
				return;
			}

			currentTrieNode.setEndOfWord(true);
			currentTrieNode = root;
		}

		System.out.print("GOOD SET");
    }

	private static void fail(String word) {
		System.out.printf("BAD SET%n%s", word);
	}
}

class TrieNode {
	TrieNode[] subTries;
	int numberOfCharacters;
	boolean endOfWord;

	public TrieNode(int numberOfCharacters) {
		this.numberOfCharacters = numberOfCharacters;
		subTries = new TrieNode[numberOfCharacters];
		endOfWord = false;
	}

	public TrieNode addCharacter(char c) {
		if (!hasCharacter(c)){
			subTries[c - 'a'] = new TrieNode(numberOfCharacters);
		}

		return subTries[c - 'a'];
	}

	public boolean hasCharacter(char c) {
		return subTries[c - 'a'] != null;
	}

	public boolean endOfWord() {
		return endOfWord;
	}

	public void setEndOfWord(boolean b) {
		endOfWord = b;
	}

	public boolean isPrefix() {
		for (TrieNode node : subTries) {
			if (node != null) {
				return true;
			}
		}
		return false;
	}
}