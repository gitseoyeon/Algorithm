import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        answer = bfs(maps);
        return answer;
    }
    
    private int bfs(int[][] maps){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 1});
        boolean[][] check = new boolean[maps.length][maps[0].length];
        check[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            int d = tmp[2];
            
            if(x == maps.length - 1 && y == maps[0].length - 1){
                return d;
            }
            
            if(x - 1 >= 0 && maps[x - 1][y] == 1 && !check[x - 1][y]){
                queue.add(new int[] {x - 1, y, d + 1});
                check[x - 1][y] = true;
            }
            
            if (x + 1 < maps.length && maps[x + 1][y] == 1 && !check[x + 1][y]) {
                queue.add(new int[] {x + 1, y, d + 1});
                check[x + 1][y] = true;
            }
            
            if (y - 1 >= 0 && maps[x][y - 1] == 1 && !check[x][y - 1]) {
                queue.add(new int[] {x, y - 1, d + 1});
                check[x][y - 1] = true;
            }

            if (y + 1 < maps[0].length && maps[x][y + 1] == 1 && !check[x][y + 1]) {
                queue.add(new int[] {x, y + 1, d + 1});
                check[x][y + 1] = true;
            }
        }
        
        return -1;
    }
}