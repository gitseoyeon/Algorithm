import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (bfs(map, N)) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    public static boolean bfs(int[][] map, int N) {
        boolean[][] check = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0});
        check[0][0] = true;

        while (!queue.isEmpty()) {
            int[] loacate = queue.poll();
            int x = loacate[0];
            int y = loacate[1];
            int jump = map[x][y];

            if (map[x][y] == -1) {
                return true;
            }

            int nx = x;
            int ny = y + jump;
            if (ny < N && !check[nx][ny]) {
                queue.add(new int[]{nx, ny});
                check[nx][ny] = true;
            }

            nx = x + jump;
            ny = y;
            if (nx < N && !check[nx][ny]) {
                queue.add(new int[]{nx, ny});
                check[nx][ny] = true;
            }
        }

        return false;
    }
}
