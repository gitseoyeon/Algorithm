import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int[] line;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        line = new int[N];
        StringTokenizer str = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str.nextToken());
        }

        for(int i = 0; i < N; i++){
            int idx = arr[i];
            int chance = arr[i];
            while(true){
                if(line[idx] != 0){
                    while(line[idx] != 0){
                        idx += 1;
                    }
                }

                if(!checkHeight(chance, idx)){
                    idx += 1;
                }else{
                    break;
                }
                  
            }
            line[idx] = i + 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int l : line){
            sb.append(String.valueOf(l));
            sb.append(" ");
        }
        System.out.println(sb);
    }

    public static boolean checkHeight(int chance, int idx){
        int cnt = 0;
        for(int i = 0; i < idx; i++){
            if(line[i] == 0) cnt++;
        }

        return cnt == chance ? true : false;
    }
}
