import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] room = new String[N][N];
        int rCnt = 0;
        int cCnt = 0;

        for(int i = 0; i < room.length; i++){
            String s = br.readLine();
            String[] str = s.split("");
            int idx = 0;

            for(String st : str){
                room[i][idx] = st;
                idx++;
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(j + 1 < N && room[i][j].equals(".") && room[i][j + 1].equals(".") && ((j + 2 == N) || room[i][j + 2].equals("X"))){
                    rCnt++;
                }

                if(i + 1 < N && room[i][j].equals(".") && room[i + 1][j].equals(".") && ((i + 2 == N) || room[i + 2][j].equals("X"))){
                    cCnt++;
                }
            }
        }

        System.out.println(rCnt + " " + cCnt);
    
    }
}
