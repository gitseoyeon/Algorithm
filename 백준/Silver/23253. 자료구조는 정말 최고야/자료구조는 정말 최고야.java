import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        boolean check = true;

        for(int i = 0; i < M; i++) {
            int k = Integer.parseInt(br.readLine());
            str = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(str.nextToken());
            for(int j = 0; j < k - 1; j++) {
                int n2 = Integer.parseInt(str.nextToken());
                if(n2 > n1) {
                    check = false;
                    break;
                } else {
                    n1 = n2;
                }
            }
        }

        if(!check) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}