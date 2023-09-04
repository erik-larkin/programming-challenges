import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAddressValidation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();

		Pattern v6Pattern = Pattern.compile("^([abcdef\\d]{1,4}:){7}[abcdef\\d]{1,4}$");
		Pattern v4Pattern = Pattern.compile("^(([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])\\.){3}([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])$");

		for (int i = 0; i < n; i++) {
			String line = scanner.nextLine();
			Matcher v4Matcher = v4Pattern.matcher(line);
			Matcher v6Matcher = v6Pattern.matcher(line);

			if (v4Matcher.find()) {
				System.out.println("IPv4");
			} else if (v6Matcher.find()) {
				System.out.println("IPv6");
			} else {
				System.out.println("Neither");
			}
		}

		scanner.close();
	}
}
