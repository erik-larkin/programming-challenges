/*
 *  https://leetcode.com/problems/valid-anagram/
 *  August 27th 2023
 *  By Erik Larkin
 */

public class ValidAnagram {

	private static int LETTERS_IN_ALPHABET = 26;

	private boolean isAnagram(String s, String t) 
	{
		if (s.length() != t.length())
			return false;

		int[] letterCounts = new int[LETTERS_IN_ALPHABET];

		for (int i = 0; i < s.length(); i++)
		{
			letterCounts[s.charAt(i) - 'a']++;
			letterCounts[t.charAt(i) - 'a']--;
		}
		
		for (int i = 0; i < LETTERS_IN_ALPHABET; i++) 
			if (letterCounts[i] != 0)
				return false;

		return true;
	}
}
