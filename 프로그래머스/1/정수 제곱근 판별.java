import java.lang.Math.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        double x = Math.sqrt(n);
        if(x % 1 == 0.0){
            answer = new Double(Math.pow(x + 1, 2)).longValue();
        }else{
            answer = -1;
        }
        return answer;
    }
}