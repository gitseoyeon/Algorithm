import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        M = Integer.parseInt(str.nextToken());
        N = Integer.parseInt(str.nextToken());
        String[][] arr = new String[N][M];

        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine().split("");
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        visited = new boolean[N][M];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        visited[0][0] = true;
        pq.offer(new int[]{0, 0, 0});
        while(!pq.isEmpty()) {
            int[] tmp = pq.poll();
            if(tmp[0] == N - 1 && tmp[1] == M - 1) {
                System.out.println(tmp[2]);
                return;
            }
            for(int i = 0; i < 4; i ++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if(isValid(nx, ny)) {
                    visited[nx][ny] = true;
                    if(arr[nx][ny].equals("1")) {
                        pq.offer(new int[]{nx, ny, tmp[2] + 1});
                    } else {
                        pq.offer(new int[]{nx, ny, tmp[2]});
                    }
                }
            }
        }

    }    

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M && !visited[x][y] ? true : false;
    }
}
