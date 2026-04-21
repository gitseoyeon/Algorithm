import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        long T = Long.parseLong(str.nextToken());
        int[] arr = new int[N + 1];
        str = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        boolean[] visited = new boolean[N + 1];
        int[] game = new int[N + 1];

        int idx = 0;
        int cur = 1;

        while (!visited[cur]) {
            visited[cur] = true;
            game[idx] = cur;
            idx++;
            cur = arr[cur];
        }

        int start = 0;
        for(int i = 0; i < idx; i++) {
            if(game[i] == cur) {
                start = i;
                break;
            }
        }

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
}
