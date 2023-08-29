public class PalindromeIndex {

	public static int palindromeIndex(String s) {
		System.out.println(s);
		char[] arr = s.toCharArray();
		
		if (isPalindromeIgnoreIndex(arr, -1))
			return -1;
		
		for (int i = 0; i < arr.length; i++) {
			if (isPalindromeIgnoreIndex(arr, i))
				return i;
		}
		
		return -1;
	}
	
	private static boolean isPalindromeIgnoreIndex(char[] s, int ignoreIndex)
   	{
		int i = 0;
		int j = s.length - 1;
		while (i < j) {
			if (i == ignoreIndex)
				i++;
			if (j == ignoreIndex)
				j--;
			if (s[i] != s[j])
				return false;
			i++;
			j--;
		}
		return true;
	} 
}  

