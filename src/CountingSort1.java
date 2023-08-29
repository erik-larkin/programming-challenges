/*
 *  https://www.hackerrank.com/challenges/one-week-preparation-kit-countingsort1/problem
 *  August 29th 2023
 *  By Erik Larkin
 */

import java.util.ArrayList;
import java.util.List;

public class CountingSort1 {

	private static final int UNIQUE_INTEGERS = 100;

	public static List<Integer> countingSort(List<Integer> arr) {

		List<Integer> result = new ArrayList<Integer>(UNIQUE_INTEGERS);

		for (int i = 0; i < UNIQUE_INTEGERS; i++) {
			result.add(0);
		}

		for (int number : arr) {
			result.set(number, result.get(number) + 1);
		}

		return result;
    }
}
