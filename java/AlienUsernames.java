import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class AlienUsernames {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();

		Pattern usernamePattern = Pattern.compile("^(_|\\.)\\d+[a-zA-Z]*_?$");
		for (int i = 0; i < n; i++) {
			String username = scanner.nextLine();
			Matcher usernameMatcher = usernamePattern.matcher(username);
			
			if (usernameMatcher.find()) {
				System.out.println("VALID");
			} else {
				System.out.println("INVALID");
			}
		}
		scanner.close();
	}
}