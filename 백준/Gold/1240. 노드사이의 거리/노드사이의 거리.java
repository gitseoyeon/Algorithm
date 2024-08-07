import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] node;
    static boolean[] visit;
    static int N, M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        node = new int[N + 1][N + 1];

        for(int i = 1; i < N; i++){
            str = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(str.nextToken());
            int e = Integer.parseInt(str.nextToken());
            int distance = Integer.parseInt(str.nextToken());

            node[s][e] = distance;
            node[e][s] = distance;

        }

        for(int i = 0; i < M; i++){
            visit = new boolean[N + 1];
            str = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(str.nextToken());
            int e = Integer.parseInt(str.nextToken());

            System.out.println(bfs(s, e, visit));
        }

    }

    public static int bfs(int s, int e, boolean[] visit){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{s, 0});
        visit[s] = true;

        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int currentNode = arr[0];
            int distance = arr[1];

            if(currentNode == e){
                return distance;
            }

            for(int i = 1; i <= N; i++){
                if(node[currentNode][i] != 0 && !visit[i]){
                    queue.add(new int[]{i, (distance + node[currentNode][i])});
                    visit[i] = true;
                }
            }
        }
        return -1;
    }
}
