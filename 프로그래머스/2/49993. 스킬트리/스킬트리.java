import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        
        for(String s : skill_trees){
            String[] st = s.split("");
            String first = skill.substring(0, 1);
            String rest = skill.substring(1);
            
            for(int i = 0; i < st.length; i++){
                if(rest.contains(st[i])){
                    answer--;
                    break;
                }
                
                if(st[i].equals(first)){
                    if(rest.length() > 1){
                        first = rest.substring(0, 1);
                        rest = rest.substring(1);
                    }else{
                        first = rest;
                        rest = "";
                    }
                }
            }
        }
        
        return answer;
    }
}