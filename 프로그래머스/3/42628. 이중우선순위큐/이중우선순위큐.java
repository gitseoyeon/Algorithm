import java.util.*;
 
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxqueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minqueue = new PriorityQueue<>();
        
        for(int i = 0; i < operations.length; i++) {
            String[] str = operations[i].split(" ");
            String o = str[0];
            int num = Integer.valueOf(str[1]);
            
            if(o.equals("I")) {
                maxqueue.add(num);
                minqueue.add(num);
            }else{
                if(!maxqueue.isEmpty()) {
                    if(num == 1) {
                        int max = maxqueue.poll();
                        minqueue.remove(max);
                    } else {
                        int min = minqueue.poll();
                        maxqueue.remove(min);
                    }   
                }
            }
        }
        
        if(minqueue.size() == 0 || maxqueue.size() == 0) {
            return new int[]{0, 0};
        }else{
            return new int[]{maxqueue.peek(), minqueue.peek()};
        }
    }
}
