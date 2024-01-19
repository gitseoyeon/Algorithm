import java.util.*;

class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        List<String> list = new ArrayList<>();
        int sum = 0;
        
        String str = Integer.toString(x);
        for(String s : str.split("")){
            list.add(s);
        }
        
        for(int i = 0; i < list.size(); i++){
            sum += Integer.parseInt(list.get(i));
        }
        
        if(x % sum == 0){
            return answer;
        }else{
            return answer = false;
        }
    }
}