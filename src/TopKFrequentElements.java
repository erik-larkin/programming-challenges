/*
 *  https://leetcode.com/problems/top-k-frequent-elements/
 *  August 28th 2023
 *  By Erik Larkin
 */

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class TopKFrequentElements 
{
	public int[] topKFrequent(int[] nums, int k) 
	{
		Map<Integer, Integer> frequencies = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++)
		{
			int number = nums[i];
			int newFrequency = 1;

			if (frequencies.containsKey(number))
				newFrequency = frequencies.get(number) + 1;

			frequencies.put(number, newFrequency);
		}

		List<List<Integer>> frequenciesAsIndices = new ArrayList<List<Integer>>(nums.length + 1);
		
		for (int i = 0; i < nums.length + 1; i++)
			frequenciesAsIndices.add(new ArrayList<Integer>());

		for (Integer key : frequencies.keySet())
			frequenciesAsIndices.get(frequencies.get(key)).add(key);
		
		int[] result = new int[k];
		int j = 0;

		for (int i = nums.length; i >= 0; i--)
		{
			for (Integer number : frequenciesAsIndices.get(i))
			{
				if (number != null)
				{
					result[j] = number;
					j++;

					if (j == k)
						return result;
				}
			}
		}
		return result;
	}
}
