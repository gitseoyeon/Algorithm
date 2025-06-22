import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < enemy.length; i++){
            if(enemy[i] <= n){
                n -= enemy[i];
                pq.offer(enemy[i]);
                answer += 1;
            }else {
                if(k > 0) {
                    if(!pq.isEmpty()){
                        if(pq.peek() > enemy[i]){
                            n += pq.poll();
                            n -= enemy[i];
                            pq.offer(enemy[i]);
                        }
                    }
                    k--;
                    answer += 1;
                }else{
                    break;
                }
            }
        }
        return answer;
    }
}