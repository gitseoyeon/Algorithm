import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T!=0){
            int N = Integer.parseInt(br.readLine());
            long[] dp = new long[101];
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;

            for (int i = 4; i <= N; i++) {
                dp[i] = dp[i - 2] + dp[i - 3];
            }

            System.out.println(dp[N]);
            T--;
        }
    }
}