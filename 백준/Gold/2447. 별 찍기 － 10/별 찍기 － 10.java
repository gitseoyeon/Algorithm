import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        recurse(N, 0, 0, false);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void recurse(int N, int x, int y, boolean isBlank){
        if(isBlank){
            for(int i = x; i < x + N; i++){
                for(int j = y; j < y + N; j++){
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if(N == 1){
            arr[x][y] = '*';
            return;
        }

        int size = N / 3;
        int count = 0;
        for(int i = x; i < x + N; i += size){
            for(int j = y; j < y + N; j += size){
                count++;
                if(count == 5){
                    recurse(size, i, j, true);
                }else{
                    recurse(size, i, j, false);
                }
            }
        }
    }
}
