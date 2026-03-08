import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(str.nextToken());
            arr[i][1] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(arr[0][1]);

        for(int i = 1; i < N; i++) {
            if(pq.peek() <= arr[i][0]) {
                pq.poll();
            }
            pq.offer(arr[i][1]);
        }
        System.out.println(pq.size());
    }
}
