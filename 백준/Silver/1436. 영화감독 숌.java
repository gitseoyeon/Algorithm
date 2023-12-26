import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int n = 665;
        String s = "";

        for(int i = 0; i < N; i++){ 
            while(true){ 
                n++;
                s = Integer.toString(n);
                if(s.contains("666")){
                    break;
                }
            }
        }

        System.out.println(n);
    }
}
