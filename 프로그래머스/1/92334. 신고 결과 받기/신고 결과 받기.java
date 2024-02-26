import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> map = new HashMap<>();
        Map<String, HashSet<String>> sin = new HashMap<>();
        
        
        for(int i=0;i<id_list.length;i++) {
            map.put(id_list[i], i); 
            sin.put(id_list[i], new HashSet<>()); 
        }
        for(String s : report) {
            String[] str = s.split(" ");
            String reporter = str[0];
            String singo = str[1];
            sin.get(singo).add(reporter);
        }
        for(int i=0; i<id_list.length; i++) {
            HashSet<String> hashset = sin.get(id_list[i]);
            if(hashset.size() >= k) {
                for(String name : hashset) {
                    answer[map.get(name)]++;
                }
            }
        }
        
        return answer;
    }
}