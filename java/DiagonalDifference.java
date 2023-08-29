/*
 *  https://www.hackerrank.com/challenges/one-week-preparation-kit-diagonal-difference/problem
 *  August 29th 2023
 *  By Erik Larkin
 */

import java.util.List;

public class DiagonalDifference {
	public static int diagonalDifference(List<List<Integer>> arr) {

		int length = arr.size();
		int primaryDiagonalSum = 0;
		int secondaryDiagonalSum = 0;

		for (int i = 0; i < length; i++) {
			primaryDiagonalSum += arr.get(i).get(i);
			int j = length - 1 - i;
			secondaryDiagonalSum += arr.get(j).get(i);
		}

		return Math.abs(primaryDiagonalSum - secondaryDiagonalSum);
	}
}
