public class RecursiveDigitSum {
	public static int superDigit(String n, int k) {

		return calculateSuperDigit(n, k);	
	}

	public static int calculateSuperDigit(String n, int k) {
		if (n.length() == 1 && k == 1) {
			return Integer.parseInt(n);
		} else if (n.length() == 1) {
			String s = Integer.toString(Integer.parseInt(n) * k);
			return calculateSuperDigit(sumDigits(s), 1);
		} else {
			return calculateSuperDigit(sumDigits(n), k);
		}
	}

	private static String sumDigits(String n) {
		char[] digits = n.toCharArray();

		int total = 0;
		for (char c : digits) {
			total += (c - '0');
		}

		return Integer.toString(total);
	}
}
