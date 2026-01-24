import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int[] arr = new int[L];
        StringTokenizer str = new StringTokenizer(br.readLine());

        for(int i = 0; i < L; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }
        Arrays.sort(arr);

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int min = 1;
        int max = 0;
        int idx = 0;

        while(idx < L) {
            if(arr[idx] == n) {
                System.out.println(answer);
                return;
            }
            if(arr[idx] < n) {
                min = arr[idx] + 1;
            }
            if(arr[idx] > n) {
                max = arr[idx] - 1;
                break;
            }
            idx += 1;
        }

        for(int i = min; i <= n; i++) {
            for(int j = n; j <= max; j++) {
                answer += 1;
            }
        }

        System.out.println(answer - 1);
    }
}