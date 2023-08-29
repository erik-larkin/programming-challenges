/*
 *  https://leetcode.com/problems/product-of-array-except-self/
 *  August 28th 2023
 *  By Erik Larkin
 */

public class ProductOfArrayExceptSelf 
{
	public int[] productExceptSelf(int[] nums) 
	{
		int[] result = new int[nums.length];
		result[0] = 1;

		for (int i = 1; i < result.length; i++)
			result[i] = result[i-1] * nums[i-1];
		
		int suffixProduct = nums[nums.length - 1];

		for (int i = result.length - 2; i >= 0; i--)
		{
			result[i] *= suffixProduct;
			suffixProduct *= nums[i];
		}

		return result;
	}
}
