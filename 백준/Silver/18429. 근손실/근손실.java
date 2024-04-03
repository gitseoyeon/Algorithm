import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] kit;
    public static boolean[] check;
    public static int N;
    public static int K;
    public static int cnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());
        check = new boolean[N];

        str = new StringTokenizer(br.readLine());
        kit = new int[N];

        for(int i = 0; i < N; i++){
            kit[i] = Integer.parseInt(str.nextToken());
        }

        bt(0, 500);
        System.out.println(cnt);
    }

    public static void bt(int d, int m){
        if(d == N - 1 && m >= 500){
            cnt++;
            return;
        }

        for(int i = 0; i < N; i++){
            if(!check[i]){
                check[i] = true;
                if(m - K + kit[i] >= 500){
                    bt(d + 1, m - K + kit[i]);
                }
                check[i] = false;
            }
        }
    }
}
