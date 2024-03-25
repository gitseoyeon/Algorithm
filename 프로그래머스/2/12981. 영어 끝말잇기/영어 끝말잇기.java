import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> list  = new ArrayList<>();
        
        for(int i = 0; i < words.length; i++){
            int num = i % n + 1;
            int turn = i / n + 1;
            
            if(list.contains(words[i])){
                answer[0] = num;
                answer[1] = turn;
                break;
            }
            list.add(words[i]);   
            
            if(i > 0 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)){
                answer[0] = num;
                answer[1] = turn;
                break;
            }
        }
        return answer;
    }
}