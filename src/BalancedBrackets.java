import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class BalancedBrackets {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {

        Stack<Character> stack = new Stack<Character>();
        final String YES = "YES";
        final String NO = "NO";

        String balanced = YES;
        boolean usedStack = false;

        for(int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            if (value == '{') {
                stack.push('}');
            } else if (value == '[') {
                stack.push(']');
            } else if (value == '(') {
                stack.push(')');
            } else {
                char expectedValue;

                if (!stack.empty()) {
                    expectedValue = stack.pop();
                    usedStack = true;
                } else {
                    balanced = NO;
                    break;
                }

                if (expectedValue != value) {
                    balanced = NO;
                }
            }
        }

        if ((!usedStack && s.length() > 0) || !stack.empty()) {
            balanced = NO;
        }

        return balanced;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

