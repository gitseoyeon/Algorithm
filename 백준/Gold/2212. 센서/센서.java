import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }
        Arrays.sort(arr);
        
        int[] dis = new int[N - 1];
        for(int i = 0; i < N - 1; i++) {
            dis[i] = arr[i + 1] - arr[i];
        }
        Arrays.sort(dis);

        int sum = 0;
        for(int i = 0; i < N - K; i++) {
            sum += dis[i];
        }

        System.out.println(sum);
    }
}