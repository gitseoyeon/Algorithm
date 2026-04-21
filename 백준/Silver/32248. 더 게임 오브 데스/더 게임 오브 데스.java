import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[] game, arr;
    static int N, idx, cur, start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        long T = Long.parseLong(str.nextToken());
        arr = new int[N + 1];
        str = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        game = new int[N + 1];

        idx = 0;
        cur = 1;

        setCycle();
        start = getStartIdx();
        

        int len = idx - start;
        if(T < idx) {
            System.out.println(game[(int)T]);
        } else {
            long remain = (T - start) % len;

            int answer = game[start];
            for(int i = 0; i < remain; i++) {
                answer = arr[answer];
            }
            System.out.println(answer);
        }
    }
    
    private static void setCycle() {
        visited = new boolean[N + 1];
        while (!visited[cur]) {
            visited[cur] = true;
            game[idx] = cur;
            idx++;
            cur = arr[cur];
        }
    }

    private static int getStartIdx() {
        for(int i = 0; i < idx; i++) {
            if(game[i] == cur) {
                start = i;
                break;
            }
        }
        return start;
    }
}
