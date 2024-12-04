import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int K = Integer.parseInt(str.nextToken());
        int[][] arr = new int[N + 1][K + 1];
        int[] w = new int[N + 1];
        int[] v = new int[N + 1];

        for(int i = 1; i <= N; i++){
            str = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(str.nextToken());
            v[i] = Integer.parseInt(str.nextToken());
        }
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= K; j++){
                if(w[i] > j){
                    arr[i][j] = arr[i - 1][j];
                }else{
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i - 1][j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(arr[N][K]);
    }
}
