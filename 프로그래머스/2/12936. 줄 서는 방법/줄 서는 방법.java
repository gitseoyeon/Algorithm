import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        int num = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        
        k -= 1;
        for(int i = 0; i < n; i++){
            long tmp = fac(n - 1 - i);
            int idx = (int)(k / tmp);
            answer[i] = list.get(idx);
            list.remove(idx);
            k %= tmp;
        }
        return answer;
    }
    
    public static long fac(int n){
        if(n <= 1){
            return 1;
        }
        return (long) n * fac(n - 1);
    }
}