import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        int[] dis = new int[n + 1];
        Arrays.fill(dis, -1);
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(destination);
        dis[destination] = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i : graph.get(cur)) {
                if(dis[i] == -1) {
                    dis[i] = dis[cur] + 1;
                    q.offer(i);
                }
            }
        }
        
        for(int i = 0; i < sources.length; i++) {
            answer[i] = dis[sources[i]];
        }
        
        return answer;
    }

}