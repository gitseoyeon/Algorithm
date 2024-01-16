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
        int M = Integer.parseInt(str.nextToken());
        int[] pack = new int[M]; // 패키지 가격 배열
        int[] item = new int[M]; // 개수 가격 배열
        
        for(int i = 0; i < M; i++){
            str = new StringTokenizer(br.readLine());
            pack[i] = Integer.parseInt(str.nextToken());
            item[i] = Integer.parseInt(str.nextToken());
        }
        
        int minPa = Arrays.stream(pack).min().getAsInt();
        int minIt = Arrays.stream(item).min().getAsInt();
        
        if(N >= 6){
            int[] money = new int[3];
            int pa = N / 6; // 필요한 패키지 개수
            int it = N % 6; // 필요한 개별 개수
            money[0] = pa * minPa + it * minIt;
            money[1] = Math.min(minPa * (pa + 1), minIt * N);
            Arrays.sort(money);
            System.out.println(money[1]);
        }else{
            int money = 0;
            money = Math.min(minPa, minIt * N);
            System.out.println(money);
        }

    }
    
}
