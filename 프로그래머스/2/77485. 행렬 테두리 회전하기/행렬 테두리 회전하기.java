import java.util.*;

class Solution {
    static int[][] arr;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        arr = new int[rows + 1][columns + 1];
        initArr(rows, columns);
        for(int i = 0; i < queries.length; i++){
            answer[i] = rotate(queries[i]);
        }
        return answer;
    }
    
    public static void initArr(int row, int columns){
        int num = 0;
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= columns; j++){
                num += 1;
                arr[i][j] = num;
            }
        }
    }
    
    public static int rotate(int[] query){
        int startY = query[0];
        int startX = query[1];
        int endY = query[2];
        int endX = query[3];

        int move = arr[startY][startX];
        int min = move;

        for(int i = startX + 1; i <= endX; i++){
            int tmp = arr[startY][i];
            arr[startY][i] = move;
            min = Math.min(min, move);
            move = tmp;
        }

        for(int i = startY + 1; i <= endY; i++){
            int tmp = arr[i][endX];
            arr[i][endX] = move;
            min = Math.min(min, move);
            move = tmp;
        }
        
        for(int i = endX - 1; i >= startX; i--){
            int tmp = arr[endY][i];
            arr[endY][i] = move;
            min = Math.min(min, move);
            move = tmp;
        }

        for(int i = endY - 1; i >= startY; i--){
            int tmp = arr[i][startX];
            arr[i][startX] = move;
            min = Math.min(min, move);
            move = tmp;
        }

        return min;
    }
}