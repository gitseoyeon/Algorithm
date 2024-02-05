import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        List<Integer> sumList = new ArrayList<>();
        
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                for(int k = j + 1; k < nums.length; k++){
                    sumList.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }
         
        
        for(int i = 0; i < sumList.size(); i++){
            int cnt = 0;
            int num = sumList.get(i);
            for(int j = 2; j < num; j++){
                if(sumList.get(i) % j == 0){
                    cnt++;  
                }   
            }
            if(cnt == 0){
                answer += 1;
            }
        }
        return answer;
    }
}