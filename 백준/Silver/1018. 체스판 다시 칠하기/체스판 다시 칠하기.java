import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static String[][] arr;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        arr = new String[N][M];

        for(int i = 0; i < N; i++){
            arr[i] = br.readLine().split("");
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                min = Math.min(min, getRepaint(i, j));
            }
        }

        System.out.println(min);
    }

    public static int getRepaint(int x, int y){
        int repaintWB = 0;
        int repaintBW = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    if (!arr[x + i][y + j].equals("W")) repaintWB++;
                    if (!arr[x + i][y + j].equals("B")) repaintBW++;
                } else {
                    if (!arr[x + i][y + j].equals("B")) repaintWB++;
                    if (!arr[x + i][y + j].equals("W")) repaintBW++;
                }
            }
        }

        return Math.min(repaintWB, repaintBW);
    }

}