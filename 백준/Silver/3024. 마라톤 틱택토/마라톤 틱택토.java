import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] arr = new char[N][N]; // 게임보드 값 입력 받을 배열
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < N - 2; j++) {
                if (arr[i][j] != '.') {
                    // 대각선 방향으로 연속인지 확인
                    if (arr[i][j] == arr[i + 1][j + 1] && arr[i][j] == arr[i + 2][j + 2]) {
                        System.out.println(arr[i][j]);
                        System.exit(0);
                    }
                }
            }
        }

        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < N - 2; j++) {
                if (arr[i][N - j - 1] != '.') {
                    // 반대 대각선으로 연속인지 
                    if (arr[i][N - j - 1] == arr[i + 1][N - (j + 1) - 1] && arr[i][N - j - 1] == arr[i + 2][N - (j + 2) - 1]) {
                        System.out.println(arr[i][N - j - 1]);
                        System.exit(0);
                    }
                }
            }
        }

        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != '.') {
                    // 세로 방향으로 연속인지 확인
                    if (arr[i][j] == arr[i + 1][j] && arr[i][j] == arr[i + 2][j]) {
                        System.out.println(arr[i][j]);
                        System.exit(0);
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 2; j++) {
                if (arr[i][j] != '.') {
                    // 가로로 연속인지 확인
                    if (arr[i][j] == arr[i][j + 1] && arr[i][j] == arr[i][j + 2]) {
                        System.out.println(arr[i][j]);
                        System.exit(0);
                    }
                }
            }
        }

        // 모든 조건을 만족하지 않을 경우
        System.out.println("ongoing");
    }
}
