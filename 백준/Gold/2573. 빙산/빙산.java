import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static List<int[]> list;
    static int N, M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        arr = new int[N][M];
        list = new ArrayList<>(); 
        int time = 0;

        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
                if(arr[i][j] > 0) {
                    list.add(new int[]{i, j});
                }
            }
        }

        while(!list.isEmpty()) {
            meltIce();
            time += 1;
            if(isSeperate()) {
                System.out.println(time);
                return;
            }
        }

        System.out.println(0);

    } 
    
    private static void meltIce() {
        int[][] melt = new int[N][M];
        for(int[] tmp : list) {
            int x = tmp[0];
            int y = tmp[1];

            for(int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if(isValid(nx, ny) && arr[nx][ny] == 0) {
                    melt[x][y]++;
                }
            }
        }

        List<int[]> update = new LinkedList<>();
        for(int[] tmp : list) {
            int x = tmp[0];
            int y = tmp[1];

            arr[x][y] = Math.max(0, arr[x][y] - melt[x][y]);

            if(arr[x][y] > 0) {
                update.add(new int[]{x, y});
            }
        }
        list = update;
    }
    
    private static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M ? true : false;
    }
    
    private static boolean isSeperate() {
        if(list.isEmpty()) return false;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        int size = list.size();
        
        queue.offer(list.get(0));
        visited[list.get(0)[0]][list.get(0)[1]] = true;
        
        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            size -= 1;
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(isValid(nx, ny) && !visited[nx][ny] && arr[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return size == 0 ? false : true;
    }
}
