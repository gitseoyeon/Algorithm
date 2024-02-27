import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str= new StringTokenizer(br.readLine());

        int M = Integer.parseInt(str.nextToken());
        int N = Integer.parseInt(str.nextToken());

        for(int i = M; i <= N; i++){
            is_prime(i);
        }

    }

    public static void is_prime(int num){
        if(num < 2){
            return;
        }else if(num == 2){
            System.out.println(num);
            return;
        }else{
            for(int i = 2; i <= Math.sqrt(num); i++){
                if(num % i == 0){
                    return;
                }
            } 
            System.out.println(num);
            return;
        }
    }
    
}
