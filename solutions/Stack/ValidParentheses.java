package solutions.Stack;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(', '[', '{' -> stack.push(c);
                case ')' -> {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                case ']' -> {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                case '}' -> {
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                default -> {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static void showcase(String[] strings) {
        for (String s : strings) {
            System.out.printf("valid parentheses?: %s, string: %s%n", isValid(s), s);
        }
    }

    public static void main(String[] args) {
        String[] testcases = {
                "()",
                "()[]{}",
                "(]",
                "([])",
                "([)]",
        };

        showcase(testcases);
    }
}
