import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        new_id = new_id.toLowerCase();
        
        new_id = new_id.replaceAll("[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9-_.]", "");
        
        while(new_id.indexOf("..") != -1){
            new_id = new_id.replace("..", ".");
        }
        
        if(new_id.charAt(0) == '.'){
            new_id = new_id.substring(1);
        }else if(new_id.charAt(new_id.length() - 1) == '.'){
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        
        if(new_id.isEmpty()){
            new_id = "a";
        }
        
        if(new_id.length() >= 16){
            new_id = new_id.substring(0, 15);
        }
        
        if(new_id.charAt(new_id.length() - 1) == '.'){
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        
        if(new_id.length() <= 2){
            while(new_id.length() < 3){
                new_id += new_id.charAt(new_id.length() - 1);
            }
        }
        
        answer = new_id;
        return answer;
    }
}