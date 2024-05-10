import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for(int i = 0; i < discount.length; i++) {
            Map<String, Integer> hm = new HashMap<>();
            int cnt = 0;
            
            for(int j = i; j < discount.length; j++) {
                if(cnt == 10) {
                    break;
                }
                hm.put(discount[j], hm.getOrDefault(discount[j], 0) + 1);
                cnt++;
            }

            boolean check = false;
            for(int j = 0; j < want.length; j++) {
            if(hm.get(want[j]) == null) {
                check = true;
                break;
                }
            if(number[j] > hm.get(want[j])) {
                    check = true;
                    break;
                }
            }
        
            if(!check) {
                answer++;
            }
            
        }
        return answer;
    }
}