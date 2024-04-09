import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        
        for(int n : tangerine){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        for(int key : map.keySet()){
            list.add(map.get(key));
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        for(int i = 0; i < list.size(); i++){
            if(k <= 0){
                System.out.println(answer);
                break;
            }
            
            k-=list.get(i);
            answer++;
        }
        
        
        return answer;
    }
}