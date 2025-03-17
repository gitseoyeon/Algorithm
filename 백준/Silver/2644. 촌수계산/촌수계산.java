import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static ArrayList<Integer>[] family;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(str.nextToken());
        int p2 = Integer.parseInt(str.nextToken());
        int m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        family = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++){
            family[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            family[a].add(b);
            family[b].add(a);
        }

        
        System.out.println(bfs(p1, p2));
    }

    public static int bfs(int p1, int p2){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{p1, 0});
        visited[p1] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int p = cur[0];
            int chon = cur[1];

            if(p == p2) return chon;

            for(int i : family[p]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(new int[]{i, chon + 1});
                }
            }
        }
        return -1;
    }
}
