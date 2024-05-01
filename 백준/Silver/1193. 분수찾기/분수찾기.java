import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int depth = 0;

        while(X - depth > 0){
            X -= depth;
            depth++;
        }

        int sum = depth + 1;
        int bunmo = 0;
        int bunja = 0;

        if(depth % 2 == 0){
            bunmo = sum - X;
            bunja = X;
        }else{
            bunmo = X;
            bunja = sum - X;
        }

        System.out.println(bunja + "/" + bunmo);
    }
  
}
