import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, K;
    static int[] arr;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        str = new StringTokenizer(br.readLine());
        arr = new int[K];
        answer = 0;
        for(int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        for(int i = 0; i < K; i++) {
            dfs(arr[i]);
        }

        System.out.println(answer);
    }

    public static void dfs(int num) {
        if(num > N) return;
        answer = Math.max(answer, num);

        for(int i = 0; i < K; i++) {
            dfs(num * 10 + arr[i]);
        }
    }
}