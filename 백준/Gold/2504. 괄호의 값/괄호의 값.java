import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] str = s.split("");
        Stack<String> stack = new Stack<>();
        int sum = 1;
        int answer = 0;
        boolean check = true;

        for(int i = 0; i < str.length; i++){
            if(str[i].equals("(")){
                stack.add(str[i]);
                sum *= 2;
            }else if(str[i].equals("[")){
                stack.add(str[i]);
                sum *= 3;
            }
            else if(str[i].equals(")")){
                if(stack.isEmpty() || !stack.peek().equals("(")){
                    check = false;
                    break;
                }
                if(str[i - 1].equals("(")){
                    answer += sum;
                }
                sum /= 2;
                stack.pop();
            }
            else if(str[i].equals("]")){
                if(stack.isEmpty() || !stack.peek().equals("[")){
                    check = false;
                    break;
                }
                if(str[i - 1].equals("[")){
                    answer += sum;
                }
                sum /= 3;
                stack.pop();
            }
        }

        System.out.println(!stack.isEmpty() || !check ? 0 : answer);
    }
}
