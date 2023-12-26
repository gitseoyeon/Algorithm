import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        
        
        for(int i = 0; i < k; i++){
            stack.push(Integer.parseInt(br.readLine()));
            if(stack.peek() == 0){
                stack.pop();
                stack.pop();
            }
        }

        int size = stack.size();
        for(int i= 0; i < size; i++){
            sum += stack.pop();
        }
        System.out.println(sum);

    }
}
