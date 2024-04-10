import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < 2; i++){
            for(int n : elements){
                list.add(n);
            }   
        }
        
        for (int i = 0; i < elements.length; i++) {
            int sum = 0;
            for (int k = i; k < i + elements.length; k++) {
                sum += list.get(k);
                set.add(sum);
            }
        }
    
        return set.size();
    }
}