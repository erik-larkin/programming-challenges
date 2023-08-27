/*
 *  https://leetcode.com/problems/two-sum/
 *  August 27th 2023
 *  By Erik Larkin
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> numberIndices = new HashMap<Integer, Integer>(nums.length);

		for (int i = 0; i < nums.length; i++) {
			numberIndices.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			int remainder = target - nums[i];
			Integer j = numberIndices.get(remainder);
			if (j != null && j != i) {
				return new int[]{i, j};
			}
		}

		return null;
	}
}
