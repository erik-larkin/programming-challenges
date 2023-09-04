import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPANFormat {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();

		Pattern panPattern = Pattern.compile("^[A-Z]{5}\\d{4}[A-Z]$");
		for (int i = 0; i < n; i++) {
			String line = scanner.nextLine();
			Matcher panMatcher = panPattern.matcher(line);
			if (panMatcher.find()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		scanner.close();
	}
}
