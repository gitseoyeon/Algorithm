import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[][] d;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(str.nextToken());
        int m = Integer.parseInt(str.nextToken());
        
        d = new long[n + 1][m + 1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                d[i][j] = -1;       
            }
        }
    
        System.out.println(dp(n, m) % 1000000007);
    }
    
    public static long dp(int n, int m){
        if(d[n][m] != -1){
            return d[n][m];
        }
        if(n == 0 || m == 0){
            return 0;
        }
        if(n == 1 && m == 1){
            return 1;
        }
        
        d[n][m] = (dp(n, m - 1) + dp(n - 1, m) + dp(n - 1, m - 1)) % 1000000007;
        return d[n][m];
    }
    
}
