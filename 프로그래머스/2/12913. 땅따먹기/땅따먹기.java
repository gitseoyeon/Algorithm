import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        for(int i = 0; i < land.length - 1; i++){
            land[i + 1][0] += Math.max(Math.max(land[i][1], land[i][2]), land[i][3]);
            land[i + 1][1] += Math.max(Math.max(land[i][0], land[i][2]), land[i][3]);
            land[i + 1][2] += Math.max(Math.max(land[i][0], land[i][1]), land[i][3]);
            land[i + 1][3] += Math.max(Math.max(land[i][0], land[i][1]), land[i][2]);
        }
        
        answer = Arrays.stream(land[land.length - 1]).max().getAsInt();

        return answer;
    }
}