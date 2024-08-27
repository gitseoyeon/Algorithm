class Solution {
    static int[] answer;
  
    public int[] solution(int[][] arr) {
        answer = new int[2];
        divide(0, 0, arr.length, arr);
        return answer;

    }
    public static void divide(int startX, int startY, int l, int[][] arr){
         if(check(startX, startY, l, arr)){
            if(arr[startX][startY] == 0){
                answer[0]++;
            }else{
                answer[1]++;
            }
             return;
        }
        
        divide(startX, startY, l/2, arr);
        divide(startX, startY + l/2, l/2, arr);
        divide(startX + l/2, startY, l/2, arr);
        divide(startX + l/2, startY + l/2, l/2 , arr);
    }
    public static boolean check(int startX, int startY, int l, int[][] arr){
        int n = arr[startX][startY];
        for(int i = startX; i < startX + l; i++){
            for(int j = startY; j < startY + l; j++){
                if(arr[i][j] != n)
                    return false;
            }
        }
        
        return true;
    }
    
}