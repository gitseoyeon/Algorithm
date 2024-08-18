import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int cnt = 1;

        for(int i = 0; i < N; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(str.nextToken());
            arr[i][1] = Integer.parseInt(str.nextToken());
        }
        
        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]; 
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(arr[0][1]);

        for(int i = 1; i < arr.length; i++){
            if(queue.peek() <= arr[i][0]){
                queue.poll();
            }
            queue.add(arr[i][1]);
        }
        System.out.println(queue.size());
    }
}
