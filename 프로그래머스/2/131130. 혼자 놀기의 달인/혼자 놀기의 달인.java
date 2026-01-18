import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] isOpen = new boolean[cards.length];
        List<Integer> groupSize = new ArrayList<>();
        
        for(int i = 0; i < cards.length; i++) {
            if(!isOpen[i]) {
                int cnt = 0;
                int idx = i;
                while(!isOpen[idx]) {
                    isOpen[idx] = true;
                    cnt += 1;
                    idx = cards[idx] - 1;
                }
                groupSize.add(cnt);
            }
        }
        
        if(groupSize.size() < 2) {
            return 0;
        }
        
        groupSize.sort(Collections.reverseOrder());
        answer = groupSize.get(0) * groupSize.get(1);
        return answer;
    }
}