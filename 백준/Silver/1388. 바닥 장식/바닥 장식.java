import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(str.nextToken()); // 세로 길이
        int M = Integer.parseInt(str.nextToken()); // 가로 길이
        String[][] bang = new String[N][M];
        int cnt = 0;

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            String[] arr = s.split("");
            for(int j = 0; j < M; j++){
                bang[i][j] = arr[j];
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (bang[i][j].equals("-")) {
                    if (j == M - 1 || (j + 1 < M && bang[i][j + 1].equals("|"))) {
                        // 다음 칸(j+1)이 | 이거나 같은 행의 마지막 방인 경우
                        cnt++;
                    }
                }
        
                if (bang[i][j].equals("|")) {
                    if (i == N - 1 || (i + 1 < N && bang[i + 1][j].equals("-"))) {
                        // 다음 줄(i+1)이  - 이거나 같은 열의 마지막 방인 경우
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);

    }
    
}
