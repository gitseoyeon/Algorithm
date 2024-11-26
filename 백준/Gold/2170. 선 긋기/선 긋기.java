import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int l = 0;
        
        for(int i = 0; i < N; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(str.nextToken());
            arr[i][1] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        int x = arr[0][0];
        int y = arr[0][1];

        for(int i = 1; i < arr.length; i++){
            if(arr[i][0] <= y && y < arr[i][1]){
                y = arr[i][1];
            }
            if(y < arr[i][0]){
                l += y - x;
                x = arr[i][0];
                y = arr[i][1];
            }
        }
        l += y - x;

        System.out.println(l);
    }
}
