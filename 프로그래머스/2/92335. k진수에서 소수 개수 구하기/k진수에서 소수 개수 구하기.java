import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String kJinsu = Integer.toString(n, k);
        
        String[] arr = kJinsu.split("0");
        
        for(String s : arr){
            if(s.equals("")){
                continue;
            }
            
            long number = Long.parseLong(s);
            
            if(isPrime(number)){
                answer++;
            }
        }
        
        return answer;
    }
    
    private static boolean isPrime(long number){
        if(number <= 1){
            return false;
        }
        
        for(int i = 2; i <= (int)Math.sqrt(number); i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}