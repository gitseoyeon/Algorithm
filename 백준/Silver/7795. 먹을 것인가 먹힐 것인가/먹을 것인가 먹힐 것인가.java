import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            StringTokenizer str= new StringTokenizer(br.readLine());
            int N = Integer.parseInt(str.nextToken());
            int M = Integer.parseInt(str.nextToken());
            int cnt = 0;

            int[] arr1 = new int[N];
            int[] arr2 = new int[M];

            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr1[j] = Integer.parseInt(str.nextToken());
            }

            str = new StringTokenizer(br.readLine());
            for(int k = 0; k < M; k++){
                arr2[k] = Integer.parseInt(str.nextToken());
            }

            Arrays.sort(arr1);
            Arrays.sort(arr2);



            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(arr1[j] > arr2[k]){
                        cnt++;
                    }else{
                        break;
                    }
                }
            }

            System.out.println(cnt);
        }
        

    }
}
