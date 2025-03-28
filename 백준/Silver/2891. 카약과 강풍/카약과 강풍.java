import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int S = Integer.parseInt(str.nextToken()); 
        int R = Integer.parseInt(str.nextToken()); 
        
        int[] arr = new int[N + 2];
        Arrays.fill(arr, 1);

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < S; i++){
            arr[Integer.parseInt(str.nextToken())]--;
        }
            

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < R; i++){
            arr[Integer.parseInt(str.nextToken())]++;
        } 

        for (int i = 1; i <= N; i++) {
            if (arr[i] == 2) {
                if (arr[i - 1] == 0) arr[i - 1]++;
                else if (arr[i + 1] == 0) arr[i + 1]++;
            }
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++){
            if (arr[i] == 0) cnt++;
        }
        System.out.println(cnt);
    }
}