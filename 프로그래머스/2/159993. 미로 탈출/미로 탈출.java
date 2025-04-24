import java.util.*;

class Solution {
    static int cnt;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static String[][] miro;
    static int[] start;
    static int n, m;
    public int solution(String[] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length();
        miro = new String[n][m];
        start = new int[2];
        
        for(int i = 0; i < miro.length; i++){
            String[] map = maps[i].split("");
            for(int j = 0; j < map.length; j++){
                miro[i][j] = map[j];
                if(map[j].equals("S")){
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        cnt = 0;
        moveToLever();
        
        if(cnt == 0) return -1;
        answer = cnt;
        moveToExit();
        return answer == cnt ? -1 : cnt;
    }
    
    public static void moveToLever(){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        int[][] dis = new int[n][m];
        
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int x = arr[0];
            int y = arr[1];
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if(nx < n && nx >= 0 && ny < m && ny >= 0){
                    if(!visited[nx][ny] && !miro[nx][ny].equals("X")){
                        if(miro[nx][ny].equals("L")){
                            cnt += dis[x][y] + 1;
                            start = new int[]{nx, ny};
                            return;
                        }
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        dis[nx][ny] = dis[x][y] + 1;
                    }
                }
            }
        } 
    }
    
    public static void moveToExit(){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        int[][] dis = new int[n][m];
        
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int x = arr[0];
            int y = arr[1];
            
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if(nx < n && nx >= 0 && ny < m && ny >= 0){
                    if(!visited[nx][ny] && !miro[nx][ny].equals("X")){
                        if(miro[nx][ny].equals("E")){
                            cnt += dis[x][y] + 1;
                            return;
                        }
                        dis[nx][ny] = dis[x][y] + 1;
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
                
            }
        }
    }
}