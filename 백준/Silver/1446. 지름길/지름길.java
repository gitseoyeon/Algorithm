import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class ShortRoad {
        int end;
        int dis;
        ShortRoad(int end, int dis) {
            this.end = end;
            this.dis = dis;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int D = Integer.parseInt(str.nextToken());

        List<List<ShortRoad>> list = new ArrayList<>();
        for (int i = 0; i <= D; i++) {
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(str.nextToken());
            int end = Integer.parseInt(str.nextToken());
            int dis = Integer.parseInt(str.nextToken());

            if(end <= D && dis < end - start) {
                list.get(start).add(new ShortRoad(end, dis));
            }
        }

        int[] dp = new int[D + 1];
        for(int i = 0; i <= D; i++) {
            dp[i] = i;
        }

        for(int i = 0; i < D; i++) {
            dp[i + 1] = Math.min(dp[i] + 1, dp[i + 1]);
            for(ShortRoad sr : list.get(i)){
                dp[sr.end] = Math.min(dp[sr.end], dp[i] + sr.dis);
            }
        }

        System.out.println(dp[D]);

    }    
}
