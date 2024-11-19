import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int K = Integer.parseInt(str.nextToken());
        int[][] arr = new int[N][4];
        int rank = 1;

        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());

            for(int j = 0; j < 4; j++){
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (b[1] != a[1]) {
                    return b[1] - a[1];
                } else if (b[2] != a[2]) {
                    return b[2] - a[2];
                } else {
                    return b[3] - a[3];
                }
            }
        };

        Arrays.sort(arr, comparator);

        int[] prev = new int[] {arr[0][1], arr[0][2], arr[0][3]};
        for(int i = 0; i < N; i++){
            if (Arrays.equals(arr[i], prev)) {
                rank = i + 1; 
                prev = new int[] {arr[i][1], arr[i][2], arr[i][3]};
            }
            if(arr[i][0] == K){
                System.out.println(rank);
            }
            rank++;
        }

    }
}
