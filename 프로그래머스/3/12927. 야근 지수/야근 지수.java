import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int work : works) {
            pq.offer(work);
        }
        
        for(int i = 0; i < n; i++) {
            int work = pq.poll();
            work = work - 1 >= 0 ? work - 1 : 0;
            pq.offer(work);
        }
        
        while(!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }
        return answer;
    }
}