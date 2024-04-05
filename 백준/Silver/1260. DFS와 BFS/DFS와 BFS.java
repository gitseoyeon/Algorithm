import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, V;
    public static boolean[][] arr;
    public static boolean[] check;
    public static Queue<Integer> queue;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        V = Integer.parseInt(str.nextToken());

        arr = new boolean[N + 1][N + 1];
        check = new boolean[N + 1];

        for(int i = 0; i < M; i++){
            str = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(str.nextToken());
            int n2 = Integer.parseInt(str.nextToken());

            arr[n1][n2] = arr[n2][n1] = true;
        }

        dfs(V);
        System.out.println();
        check = new boolean[N + 1];
        bfs(V);

    }

    public static void dfs(int V){
        check[V] = true;
        System.out.print(V + " ");

        for(int i = 1; i <= N; i++){
            if(!check[i] && arr[V][i] == true){
                dfs(i);
            }
        }
    }

    public static void bfs(int V){
        queue = new LinkedList<>();
        queue.add(V);
        check[V] = true;
        System.out.print(V + " ");

        while(!queue.isEmpty()){
            V = queue.poll();
            for(int i = 1; i <= N; i++){
                if(arr[V][i] == true && !check[i]){
                    queue.add(i);
                    check[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

}
