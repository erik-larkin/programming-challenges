/*
 *  https://leetcode.com/problems/valid-anagram/
 *  August 27th 2023
 *  By Erik Larkin
 */

public class ValidAnagram {

	private static int LOWERCASE_LETTERS_ASCII_START = 97;
	private static int LETTERS_IN_ALPHABET = 26;

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;

		int[] sLetterCounts = getLetterCounts(s);
		int[] tLetterCounts = getLetterCounts(t);
		
		for (int i = 0; i < LETTERS_IN_ALPHABET; i++) {
			if (sLetterCounts[i] != tLetterCounts[i])
				return false;
		}

		return true;
	}

	private int[] getLetterCounts(String s) {
		int[] letterCounts = new int[LETTERS_IN_ALPHABET];

		for (int i = 0; i < LETTERS_IN_ALPHABET; i++) {
			letterCounts[i] = 0;
		}
		
		for (int i = 0; i < s.length(); i++) {
			char letter = s.charAt(i);
			letterCounts[letter - LOWERCASE_LETTERS_ASCII_START]++;
		}

		return letterCounts;
	}
}
