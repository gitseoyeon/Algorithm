import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int w;
    public static int h;
    public static int[][] map;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer str = new StringTokenizer(br.readLine());
            w = Integer.parseInt(str.nextToken());
            h = Integer.parseInt(str.nextToken());
            visit = new boolean[h][w];
            int cnt = 0;

            if(w == 0 && h == 0){
                break;
            }

            map = new int[h][w];

            for(int i = 0; i < h; i++){
                str = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    map[i][j] = Integer.parseInt(str.nextToken());
                }
            }

            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(map[i][j] == 1 && !visit[i][j]){
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
        
    }

    public static void dfs(int i, int j){

        visit[i][j] = true;

        for(int k = 0; k < 8; k++){
            int x = i + dx[k];
            int y = j + dy[k];

            if(x >= 0 && y >= 0 && x < h && y < w){
                if(map[x][y] == 1 && !visit[x][y]){
                    dfs(x, y);
                }
            }
             
        }

    }
}
