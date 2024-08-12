import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visit;
    static int ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int K = Integer.parseInt(str.nextToken());
        ans = 100000;
        visit = new boolean[100001];

        bfs(N, K);
        System.out.println(ans);
        
    }

    public static void bfs(int N, int K){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});

        visit[N] = true;

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int p = tmp[0];
            int t = tmp[1];
            visit[p] = true;

            if(p == K){
                ans = Math.min(ans, t);
            }

            if(p * 2 <= 100000 && !visit[p * 2]){
                queue.add(new int[]{p * 2, t});
            }

            if(p + 1 <= 100000 && !visit[p + 1]){
                queue.add(new int[]{p + 1, t + 1});
            }

            if(p - 1 >= 0 && !visit[p - 1]){
                queue.add(new int[]{p - 1, t + 1});
            }
        }
    }
}
