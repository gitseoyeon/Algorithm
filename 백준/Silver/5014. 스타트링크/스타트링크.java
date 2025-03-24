import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int F, S, G, U, D;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        F = Integer.parseInt(str.nextToken());
        S = Integer.parseInt(str.nextToken());
        G = Integer.parseInt(str.nextToken());
        U =Integer.parseInt(str.nextToken());
        D = Integer.parseInt(str.nextToken());
        visited = new boolean[F + 1];
        distance = new int[F + 1];

        if(S == G){
            System.out.println(0);
            return;
        }
        int answer = bfs(S);

        System.out.println(answer != -1 ? answer : "use the stairs");
    }

    public static int bfs(int floor){
        Queue<Integer> queue = new LinkedList<>();
        visited[floor] = true;
        queue.offer(floor);

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            int up = tmp + U;
            int down = tmp - D;

            if(up <= F && !visited[up]){
                if(up == G){
                    return distance[tmp] + 1;
                }
                visited[up] = true;
                queue.offer(up);
                distance[up] = distance[tmp] + 1;
            }

            if(down > 0 && !visited[down]){
                if(down == G){
                    return distance[tmp] + 1;
                }
                visited[down] = true;
                queue.offer(down);
                distance[down] = distance[tmp] + 1;
            }
        }
        return -1;
    }
}
