import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] str = s.split(" ");
        
        for(int i = 0; i < str.length; i++){
            if(str[i].length() == 0){
                answer += " ";
            }else{
                String f = str[i].substring(0, 1).toUpperCase();
                String na = str[i].substring(1).toLowerCase();
                answer += f + na + " ";
            }
        }

        char lastString = s.charAt(s.length() - 1);
        if(lastString == ' '){
            return answer;
        }
        return answer.substring(0, answer.length() - 1);
    }
}