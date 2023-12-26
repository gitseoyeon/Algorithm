import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        if(X == 0){
            System.out.println("NO");
            System.exit(0);
        }
        while (X != 0){
            if(X % 3 > 1){
                    System.out.println("NO");
                    System.exit(0);
            }
            X /= 3;
        }

        System.out.println("YES");
    }


}
    

