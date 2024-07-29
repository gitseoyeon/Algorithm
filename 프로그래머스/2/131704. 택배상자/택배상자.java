import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> bojo = new Stack<>();
        int idx = 0;
        
        for(int i = 0; i < order.length; i++){
            bojo.push(i + 1);
            while(!bojo.isEmpty()){
                if(bojo.peek() == order[idx]){
                    bojo.pop();
                    idx++;
                    answer++;
                }else{
                    break;
                }
            }
        }
        return answer;
    }
}