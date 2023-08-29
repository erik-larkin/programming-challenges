/*
 *  https://leetcode.com/problems/maximum-length-of-pair-chain/
 *  August 26th 2023
 *  By Erik Larkin
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class MaximumLengthOfPairChain 
{
	public static void main(String[] args)
	{
		int[][] pairs = {
			{1,2},
			{2,3},
			{3,4}
		};

		MaximumLengthOfPairChain solution = new MaximumLengthOfPairChain();
		int result = solution.findLongestChain(pairs);
		System.out.println(result);
	}


	private class PairComparator implements Comparator<int[]>
	{
		@Override
		public int compare(int[] firstPair, int[] secondPair)
		{
			return Integer.compare(firstPair[1], secondPair[1]);
		}
	}


	public int findLongestChain(int[][] pairs) 
	{
		List<int[]> pairList = new ArrayList<int[]>(pairs.length);
		
		for (int i = 0; i < pairs.length; i++)
			pairList.add(i, pairs[i]);

		pairList.sort(new PairComparator());


		int longestLength = 1;
		int currentSecondNumber = pairList.get(0)[1];

		for (int i = 1; i < pairs.length; i++)
		{
			if (pairList.get(i)[0] > currentSecondNumber)
			{
				longestLength++;
				currentSecondNumber = pairList.get(i)[1];
			}
		}

		return longestLength;
    }
}
