import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        int J = Integer.parseInt(br.readLine());
        int cnt = 0;
        int l = 1;

        for(int i = 0; i < J; i++){
            int apple = Integer.parseInt(br.readLine());
            int r = l + M - 1;
            if(r < apple){
                cnt += apple - r;
                l = apple - M + 1;
            }else if(l > apple){
                cnt += l - apple;
                l = apple;
            }
        }
        System.out.println(cnt);
    }
}
