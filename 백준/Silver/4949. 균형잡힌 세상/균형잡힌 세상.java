import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '[' || c == '(') {
                    stack.push(c);
                }
                else if (c == ']' || c == ')') {
                    if (stack.isEmpty()) {
                        isBalanced = false;
                        break;
                    }
                    char top = stack.pop();
                    if ((c == ']' && top != '[') || (c == ')' && top != '(')) {
                        isBalanced = false;
                        break;
                    }
                }
            }

            if (isBalanced && stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
