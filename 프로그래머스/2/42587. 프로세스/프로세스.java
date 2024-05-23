import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i : priorities){
            queue.add(i);
        }
        
        while(!queue.isEmpty()){
            for(int i = 0; i < priorities.length; i++){
                if(priorities[i] == queue.peek()){
                    if(location == i){
                        answer++;
                        return answer;
                    }else{
                        queue.poll();
                        answer++;
                    }
                }
            }
        }
        
        System.out.println(queue);
        
        return answer;
    }
}