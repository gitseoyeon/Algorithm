import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str;

    int N = Integer.parseInt(br.readLine());
    int[][] arr = new int[N][2];
    int[] yArr = new int[N];
    int idx = 0;

    for(int i = 0; i < N; i++){
        str = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(str.nextToken());
        int y = Integer.parseInt(str.nextToken());

        arr[idx][0] = x;
        arr[idx][1] = y;

        idx++;
    }

    Arrays.sort(arr, (o1, o2) -> {
        if(o1[0] == o2[0]){
            return Integer.compare(o1[1], o2[1]);
        }else{
            return Integer.compare(o1[0], o2[0]);
        }
    });

    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < N; i++) {
        sb.append(arr[i][0]).append(' ').append(arr[i][1]).append('\n');
    }

    System.out.print(sb);

  }
}
