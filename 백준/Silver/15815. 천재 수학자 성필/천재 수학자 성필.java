import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> num = new Stack<>();
        String s = br.readLine();

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num.push(c - '0');
            } else {
                int b = num.pop();
                int a = num.pop();
                switch (c) {
                    case '+': num.push(a + b); break;
                    case '-': num.push(a - b); break;
                    case '*': num.push(a * b); break;
                    case '/': num.push(a / b); break;
                }
            }
        }
        System.out.println(num.pop());
    }
}
