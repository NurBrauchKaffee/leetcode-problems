package solutions.ArrayOrString;


public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        return s.trim().split(" ")[s.trim().split(" ").length - 1].length();
    }

    private static void showcase(String[] strings) {
        for (String s : strings) {
            System.out.printf("length: %d, string: %s%n", lengthOfLastWord(s), s);
        }
    }

    public static void main(String[] args) {
        String[] testcases = {
                "Hello World",
                "   fly me   to   the moon  ",
                "luffy is still joyboy",
        };

        showcase(testcases);
    }
}
