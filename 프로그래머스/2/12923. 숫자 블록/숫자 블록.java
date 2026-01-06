import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        int size = (int)(end - begin) + 1;
        int[] answer = new int[size];
        int idx = 0;
        for(int i = 0; i < size; i++) {
            long num = begin + i;
            answer[i] = (int) getBlock(num);
        }
        return answer;
    }
    
    private static long getBlock(long num) {
        if(num == 1) return 0;
        long max = 1;
        
        for(long i = 2; i <= num / i; i++) {
            if(num % i == 0) {
                long tmp = num / i;
                if(tmp <= 10000000) {
                    return tmp;
                } else {
                    max = Math.max(max, i);
                }
            }
        }
        return max;
    }
}