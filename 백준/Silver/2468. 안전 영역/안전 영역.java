import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, cnt, max;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        int maxRain = 0;

        for(int i = 0; i < N; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(str.nextToken());
                maxRain = Math.max(maxRain, arr[i][j]);
            }
        }

        for(int r = 0; r <= maxRain; r++){
            cnt = 0;
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j] && arr[i][j] > r){
                        dfs(r, i, j);
                        cnt++;
                    }
                }
            }
            max = Math.max(cnt, max);
        }
        System.out.println(max);

    }
    public static void dfs(int rain, int x, int y){
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                if(!visited[nx][ny] && arr[nx][ny] > rain){
                    dfs(rain, nx, ny);
                }
            }
        }
    }
}
