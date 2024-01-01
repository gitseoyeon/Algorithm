import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[11];

        // 1-3까지 각각 더하는 가지수 저장
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // 4-10까지 더하는 가지수 저장
        for(int i = 4; i < 11; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        // 입력한 값의 더한 가지수 출력
        for(int i = 0; i <T; i++){
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }
    
}
