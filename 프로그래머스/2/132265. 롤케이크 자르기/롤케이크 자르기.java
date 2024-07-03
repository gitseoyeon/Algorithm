class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int[] chul = new int[10000000];
        int[] dong = new int[10000000];
        
        int cTopping = 0;
        int dTopping = 0;
        
        for(int t : topping){
            if(chul[t - 1] == 0){
                cTopping++;
            }
            
            chul[t - 1]++;    
        }
        
        for(int t : topping){
            chul[t - 1]--;
            dong[t - 1]++;
            
            if(chul[t - 1] == 0){
                cTopping--;
            }
            if(dong[t - 1] == 1){
                dTopping++;
            }
            
            
            if(cTopping == dTopping){
                answer++;
            }
            
            if(cTopping < dTopping){
                break;
            }
        }
        return answer;
    }
}