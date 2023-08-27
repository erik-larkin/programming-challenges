/*
 *  https://leetcode.com/problems/group-anagrams/
 *  August 27th 2023
 *  By Erik Larkin
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class GroupAnagrams 
{
	private static int LETTERS_IN_ALPHABET = 26;

	public List<List<String>> groupAnagrams(String[] strs) 
	{
		String[] sortedStrings = Arrays.copyOf(strs, strs.length);
		Arrays.sort(sortedStrings, Comparator.comparingInt(String::length));

		List<List<String>> result = new ArrayList<List<String>>();
		createNewAnagramGroup(result, strs[0]);

		for (int i = 1; i < strs.length; i++) 
		{
			String currentString = strs[i];

			if (!tryAddStringToExistingAnagramGroup(result, currentString))
				createNewAnagramGroup(result, currentString);
		}

		return result;
	}


	private void createNewAnagramGroup(List<List<String>> anagramGroups, String firstString)
	{
		anagramGroups.add(new ArrayList<String>());
		anagramGroups.get(anagramGroups.size() - 1).add(firstString);
	}


	private boolean tryAddStringToExistingAnagramGroup(List<List<String>> anagramGroups, 
		String currentString)
	{
		int[] currentStringLetterCounts = countLetters(currentString);

		for (int j = 0; j < anagramGroups.size(); j++) 
		{
			List<String> currentAnagramGroup = anagramGroups.get(j);
			String compareString = currentAnagramGroup.get(0); 

			if (currentString.length() != compareString.length())
				continue;

			int[] compareStringLetterCounts = countLetters(compareString);

			if (Arrays.equals(currentStringLetterCounts, compareStringLetterCounts))
			{
				currentAnagramGroup.add(currentString);
				return true;
			}
		}

		return false;
	}


	private int[] countLetters(String s)
	{
		int[] letterCounts = new int[LETTERS_IN_ALPHABET];

		for (int i = 0; i < s.length(); i++)
			letterCounts[s.charAt(i) - 'a']++;
		
		return letterCounts;
	}
}
