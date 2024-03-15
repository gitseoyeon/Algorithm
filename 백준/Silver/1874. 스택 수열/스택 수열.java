import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int start = 1;

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num >= start){
                for(int j = start; j <= num; j++){
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                start = num + 1;
            }

            if(stack.peek() != num){
                System.out.print("NO");
                System.exit(0);
            }
            stack.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }
}
