import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.SortedSet;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class DetectHTMLAttributes {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        Pattern nodePattern = Pattern.compile("<[^>]+>");
        Pattern tagPattern = Pattern.compile("(?<=<)\\w+");
        Pattern attributePattern = Pattern.compile("\\w+\\s*(?=\\=(\"|\'))");
        
        SortedMap<String, SortedSet<String>> result = new TreeMap<String, SortedSet<String>>();
        
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            Matcher nodeMatcher = nodePattern.matcher(line);
            
            while (nodeMatcher.find()) {
                String node = nodeMatcher.group();
                
                Matcher tagMatcher = tagPattern.matcher(node);
                Matcher attributeMatcher = attributePattern.matcher(node);
                
                if (tagMatcher.find()) {
                    String tag = tagMatcher.group().trim();
                    SortedSet<String> attributes = new TreeSet<String>();
                    
                    while (attributeMatcher.find()) {
                        attributes.add(attributeMatcher.group().trim());
                    }
                    
                    if (result.containsKey(tag)) {
                        result.get(tag).addAll(attributes);
                    } else {
                        result.put(tag, attributes);
                    }
                }
            }
        }
        scanner.close();
        
        StringBuilder builder = new StringBuilder();
        for (String tag : result.keySet()) {
            builder.append(tag).append(':');
            result.get(tag).forEach(s -> builder.append(s).append(','));
            
            if (builder.charAt(builder.length() - 1) == ',') {
                builder.deleteCharAt(builder.length() - 1);
            }
            
            builder.append('\n');
        }
        System.out.print(builder);
    }
}
