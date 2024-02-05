import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;

        while(true){
            str = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(str.nextToken());
            int C = Integer.parseInt(str.nextToken());
            if(R == 0 && C == 0){
                System.exit(0);
            }
            String[][] map = new String[R][C];
    
            for(int i = 0; i < R; i++){
                String s = br.readLine();
                for(int j = 0; j < C; j++){
                    map[i][j] = String.valueOf(s.charAt(j));
                }
            }
    
            
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                   if(map[i][j].equals(".")){
                        int cnt = 0;
                        for (int dx = -1; dx <= 1; dx++) {
                            for (int dy = -1; dy <= 1; dy++) {
                                int ni = i + dx;
                                int nj = j + dy;
                                if (ni >= 0 && ni < R && nj >= 0 && nj < C && map[ni][nj].equals("*")) {
                                    cnt++;
                                }
                            }
                        }
                        map[i][j] = Integer.toString(cnt);
                   } 
                }
            }
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
}
