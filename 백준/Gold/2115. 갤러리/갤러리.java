import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] wall = new char[M][N];
        int answer = 0;

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                wall[i][j] = s.charAt(j);
            }
        }

        for (int i = 1; i < M; i++) {
            int j = 1;
            while (j < N - 1) {
                if (wall[i - 1][j] == wall[i - 1][j + 1]
                        && wall[i][j] == wall[i][j + 1]
                        && wall[i - 1][j] != wall[i][j]) {
                    answer++;
                    j += 2; 
                } else {
                    j++;
                }
            }
        }

        for (int j = 1; j < N; j++) {
            int i = 1;
            while (i < M - 1) {
                if (wall[i][j - 1] == wall[i + 1][j - 1]
                        && wall[i][j] == wall[i + 1][j]
                        && wall[i][j - 1] != wall[i][j]) {
                    answer++;
                    i += 2; 
                } else {
                    i++;
                }
            }
        }

        System.out.println(answer);
    }
}