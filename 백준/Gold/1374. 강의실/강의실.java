import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int room;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        room = 1;

        for(int i = 0; i < N; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(arr[0]);

        for (int i = 1; i < N; i++) {
            int[] current = arr[i];
            int[] tmp = pq.peek();
            if (tmp[2] <= current[1]) {
                pq.poll();
            } 
            pq.offer(current);
        }

        System.out.println(pq.size());
    }
}