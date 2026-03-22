import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        Deque<int[]> dq = new ArrayDeque<>();

        for(int i = 0; i < N; i++) {
            int move = Integer.parseInt(str.nextToken());
            dq.add(new int[]{i + 1, move});
        }

        StringBuilder sb = new StringBuilder();

        while(!dq.isEmpty()) {
            int[] cur = dq.poll();
            sb.append(cur[0]).append(" ");

            if(dq.isEmpty()) break;

            int move = cur[1];
            if(move > 0) {
                for(int i = 0; i < move - 1; i++) {
                    dq.add(dq.poll());
                }
            } else {
                for(int i = 0; i < Math.abs(move); i++) {
                    dq.addFirst(dq.pollLast());
                }
            }
        }

        System.out.println(sb);
    }    
}
