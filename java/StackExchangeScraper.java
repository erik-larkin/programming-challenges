import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StackExchangeScraper {
    
    public static void main(String[] args) {
        Pattern identifierPattern = Pattern.compile("(?<=\"question-summary-)\\d+(?=\">)");
        Pattern questionPattern = Pattern.compile("(?<=\"question-hyperlink\">).+(?=<\\/a)");
        Pattern timePattern = Pattern.compile("(?<=\"relativetime\">).+(?=<\\/span)");
    
        Scanner scanner = new Scanner(System.in);        
        int counter = 0;
        StringBuilder builder = new StringBuilder();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            Matcher matcher;
            switch(counter) {
                case 0:
                    matcher = identifierPattern.matcher(line);
                    break;
                case 1:
                    matcher = questionPattern.matcher(line);
                    break;
                default:
                case 2:
                    matcher = timePattern.matcher(line);
                    break;
            }

            if (matcher.find()) {
                builder.append(matcher.group().trim()).append(';');
                counter = (counter + 1) % 3;

                if (counter == 0) {
                    builder.deleteCharAt(builder.length() - 1);
                    builder.append('\n');
                }
            }
        }

        scanner.close();
        System.out.print(builder);
    }
}
