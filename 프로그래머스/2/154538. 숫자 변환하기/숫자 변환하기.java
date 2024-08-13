import java.util.*;

class Solution {
    static boolean[] visit;
    static int answer = 1000000;
    public int solution(int x, int y, int n) {
        visit = new boolean[1000001];
        
        bfs(x, y, n);
        return answer;
    }
    
    public static void bfs(int x, int y, int n){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, 0});
        visit[x] = true;
        
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int num = tmp[0];
            int cnt = tmp[1];
            visit[num] = true;
            
            if(num == y){
                answer = Math.min(answer, cnt);
                break;
            }
            
            if(num + n <= y && !visit[num + n]){
                queue.add(new int[]{num + n, cnt + 1});
                visit[num + n] = true;
            }
            
            if(num * 2 <= y && !visit[num* 2]){
                queue.add(new int[]{num * 2, cnt + 1});
                visit[num * 2] = true;
            }
            
            if(num * 3 <= y && !visit[num * 3]){
                queue.add(new int[]{num * 3, cnt + 1});
                visit[num * 3] = true;
            }
        }
        
        if(answer == 1000000)
            answer = -1;
    }
}