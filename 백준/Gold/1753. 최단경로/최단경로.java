import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static List<ArrayList<int[]>> list;
    static int[] dis;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(str.nextToken());
        int E = Integer.parseInt(str.nextToken());
        int start = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        dis = new int[V + 1];

        for(int i = 0; i <= V; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            int c = Integer.parseInt(str.nextToken());

            int[] tmp = {b, c};
            list.get(a).add(tmp);
        }
        Arrays.fill(dis, 200000);
        getShortDis(start);

        for(int i = 1; i <= V; i++){
            System.out.println(dis[i] == 200000 ? "INF" : dis[i]);
        }
    }

    public static void getShortDis(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        dis[start] = 0;
        pq.offer(new int[]{start, 0});

        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            int node = tmp[0];
            int distance = tmp[1];

            if(distance > dis[node]) continue;

            for(int[] arr : list.get(node)){
                int nextNode = arr[0];
                int nextDis = arr[1];
                if(dis[nextNode] > dis[node] + nextDis){
                    dis[nextNode] = dis[node] + nextDis;
                    pq.offer(new int[]{nextNode, dis[nextNode]});
                }
            }
            
        }
    }
}
