import java.util.*;

class Solution {
    public static HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        combination("", numbers);
        for(int i : set){
            if(isPrime(i)){
                answer++;
            }
        }
        return answer;
    }
    
    public static void combination(String s, String numbers){
        if(!s.equals("")){
            set.add(Integer.parseInt(s));
        }
        for(int i = 0; i < numbers.length(); i++){
            combination(s + numbers.charAt(i), 
              numbers.substring(0, i) + numbers.substring(i + 1));
        }
    }
    
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}