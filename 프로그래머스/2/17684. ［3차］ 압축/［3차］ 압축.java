import java.util.*;

class Solution {
    public static int idx;
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        String[] str = msg.split("");
        
        HashMap<String, Integer> hm = getDefaultHash();
        String tmp = "";
        
        for (int i = 0; i < str.length; i++) {
            tmp += str[i];
            String next = "";
            if (i + 1 < str.length) {
                next = tmp + str[i + 1];
            }

            if (!hm.containsKey(next)) {
                answer.add(hm.get(tmp));
                if (next != null) {
                    hm.put(next, idx++);
                }
                tmp = "";
            }
        }
        
        if (!tmp.isEmpty()) {
            answer.add(hm.get(tmp));
        }
                
        return answer;
    }
    
    private HashMap<String, Integer> getDefaultHash() {
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (char c = 'A'; c <= 'Z'; c++) {
            hm.put(String.valueOf(c), (int)c - 64);
        }
        
        idx = 27;
        
        return hm;
    }
}
