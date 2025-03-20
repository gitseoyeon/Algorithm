import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int N, S, cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        S = Integer.parseInt(str.nextToken());
        cnt = 0;
        arr = new int[N];

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str.nextToken());
        }

        bt(0, 0);
        
        System.out.println(S == 0 ? cnt - 1 : cnt);
    }

    public static void bt(int depth, int sum){
        if(depth == N){
            if(sum == S) cnt++;
            return;
        }

        bt(depth + 1, sum + arr[depth]);
        bt(depth + 1, sum);
    }
}
