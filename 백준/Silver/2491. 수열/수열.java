import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }
        
        int asc = arr[0];
        int ascCnt = 1;
        int ascMax = 1;
        int desc = arr[0];
        int descCnt = 1;
        int descMax = 1;

        for(int i = 1; i < N; i++) {
            int num = arr[i];
            if(asc <= num) {
                asc = num;
                ascCnt += 1;
                ascMax = Math.max(ascCnt, ascMax);
            } else if(asc > num) {
                asc = num;
                ascCnt = 1;
            }
            
            if(desc >= num) {
                desc = num;
                descCnt += 1;
                descMax = Math.max(descCnt, descMax);
            } else if(desc < num) {
                desc = num;
                descCnt = 1;
            }
        }

        System.out.println(Math.max(ascMax, descMax));
    }
}