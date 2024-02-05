class Solution {
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        int count = 0;
        int[][] direc = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        
        for(int[] d : direc){
            int h_check = h + d[0];
            int w_check = w + d[1];
            
            if(h_check >= 0 && h_check < n && w_check >= 0 && w_check < n){
                if(board[h][w].equals(board[h_check][w_check])){
                    count++;
                }
            }
        }
        return count;
    }
}