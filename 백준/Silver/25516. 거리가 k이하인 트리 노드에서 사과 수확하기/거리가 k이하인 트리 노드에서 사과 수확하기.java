import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(str.nextToken());
        int k = Integer.parseInt(str.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++) {
            str = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(str.nextToken());
            int c = Integer.parseInt(str.nextToken());

            list.get(p).add(c);
            list.get(c).add(p);
        }

        int[] node = new int[n];
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            node[i] = Integer.parseInt(str.nextToken());
        }

        
        int depth = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        queue.offer(0);
        int apple = node[0];
        if (k == 0) {
            System.out.println(apple);
            return;
        }

        while(!queue.isEmpty() && depth < k) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                int cur = queue.poll();
                for(int c : list.get(cur)) {
                    if(!visited[c]) {
                        visited[c] = true;
                        apple += node[c];
                        queue.offer(c);
                    }
                }
            }
            depth += 1;
        }
        System.out.println(apple);
        
    }    
}
