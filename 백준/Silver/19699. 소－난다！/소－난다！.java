import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static int N, M;
    public static int[] cows;
    public static boolean[] check;
    public static List<Integer> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        cows = new int[N];
        check = new boolean[N];
        list = new ArrayList<>();

        str = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            cows[i] = Integer.parseInt(str.nextToken());
        }

        dfs(0, 0, 0);
        
        if(list.size() == 0){
            System.out.println(-1);
        }else{
            list = list.stream().distinct().collect(Collectors.toList());
            Collections.sort(list);
            for(int n : list){
                System.out.print(n+ " ");
            }
        }
    }

    public static void dfs(int depth, int sum, int start){
        if(depth == M){
            if(isPrime(sum)){
                list.add(sum);
            }
            return;
        }

        for(int i = start; i < N; i++){
            if(!check[i]){
                check[i] = true;
                dfs(depth + 1, sum + cows[i], i + 1);
                check[i] = false;
            }
        }

    }

    public static boolean isPrime(int num){
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
