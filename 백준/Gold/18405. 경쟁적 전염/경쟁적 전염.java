import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr;
    public static int N;
    
    static class Virus {
        int v, t, x, y;
        Virus(int v, int t, int x, int y) {
            this.v = v;
            this.t = t;
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        int K = Integer.parseInt(str.nextToken());
        arr = new int[N][N];
        List<Virus> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N; j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
                if(arr[i][j] != 0) {
                    list.add(new Virus(arr[i][j], 0, i, j));
                }
            }
        }

        str = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(str.nextToken());
        int X = Integer.parseInt(str.nextToken());
        int Y = Integer.parseInt(str.nextToken());

        list.sort((a, b) -> a.v - b.v);
        Queue<Virus> queue = new LinkedList<>(list);
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while(!queue.isEmpty()) {
            Virus vir = queue.poll();
            if(vir.t == S) break;

            for(int i = 0; i < 4; i++) {
                int nx = vir.x + dx[i];
                int ny = vir.y + dy[i];
                if(isValid(nx, ny)) {
                    arr[nx][ny] = vir.v;
                    queue.offer(new Virus(vir.v, vir.t + 1, nx, ny));
                }
            }
        }

        System.out.println(arr[X - 1][Y - 1]);
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && arr[x][y] == 0 ? true : false;
    }
}
