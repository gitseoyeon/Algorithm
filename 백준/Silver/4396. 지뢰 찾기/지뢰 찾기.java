import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        char[][] arr = new char[N][N];
        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        boolean isBoom = false;
        
        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
            if(!isBoom) {
                for(int j = 0; j< N; j++) {
                    if(arr[i][j] == 'x' && map[i][j] == '*') isBoom = true;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 'x') {
                    if(map[i][j] == '*') {
                        sb.append('*');
                    } else {
                        sb.append(getNum(i, j));
                    }
                } else if(isBoom && map[i][j] == '*') {
                    sb.append('*');
                } else {
                    sb.append('.');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static int getNum(int x, int y) {
        int[] dx = {1, -1, 0, 0, -1 ,-1, 1, 1};
        int[] dy = {0, 0, 1, -1, -1, 1, -1, 1};
        int cnt = 0;

        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(isValid(nx, ny)) {
                if(map[nx][ny] == '*') cnt++;
            }
        }

        return cnt;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N ? true : false;
    }
}
