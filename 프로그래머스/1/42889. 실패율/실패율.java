import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] probability = new double[N];
        
        int len = stages.length;
        
        for(int i = 1; i <= N; i++){
            int nPlayers = 0;
            for(int j = 0; j < stages.length; j++){
                if(stages[j] == i){
                    nPlayers++;
                }
            }
            if(len == 0) {
                probability[i - 1] = 0.0;
            } else {
                probability[i - 1] = (double) nPlayers / len;
            }
            len -= nPlayers;
        }
        
        for(int i = 0; i < N; i++) {
            int idx = 0;
            double max = -1.0;
            for(int j = 0; j < N; j++){
                if(max < probability[j]){
                    max = probability[j];
                    idx = j + 1;
                }
            }
            probability[idx - 1] = -1.0;
            answer[i] = idx;
        }        
        return answer;
    }
}
