import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            String[] str = s.split("");
            Stack<String> stack = new Stack<>();

            for(int j = 0; j < str.length; j++){

                if(stack.empty()){
                    stack.push(str[j]);
                    continue;
                }

                if(str[j].equals(stack.peek())){
                    stack.pop();
                }else{
                    stack.push(str[j]);
                }
            }

            if(stack.empty()){
                cnt++;
            }

            stack.clear();
        }

        System.out.println(cnt);

    }
}
