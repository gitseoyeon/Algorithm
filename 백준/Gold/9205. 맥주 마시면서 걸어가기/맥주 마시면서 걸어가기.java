import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            int[] home = new int[2];
            int[][] conv = new int[n][2];
            int[] festival = new int[2];
            boolean[] visited = new boolean[n];

            StringTokenizer str = new StringTokenizer(br.readLine());
            home[0] = Integer.parseInt(str.nextToken());
            home[1] = Integer.parseInt(str.nextToken());

            for(int j = 0; j < n; j++){
                str = new StringTokenizer(br.readLine());
                conv[j][0] = Integer.parseInt(str.nextToken());
                conv[j][1] = Integer.parseInt(str.nextToken());
            }

            str = new StringTokenizer(br.readLine());
            festival[0] = Integer.parseInt(str.nextToken());
            festival[1] = Integer.parseInt(str.nextToken());

            if(bfs(home, n, conv, festival, visited)){
                System.out.println("happy");
            }else{
                System.out.println("sad");
            }
            
        }
    }
    
    public static boolean bfs(int[] home, int n, int[][] conv, int[] festival, boolean[] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(home);

        while(!queue.isEmpty()){
            int[] local = queue.poll();

            if(Math.abs(festival[0] - local[0]) + Math.abs(festival[1] - local[1]) <= 1000){
                return true;
            }
            for(int i = 0; i < n; i++){
                if(!visited[i] && Math.abs(conv[i][0] - local[0]) + Math.abs(conv[i][1] - local[1]) <= 1000){
                    queue.add(new int[]{conv[i][0], conv[i][1]});
                    visited[i] = true;
                }
            }
        }

        return false;
    }
}
