import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        
        for(int i : scoville){
            pqueue.add(i);
        }
        
        while(true){
            if(pqueue.size() < 2){
                break;
            }
            if(pqueue.peek() < K){
                int first = pqueue.poll();
                int second = pqueue.poll();
                int mix = first + (second * 2);
                pqueue.add(mix);
                answer++;
            }else{
                break;
            }
        }
        
        if(pqueue.peek() < K){
            return -1;
        }

        return answer;
    }
}