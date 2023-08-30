import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class BalancedBrackets {
    private static Map<Character, Character> bracketMap = new TreeMap<Character, Character>();

    public static String isBalanced(String s) {
        bracketMap.put('(', ')');
        bracketMap.put('{', '}');
        bracketMap.put('[', ']');
        Stack<Character> closingBracketStack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);

            if (isClosingBracket(bracket)) {
                if (isNotExpectedClosingBracket(closingBracketStack, bracket)) {
                    return "NO";
                } else {
                    closingBracketStack.pop();
                }
            } else {
                closingBracketStack.push(bracketMap.get(bracket));
            }
        }

        if (closingBracketStack.isEmpty()){
            return "YES";
        }
            
        return "NO";
    }

    private static boolean isClosingBracket(char bracket) {
        return !bracketMap.containsKey(bracket);
    }

    private static boolean isNotExpectedClosingBracket(Stack<Character> closingBracketStack, char bracket) {
        return closingBracketStack.isEmpty() || bracket != closingBracketStack.peek();
    }
}
