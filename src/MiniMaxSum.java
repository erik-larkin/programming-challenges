/*
 *  https://www.hackerrank.com/challenges/one-week-preparation-kit-mini-max-sum/problem
 *  August 29th 2023
 *  By Erik Larkin
 */

import java.util.List;

public class MiniMaxSum {

	public static void miniMaxSum(List<Integer> arr) {

		int min = arr.get(0);
		int max = arr.get(0);
		long sum = 0;

		for (int number : arr) {
			sum += number;
			min = Math.min(min, number);
			max = Math.max(max, number);
		}

		System.out.printf("%d %d", sum - max, sum - min);
    }
}