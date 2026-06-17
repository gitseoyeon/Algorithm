import java.util.*;

class Solution {
    static List<List<Integer>> list;
    static boolean[] visited;
    static HashSet<HashSet<Integer>> hs;
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        list = new ArrayList<>();
        visited = new boolean[user_id.length];
        hs = new HashSet<>();
        
        for(String b : banned_id) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < user_id.length; i++) {
                if(isBad(user_id[i], b)) {
                    tmp.add(i);
                }
            }
            list.add(tmp);
        }
        
        dfs(0, banned_id.length);
        
        answer = hs.size();
        return answer;
    }
    
    private static boolean isBad(String user, String ban) {
        if(user.length() != ban.length()) return false;
        
        for(int i = 0; i < user.length(); i++) {
            if(ban.charAt(i) == '*') continue;
            if(user.charAt(i) != ban.charAt(i)) return false;
        }
        return true;
    }
    
    private void dfs(int current, int depth) {
        if(current == depth) {
            HashSet<Integer> tmp = new HashSet<>();
            for(int i = 0; i < visited.length; i++) {
                if(visited[i]) tmp.add(i);
            }
            hs.add(tmp);
            return;
        }
        
        for(int n : list.get(current)) {
            if(!visited[n]) {
                visited[n] = true;
                dfs(current + 1, depth);
                visited[n] = false;
            }
        }
    }
}