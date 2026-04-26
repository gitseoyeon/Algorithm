import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String move = br.readLine();

        map = new char[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = '.';
            }
        }

        int[] cur = {0, 0};

        for(int i = 0; i < move.length(); i++) {
            char dir = move.charAt(i);
            int[] next = getPos(dir, cur);

            if(cur[0] == next[0] && cur[1] == next[1]) continue;

            if(dir == 'U' || dir == 'D') {
                draw(cur[0], cur[1], '|');
                draw(next[0], next[1], '|');
            } else {
                draw(cur[0], cur[1], '-');
                draw(next[0], next[1], '-');
            }

            cur = next;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static void draw(int x, int y, char c) {
        if(map[x][y] == '.') {
            map[x][y] = c;
        } else if(map[x][y] != c) {
            map[x][y] = '+';
        }
    }

    private static int[] getPos(char dir, int[] curPos) {
        if(dir == 'D') {
            if(curPos[0] + 1 >= N) return curPos;
            return new int[]{curPos[0] + 1, curPos[1]};
        }
        if(dir == 'U') {
            if(curPos[0] - 1 < 0) return curPos;
            return new int[]{curPos[0] - 1, curPos[1]};
        }
        if(dir == 'R') {
            if(curPos[1] + 1 >= N) return curPos;
            return new int[]{curPos[0], curPos[1] + 1};
        }
        if(dir == 'L') {
            if(curPos[1] - 1 < 0) return curPos;
            return new int[]{curPos[0], curPos[1] - 1};
        }
        return curPos;
    }
}