class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int carpet = brown + yellow;
        
        int row = 0;
        int col = 0;
        
        for(int i = 1; i <= carpet; i++){
            row = i;
            col = carpet / row;
            
            if(row > col){
                continue;
            }
            
            if((row - 2) * (col - 2) == yellow){
                answer[0] = col;
                answer[1] = row;
                return answer;
            }
        }
        return answer;
    }
}