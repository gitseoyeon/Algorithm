import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<List<Integer>> city = new ArrayList<>();
        
        for(int i = 0; i <= N; i++) {
            city.add(new ArrayList<>());
        }
        
        StringTokenizer str;
        for(int i = 1; i <= N; i++) {
            str = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                int n = Integer.parseInt(str.nextToken());
                if(n == 1) {
                    city.get(i).add(j);
                }
            }
        }

        int[] trip = new int[M];
        str = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            trip[i] = Integer.parseInt(str.nextToken());
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(trip[0]);
        visited[trip[0]] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int c : city.get(cur)) {
                if(!visited[c]) {
                    queue.offer(c);
                    visited[c] = true;
                }
            }
        }

        boolean check = true;
        for(int t : trip) {
            if(!visited[t]) {
                check = false;
                break;
            }
        }

        System.out.println(check ? "YES" : "NO");
    }
}