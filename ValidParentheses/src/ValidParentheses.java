import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char openBracket = stack.pop();
                if ((c == ')' && openBracket != '(') ||
                        (c == ']' && openBracket != '[') ||
                        (c == '}' && openBracket != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()()";
        String s2 = "(()-";
        String s3 = ")(-";

        System.out.println("Строка 1: " + isValid(s1));
        System.out.println("Строка 2: " + isValid(s2));
        System.out.println("Строка 3: " + isValid(s3)); 
    }
}

