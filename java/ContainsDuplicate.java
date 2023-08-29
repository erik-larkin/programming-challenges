
/*
 *  https://leetcode.com/problems/contains-duplicate/
 *  August 27th 2023
 *  By Erik Larkin
 */

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate 
{
	public boolean containsDuplicate(int[] nums) 
	{
		Set<Integer> uniqueNums = new HashSet<Integer>();

		for (int i = 0; i < nums.length; i++)
		{
			if (uniqueNums.contains(nums[i]))
				return true;
			
			uniqueNums.add(nums[i]);
		}

		return false;
	}
}
