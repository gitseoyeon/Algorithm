import java.util.*;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++){
            List<Integer> list = new ArrayList<Integer>();
            for(int j = 1; j <= i; j ++){
                if(i % j == 0){
                    list.add(j);
                }
            }
            if(list.size() % 2 == 0){
                answer += i;
            }else{
                answer -= i;
            }
        }
        return answer;
    }
}