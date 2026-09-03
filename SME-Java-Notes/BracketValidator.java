import java.util.Stack;

public class BracketValidator {

    public static boolean isValid(String s) {

        // stack holds opening brackets we're still waiting to close
        Stack<Character> stack = new Stack<>();

        // go through the string one character at a time
        for (char c : s.toCharArray()) {

            // if it's an opening bracket, push it and move on
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // closing bracket with nothing open to match — invalid
                if (stack.isEmpty()) {
                    return false;
                }

                // pop the most recent opening bracket and check it matches
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        // valid only if every opening bracket found its match
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String s = "((({}))";

        // false: outer '(' never gets closed here
        System.out.println("isValid(\"" + s + "\") = " + isValid(s));

        // a genuinely balanced example for comparison
        String balanced = "({[]})";
        System.out.println("isValid(\"" + balanced + "\") = " + isValid(balanced)); // true
    }
}