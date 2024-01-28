import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int notLost = n - lost.length;
        int borrow = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
         for(int i = 0; i < lost.length; i++){
             for(int j = 0; j < reserve.length; j++){
                 if(lost[i] == reserve[j]){
                    borrow++;
                    reserve[j] = -100;
                    lost[i] = -200;
                    break;
                }
             }
         }
        
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]){
                    borrow++;
                    reserve[j] = 0;
                    break;
                }
            }
        }
        
        answer = borrow + notLost;
        return answer;
    }
}