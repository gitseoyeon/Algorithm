import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int N, E;
    static int result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < E; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        dfs(1);

        System.out.println(result - 1);
    }

    public static void dfs(int node){
        visited[node] = true;
        result += 1;
        for(int i = 1; i <= N; i++){
            if(arr[node][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
}
