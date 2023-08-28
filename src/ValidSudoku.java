/*
 *  https://leetcode.com/problems/valid-sudoku/
 *  August 28th 2023
 *  By Erik Larkin
 */

import java.util.Arrays;

public class ValidSudoku 
{
	private static final char EMPTY_SQUARE = '.';
	private static final int GRID_LENGTH = 9;
	private static final int SUB_BOX_LENGTH = 3;

	private boolean[][] usedNumbersRows = new boolean[GRID_LENGTH][GRID_LENGTH];
	private boolean[][] usedNumbersCols = new boolean[GRID_LENGTH][GRID_LENGTH];
	private boolean[][][] usedNumbersSubBoxes = new boolean[SUB_BOX_LENGTH][SUB_BOX_LENGTH][GRID_LENGTH];

	public boolean isValidSudoku(char[][] board) 
	{
		fillWithFalses(usedNumbersRows);
		fillWithFalses(usedNumbersCols);

		for (int i = 0; i < usedNumbersSubBoxes.length; i++)
			fillWithFalses(usedNumbersSubBoxes[i]);

		for (int i = 0; i < GRID_LENGTH; i++)
		{
			for (int j = 0; j < GRID_LENGTH; j++)
			{
				char c = board[i][j];

				if (c == EMPTY_SQUARE)
					continue;
				
				int charIndex = c - '1';

				if (isNumberUsed(usedNumbersRows[i], charIndex) || isNumberUsed(usedNumbersCols[j], charIndex)
					|| isNumberUsed(usedNumbersSubBoxes[i / 3][j / 3], charIndex))
					return false;
			}
		}

		return true;
	}

	// Although the default value for booleans is supposed to be false, leetcode
	// seems to think otherwise.
	private void fillWithFalses(boolean[][] usedNumbers)
	{
		for (int i = 0; i < usedNumbers.length; i++)
			Arrays.fill(usedNumbers[i], false);
	}

	private boolean isNumberUsed(boolean[] usedNumbers, int number)
	{
		if (!usedNumbers[number])
		{
			usedNumbers[number] = true;
			return false;
		}
		return true;
	}
}