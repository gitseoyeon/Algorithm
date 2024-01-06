import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        
        if(score.length % m == 0){
            for(int i = 0; i < score.length / m; i++){
                answer += score[i * m] * m;
            }
        }else{
            for (int i = score.length % m; i < score.length; i += m) {
                answer += score[i] * m;
            }

        }
        return answer;
    }
}