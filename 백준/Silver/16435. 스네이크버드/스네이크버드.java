import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int L = Integer.parseInt(str.nextToken());
        int[] fruit = new int[N];

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            fruit[i] = Integer.parseInt(str.nextToken());
        }
        Arrays.sort(fruit);

        for(int i = 0; i < fruit.length; i++){
            if(L < fruit[i]){
                break;
            }

            L++;
        }

        System.out.println(L);
    }
}
