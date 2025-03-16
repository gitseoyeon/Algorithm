import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static char[][][] arr;
    static int[][][] dis;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(str.nextToken());
            int R = Integer.parseInt(str.nextToken());
            int C = Integer.parseInt(str.nextToken());
            
            int startX = 0;
            int startY = 0;
            int startZ = 0;
            int endX = 0;
            int endY = 0;
            int endZ = 0;

            arr = new char[L][R][C];
            dis = new int[L][R][C];

            if(L == 0 && R == 0 && C == 0) break;

            for(int i = 0; i < L; i++){
                for(int j = 0; j < R; j++){
                    String s = br.readLine();
                    for(int k = 0; k < C; k++){
                        if(s.charAt(k) == 'S'){
                            startX = j;
                            startY = k;
                            startZ = i;
                        }else if(s.charAt(k) == 'E'){
                            endX = j;
                            endY = k;
                            endZ = i;
                        }
                        arr[i][j][k] = s.charAt(k);
                    }
                }
                br.readLine();
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{startZ, startX, startY});

            while(!queue.isEmpty()){
                int[] dir = queue.poll();
                int z = dir[0];
                int x = dir[1];
                int y = dir[2];

                for(int i = 0; i < 6; i++){
                    int nx = dx[i] + x;
                    int ny = dy[i] + y;
                    int nz = dz[i] + z;

                    if(nx >= 0 && nx < R && ny >= 0 && ny < C && nz >= 0 && nz < L){
                        if(dis[nz][nx][ny] == 0 && arr[nz][nx][ny] != '#'){
                            dis[nz][nx][ny] = dis[z][x][y] + 1;
                            queue.offer(new int[]{nz, nx, ny});
                        }
                    }
                }
            }
            int cnt = dis[endZ][endX][endY];
            if(cnt == 0){
                System.out.println("Trapped!");
            }else{
                System.out.println("Escaped in " + cnt +  " minute(s).");
            }
        }
        
    }
}
