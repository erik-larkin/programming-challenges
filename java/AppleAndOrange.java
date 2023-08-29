/*
 *  https://www.hackerrank.com/challenges/apple-and-orange/problem
 *  August 26th 2023
 *  By Erik Larkin
 */

import java.util.List;

public class AppleAndOrange
{
    public static void countApplesAndOranges(int s, int t, int a, int b, 
		List<Integer> apples, List<Integer> oranges) 
	{
		int numberOfApples = countFruit(s, t, a, apples);
		int numberOfOranges = countFruit(s, t, b, oranges);

		System.out.printf("%d%n%d", numberOfApples, numberOfOranges);
    }

	private static int countFruit(int s, int t, int treePosition,
		List<Integer> fruit)
	{
		int numberOfFruit = 0;

		for (int distance : fruit)
		{
			int fruitPosition = treePosition + distance;
			if (fruitPosition >= s && fruitPosition <= t)
				numberOfFruit++;
		}

		return numberOfFruit;
	}
}