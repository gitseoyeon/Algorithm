import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> newMap = new HashMap<>();
        
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("N", 0);
        map.put("A", 0);
        
        String key = "";
        
        
        for(int i = 0; i < survey.length; i++){
            switch(choices[i]){
                case 1:
                    key = survey[i].substring(0, 1);
                    map.put(key, map.get(key) + 3);
                    break;
                case 2:
                    key = survey[i].substring(0, 1);
                    map.put(key, map.get(key) + 2);
                    break;
                case 3:
                    key = survey[i].substring(0, 1);
                    map.put(key, map.get(key) + 1);
                    break;
                case 5:
                    key = survey[i].substring(survey[i].length() - 1);
                    map.put(key, map.get(key) + 1);
                    break;
                case 6:
                    key = survey[i].substring(survey[i].length() - 1);
                    map.put(key, map.get(key) + 2);
                    break;
                case 7:
                    key = survey[i].substring(survey[i].length() - 1);
                    map.put(key, map.get(key) + 3);
                    break;
            }
        }
        
        String[] type = {"RT", "FC", "MJ", "AN"};
        
        for(String s : type){
            String f = s.substring(0, 1);
            String l = s.substring(s.length() - 1);
            
            if(map.get(f) > map.get(l)){
                answer += f;
            }else if(map.get(f) < map.get(l)){
                answer += l;
            }else{
                answer += (f.compareTo(l) < 0) ? f : l;
            }
        }

        return answer;
    }
}
