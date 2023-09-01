/*
 *  Basically copied from the solution in the editorial. This one was awful.
 */

public class LegoBlocks {

	private static final int MAX_BLOCK_SIZE = 4;
	private static final long MODULO = 1000000007;


	public static int legoBlocks(int n, int m) {

		int width = m;
		int height = n;

		long[] rowPermutationCounts = countRowPermutations(width);
		long[] wallPermutationCounts = countWallPermutations(width, height, rowPermutationCounts);
		long[] solidWallPermutationCounts = countSolidWallPermutations(width, wallPermutationCounts);

		return (int) (solidWallPermutationCounts[width] % MODULO);
	}


	private static long[] countRowPermutations(int width) {
		long[] result = new long[width + 1];

		result[0] = 1;
		for (int rowWidth = 1; rowWidth < result.length; rowWidth++) {
			for (int blockSize = 1; blockSize <= MAX_BLOCK_SIZE; blockSize++) {
				if (rowWidth - blockSize >= 0) {
					result[rowWidth] = (result[rowWidth] + result[rowWidth - blockSize]) % MODULO;
				}
			}
		}

		return result;
	}


	private static long[] countWallPermutations(int width, int height, long[] rowPermutationCounts) {
		long[] result = new long[width + 1];
		for (int rowWidth = 1; rowWidth < result.length; rowWidth++) {
			result[rowWidth] = power(rowPermutationCounts[rowWidth], height);
		}
		return result;
	}


	private static long power(long base, int power) {
		long result = 1;
		while (power != 0) {
			if (power % 2 != 0) {
				result = (result * base) % MODULO;
			}
			base = (base * base) % MODULO;
			power /= 2;
		}
		return result;
	}


	private static long[] countSolidWallPermutations(int width, long[] wallPermutationCounts) {
		long[] result = new long[width + 1];
		result[1] = 1;
		for (int rowWidth = 2; rowWidth < result.length; rowWidth++) {
			result[rowWidth] = wallPermutationCounts[rowWidth];
			long invalidPermutations = 0;
			for (int leftCutWidth = 1; leftCutWidth < rowWidth; leftCutWidth++) {
				int rightCutWidth = rowWidth - leftCutWidth;
				invalidPermutations = (invalidPermutations + (result[leftCutWidth] * wallPermutationCounts[rightCutWidth])) % MODULO;
			}
			result[rowWidth] = (result[rowWidth] - invalidPermutations ) % MODULO;
		}
		return result;
	}
}