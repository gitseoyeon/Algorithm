import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int[] wan = scores[0];
        scores = sort(scores);
        List<int[]> list = setInsentive(scores);
        answer = getRank(list, wan);
        return answer;
    }
    
    private static int[][] sort(int[][] scores) {
        Arrays.sort(scores, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
        
        return scores;
    }
    
    private static List<int[]> setInsentive(int[][] scores) {
        List<int[]> insentive = new ArrayList<>();
        int max = 0;
        for(int i = 0 ; i < scores.length; i++) {
            int idx = getIdx(scores, i);
            for(int k = i; k < idx; k++) {
                if(scores[k][1] < max) continue;
                insentive.add(scores[k]);
            }
            max = Math.max(max, scores[idx - 1][1]);
            
            i = idx - 1;
        }
        return insentive;
    }
    
    private static int getIdx(int[][] scores, int idx) {
        int j = idx;
        while(j < scores.length && scores[idx][0] == scores[j][0]) {
            j++;
        }
        return j;
    }
    
    private static int getRank(List<int[]> list, int[] wan) {
        if(!list.contains(wan)) return -1;
        int rank = 1;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i)[0] + list.get(i)[1] > wan[0] + wan[1]) rank++;
        }
        
        return rank;
    }
}