class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        Boolean[] wall = new Boolean[n + 1];
        
        for(int i = 0; i <= n; i++){
            wall[i] = true;
        }
        
        for(int i : section){
            wall[i] = false;
        }
        
        for(int i = 1; i < n - m + 2; i++){
            if(wall[i] == false){
                for(int j = i; j < i + m; j++){
                    wall[j] = true;
                }
                answer++;
            }
        }
        
        for(int i = n - m + 2; i <= n; i++){
            if(wall[i] == false){
                answer++;
                break;
            }
        }
        
        return answer;
    }
}