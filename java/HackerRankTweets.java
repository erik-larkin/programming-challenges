import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerRankTweets {
	public static void main(String[] args) {
		Pattern hackerPattern = Pattern.compile("hackerrank", Pattern.CASE_INSENSITIVE);
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();

		int result = 0;
		for (int i = 0; i < n; i++) {
			String line = scanner.nextLine();
			Matcher matcher = hackerPattern.matcher(line);
			if (matcher.find()) {
				result++;
			}
		}
		scanner.close();
		System.out.println(result);
	}
}
