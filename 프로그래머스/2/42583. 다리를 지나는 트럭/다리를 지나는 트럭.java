import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        int w = 0;
        int idx = 0;

        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        
        while (idx < truck_weights.length || w > 0) {
            answer++;
            w -= bridge.poll();

            if (idx < truck_weights.length && w + truck_weights[idx] <= weight) {
                bridge.add(truck_weights[idx]);
                w += truck_weights[idx];
                idx++;
            } else {
                bridge.add(0);
            }
        }
        
        return answer;
    }
}