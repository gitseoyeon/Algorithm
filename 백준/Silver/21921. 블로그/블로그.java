import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int X = Integer.parseInt(str.nextToken());

        str = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(str.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            cnt++;
            if(cnt >= X){
                list.add(sum);
                sum -= arr[i - X + 1];
            }
        }
        Collections.sort(list, Collections.reverseOrder());

        int max = list.get(0);
        int answer = 1;
        for(int i = 1; i < list.size(); i++){
            if(!list.get(i).equals(max)) break;
            answer++;
        }

        if(max == 0){
            System.out.println("SAD");
        }else{
            System.out.println(max);
            System.out.println(answer);
        }
    }
}
