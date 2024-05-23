class Solution {
    public boolean[] check;
    public int answer = 0;
    
    public int solution(int k, int[][] dungeons) { 
        check = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }
    
    public void dfs(int level, int k, int[][] dungeons){
        if(level > answer){
            answer = level;
        }
        
        for(int i = 0; i < dungeons.length; i++){
            if(!check[i] && dungeons[i][0] <= k){
                check[i] = true;
                dfs(level + 1, k - dungeons[i][1], dungeons);
                check[i] = false;
            }
        }
    }
}