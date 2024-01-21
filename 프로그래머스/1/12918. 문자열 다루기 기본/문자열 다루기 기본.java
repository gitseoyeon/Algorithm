import java.util.*;

class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        String[] str = s.split("");
        
        if(str.length == 4 || str.length == 6){
            for(int i = 0; i < str.length; i++){
                int n = str[i].charAt(0);
                if(n > 65){
                    answer = false;
                }
            }
        }else{
            answer = false;
        }
    
        return answer;
    }
}