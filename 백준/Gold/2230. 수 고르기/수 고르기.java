import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        int[] arr = new int[N];
        int num = 2000000000;

        for(int i= 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for(int i = 0; i < N - 1; i++){
            int tmp = arr[i] + M;
            for(int j = i + 1; j < N; j++){
                if(arr[j] >= tmp){
                    num = Math.min(num, arr[j] - arr[i]);
                }
            }
        }

        System.out.println(num);
    }
}
