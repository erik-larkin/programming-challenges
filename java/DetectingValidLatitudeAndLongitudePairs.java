import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectingValidLatitudeAndLongitudePairs {
	public static void main(String[] args) {
		String regex = "^\\((\\+|-)?(\\d(\\.\\d+)?|[1-8]\\d(\\.\\d+)?|90(\\.0+)?)?, (\\+|-)?(\\d?\\d(\\.\\d+)?|1[0-7]\\d(\\.\\d+)?|180(\\.0+)?)\\)$";
        Pattern coordinatePattern = Pattern.compile(regex);

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();

		for (int i = 0; i < n; i++) {
			String line = scanner.nextLine();
			Matcher coordinateMatcher = coordinatePattern.matcher(line);
			if (coordinateMatcher.find()) {
				System.out.println("Valid");
			} else {
				System.out.println("Invalid");
			}
		}

		scanner.close();
    }
}
