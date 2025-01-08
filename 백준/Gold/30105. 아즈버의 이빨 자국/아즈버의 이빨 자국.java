import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer str = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();

        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(str.nextToken());
            arr[i] = n;
            hs.add(n);
        }

        for(int k = 1; k <= arr.length / 2; k++){
            int n = arr[k] - arr[0];
            boolean check = true;
            for(int i : arr){
                if(!hs.contains(i - n) && !hs.contains(i + n)){
                    check = false;
                    break;
                }
            }
            if(check) {
                list.add(n);
            }
        }

        Collections.sort(list);
        if(list.isEmpty()){
            System.out.println(0);
        }else{
            for(int i : list){
                sb.append(i).append(" ");
            }
            System.out.println(list.size());
            System.out.println(sb);
        }
    }

}
