import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer str = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(str.nextToken());
       int M = Integer.parseInt(str.nextToken());
       int[][] arr = new int[N][M];
       boolean[][] visited = new boolean[N][M];
       boolean completed = false;
       
       for(int i = 0; i < N; i++){
        String[] s = br.readLine().split("");
        for(int j = 0; j < M; j++){
            arr[i][j] = Integer.parseInt(s[j]);
        }
       }

       Queue<int[]> queue = new LinkedList<>();
       queue.offer(new int[]{0, 0});
       
       while(!queue.isEmpty()){
        int[] tmp = queue.poll();
        int x = tmp[0];
        int y = tmp[1];
        if(x == N - 1 && y == M - 1){
            completed = true;
            break;
        }
        for(int i = 0; i < 4; i++){
            int changex = x + dx[i];
            int changey = y + dy[i];
            if(changex >= 0 && changex < N && changey >= 0 && changey < M && !visited[changex][changey] && arr[changex][changey] == 1){
                visited[changex][changey] = true;
                queue.offer(new int[]{changex, changey});
                arr[changex][changey] = arr[x][y] + 1;
            }
        }
       }

       if(completed){
        System.out.println(arr[N - 1][M - 1]);
       }else{
        System.out.println(0);
       }
       
    }

}