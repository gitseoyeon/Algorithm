import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int choice = nums.length / 2;
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        
        if(choice <= list.size()){
            return answer = choice;
        }else{
            return answer = list.size();
        }
    }
}