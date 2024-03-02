import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer str = new StringTokenizer(s);
        List<Integer> list = new ArrayList<>();
        
        while(str.hasMoreTokens()){
            list.add(Integer.parseInt(str.nextToken()));
        }
        
        String max = Integer.toString(Collections.max(list));
        String min = Integer.toString(Collections.min(list));
        
        answer = min + " " + max;
        return answer;
    }
}