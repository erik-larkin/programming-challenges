/*
 *  https://www.hackerrank.com/challenges/one-week-preparation-kit-plus-minus/problem
 *  August 26th 2023
 *  By Erik Larkin
 */

import java.util.List;

public class PlusMinus 
{
	public static void plusMinus(List<Integer> arr) 
	{
		float positiveCount = 0;
		float negativeCount = 0;
		float zeroCount = 0;

		for (Integer number : arr)
		{
			if (number > 0)
				positiveCount++;
			else if (number < 0)
				negativeCount++;
			else
				zeroCount++;
		}

		float n = arr.size();
		System.out.printf("%f%n%f%n%f", positiveCount / n, negativeCount / n,
			zeroCount / n);
    }
}
