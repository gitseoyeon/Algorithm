import java.util.*;

class Solution {
    static HashMap<String, ArrayList<Integer>> hm;
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        hm = new HashMap<>();
        
        for(String s : info) {
            String[] str = s.split(" ");
            combine("", 0, str);
        }
        
        for(ArrayList<Integer> list : hm.values()) {
            Collections.sort(list);
        }
        
        for(int i = 0; i < query.length; i++) {
            String[] q = query[i].split(" ");
            String key = q[0] + q[2] + q[4] + q[6];
            int score = Integer.parseInt(q[7]);
            ArrayList<Integer> list = hm.getOrDefault(key, new ArrayList<>());
            int idx = getIdx(list, score);
            
            
            answer[i] = list.size() - idx;
        }
        return answer;
    }
    
    private static void combine(String s, int len, String[] arr) {
        if(len == 4) {
            int score = Integer.parseInt(arr[4]);
            if(hm.containsKey(s)) {
                hm.get(s).add(score);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(score);
                hm.put(s, list);
            }
            return;
        }
        combine(s + "-", len + 1, arr);
        combine(s + arr[len], len + 1, arr);
    }
    
    private static int getIdx(ArrayList<Integer> list, int score) {
        int left = 0;
        int right = list.size();
        
        while(left < right) {
            int mid = (left + right) / 2;
            if(list.get(mid) < score) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}