import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuffer sb = new StringBuffer(Integer.toString(n, 3));
        String reverse = sb.reverse().toString();
        
        answer = Integer.parseInt(reverse, 3);
        
        
        return answer;
    }
}