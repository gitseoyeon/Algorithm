import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 10000;
        for(int i = 0; i < wires.length; i++){
            int[][] arr = getArr(n, wires, i);
            boolean[] visited = new boolean[n + 1];
            dfs(1, arr, visited);
            int cnt = getCnt(visited);
            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
        }
        
        return answer;
    }
    
    public static int[][] getArr(int n, int[][] wires, int i){
        int[][] arr = new int[n + 1][n + 1];
        for(int k = 0; k < wires.length; k++){
            if(k != i){
                int a = wires[k][0];
                int b = wires[k][1];
                arr[a][b] = 1;
                arr[b][a] = 1;
            }
        }
        return arr;
    }
    
    public static void dfs(int start, int [][] arr, boolean[] visited){
        visited[start] = true;
        for(int i = 1; i < arr.length; i++){
            if(!visited[i] && arr[start][i] == 1){
                dfs(i, arr, visited);
            }
        }
    }
    
    public static int getCnt(boolean[] visited){
        int cnt = 0;
        for(boolean b : visited){
            if(b) cnt++;
        }
        return cnt;
    }
}