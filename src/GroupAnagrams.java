/*
 *  https://leetcode.com/problems/group-anagrams/
 *  August 27th 2023
 *  By Erik Larkin
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GroupAnagrams 
{
	private static int LETTERS_IN_ALPHABET = 26;

	public static void main(String args[])
	{
		GroupAnagrams sol = new GroupAnagrams();
		String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
		sol.groupAnagrams(strs);
	}


	public List<List<String>> groupAnagrams(String[] strs) 
	{
		Map<List<Integer>, List<String>> map = new HashMap<List<Integer>, List<String>>();

		for (int i = 0; i < strs.length; i++) 
		{
			String currentString = strs[i];
			List<Integer> letters = countLetters(currentString);

			if (map.containsKey(letters))
				map.get(letters).add(currentString);
			else
				map.put(Collections.unmodifiableList(letters), new ArrayList<String>(Arrays.asList(currentString)));
		}

		return new ArrayList<List<String>>(map.values());
	}


	private List<Integer> countLetters(String s)
	{
		List<Integer> letterCounts = new ArrayList<Integer>(LETTERS_IN_ALPHABET);

		for (int i = 0; i < LETTERS_IN_ALPHABET; i++)
			letterCounts.add(0);

		for (int i = 0; i < s.length(); i++)
			letterCounts.set(s.charAt(i) - 'a', letterCounts.get(s.charAt(i) - 'a') + 1);
		
		return letterCounts;
	}
}
