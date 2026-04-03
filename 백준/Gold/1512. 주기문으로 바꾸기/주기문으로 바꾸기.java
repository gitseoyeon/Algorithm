import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        String T = br.readLine();
        int ans = 3000;

        for(int i = 1; i <= M; i++) {
            int tmp = 0;
            for(int start = 0; start < i; start++) {
                arr = new int[4];
                int total = 0;
                for(int j = start; j < T.length(); j += i) {
                    char c = T.charAt(j);
                    setCnt(c);
                    total += 1;
                }

                int max = getMax();
                tmp += (total - max);
            }

            ans = Math.min(ans, tmp);
        }
        System.out.println(ans);
    }   
    
    private static void setCnt(char c) {
        if(c == 'A') {
            arr[0] += 1;
        }else if(c == 'C') {
            arr[1] += 1;
        } else if(c == 'G') {
            arr[2] += 1;
        } else {
            arr[3] += 1;
        }
    }

    private static int getMax() {
        int max = 0;
        for(int n : arr) {
            max = Math.max(n, max);
        }
        return max;
    }
}
