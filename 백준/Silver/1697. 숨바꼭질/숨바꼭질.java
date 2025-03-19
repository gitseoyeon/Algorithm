import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int K = Integer.parseInt(str.nextToken());
        boolean[] visited = new boolean[100001];

        if (N == K) {
            System.out.println(0);
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = true;
        int depth = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int num = queue.poll();
                int[] arr= {num * 2, num + 1, num - 1};
                for(int j = 0; j < 3; j++){
                    if(arr[j] == K){
                        System.out.println(depth + 1);
                        return;
                    }

                    if(arr[j] >= 0 && arr[j] <= 100000 && !visited[arr[j]]){
                        visited[arr[j]] = true;
                        queue.add(arr[j]);
                    }
                }
            }
            depth++;
        }
    }
}
