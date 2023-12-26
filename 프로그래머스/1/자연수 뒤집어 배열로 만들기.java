import java.util.*;

class Solution {
    public int[] solution(long n) {
        
        String sArray = Long.toString(n);
        int[] arrNum = new int[sArray.length()];
        int[] answer = new int[sArray.length()];
        int len = arrNum.length - 1;
        
        
        for(int i = 0; i < sArray.length(); i++){
            arrNum[i] = sArray.charAt(i) - '0';
        }
        
        while(len != -1){
            for(int i = 0; i < arrNum.length; i++){
                answer[i] =  arrNum[len];
                len--;
            }
        }
        
        
        return answer;
    }
}