import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> ans = new ArrayList<Integer>();
        long sum = 0L;

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list, Collections.reverseOrder());

        for(int i = 0; i < N; i++){
            ans.add(list.get(i) - i);
        }

        for(int i = 0; i < N; i++){
            if(ans.get(i) < 0){
                break;
            }
            sum += ans.get(i);
        }

        System.out.println(sum);
    }
}
