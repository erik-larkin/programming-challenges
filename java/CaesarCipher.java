public class CaesarCipher {

	private static final int LETTERS_IN_ALPHABET = 26;

    public static String caesarCipher(String s, int k) {
		
		int forwardRotation = k % LETTERS_IN_ALPHABET;
		int reverseRotation = forwardRotation - LETTERS_IN_ALPHABET;

		char[] letters = s.toCharArray();

		for (int i = 0; i < letters.length; i++) {
			char c = letters[i];

			if (isLetter(c)) {

				int rotation = forwardRotation;

				if ((isLowercase(c) && (c + rotation > 'z')) ||
						(isUppercase(c) && (c + rotation > 'Z'))) {
					rotation = reverseRotation;
				}

				letters[i] = (char) (c + rotation);
			}
		}
		
		return new String(letters);
	}

	private static boolean isLetter(char c) {
		return isLowercase(c) || isUppercase(c);
	}

	private static boolean isLowercase(char c) {
		return c >= 'a' && c <= 'z';
	}

	private static boolean isUppercase(char c) {
		return c >= 'A' && c <= 'Z';
	}
}
