import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int k;
    public static int[] lotto;
    public static boolean[] check;
    public static int[] tmp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            StringTokenizer str = new StringTokenizer(br.readLine());
            k = Integer.parseInt(str.nextToken()); // 입력 받는 수 개수
            tmp = new int[6];

            if(k == 0) break;

            lotto = new int[k];
            check = new boolean[k];

            for(int i = 0; i < lotto.length; i++){
                lotto[i] = Integer.parseInt(str.nextToken());
            }
            
            dfs(0, 0);
            System.out.println();
        }
    }

    public static void dfs(int n, int l){
        if(l == 6){
            for(int i = 0; i < 6; i++){
                System.out.print(tmp[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = n; i < k; i++){
            if(check[i] == false){
                check[i] = true;
                tmp[l] = lotto[i];
                dfs(i + 1, l + 1);
                check[i] = false;
            }
        }
    }

}
