import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            long sum = 0L;
            StringTokenizer str = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for(int j = 0; j < K; j++) {
                pq.offer(Long.parseLong(str.nextToken()));
            }
    
            while(pq.size() > 1) {
                long a = pq.poll();
                long b = pq.poll();

                long hap = a + b;
                pq.offer(hap);
                sum += hap;
            }
            
            System.out.println(sum);

        }
    }    
}
