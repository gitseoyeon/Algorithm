import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(str.nextToken());
            int M = Integer.parseInt(str.nextToken());

            for(int j = 0; j < M; j++){
                str = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(str.nextToken());
                int b = Integer.parseInt(str.nextToken());
            }

            System.out.println(N - 1);
        }
    }
}
