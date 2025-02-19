import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i : scoville){
            queue.add(i);
        }
        
        for(int i = 0; i < scoville.length; i++){
            if(queue.peek() >= K) return answer;
            
            if(queue.size() >= 2){
                int f1 = queue.poll();
                int f2 = queue.poll() * 2;

                queue.add(f1 + f2);
                answer++;
            }
            
        }
        
        answer = -1;
        return answer;
    }
}