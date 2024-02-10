import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> ingre = new Stack<>();
        
        for(int i = 0; i< ingredient.length; i++){
            ingre.push(ingredient[i]);
            if(ingre.size() >= 4){
                if(ingre.get(ingre.size() - 1) == 1 && ingre.get(ingre.size() - 2) == 3 && ingre.get(ingre.size() - 3) == 2 && ingre.get(ingre.size() - 4) == 1){
                    answer++;
                    ingre.pop();
                    ingre.pop();
                    ingre.pop();
                    ingre.pop();
                }
            }
        }
        return answer;
    }
}