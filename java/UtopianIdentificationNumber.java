import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtopianIdentificationNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		
		Pattern idPattern = Pattern.compile("^[a-z]{3}\\d{2,8}[A-Z]{3,}$");
		for (int i = 0; i < n; i++) {
			String line = scanner.nextLine();
			Matcher idMatcher = idPattern.matcher(line);
			if (idMatcher.find()) {
				System.out.println("VALID");
			} else {
				System.out.println("INVALID");
			}
		}

		scanner.close();
	}
}
