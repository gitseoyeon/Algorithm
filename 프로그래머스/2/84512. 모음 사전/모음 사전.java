import java.util.*;

class Solution {
    static String[] words;
    static ArrayList<String> list;
    public int solution(String word) {
        int answer = 0;
        words = new String[]{"A", "E", "I", "O", "U"};
        list = new ArrayList<>();
        
        dfs(word, "", 0);
        
        for(String w : list){
            if(w.equals(word)) break;
            answer++;
        }
        
        return answer;
    }
    public static void dfs(String word, String str, int depth) {
        list.add(str);
        if(depth == 5){
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            dfs(word, str + words[i], depth + 1);
        }
    }
}