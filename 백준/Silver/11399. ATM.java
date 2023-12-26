import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        List<Integer> list  = new ArrayList<Integer>();
        int sum = 0;

        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(str.nextToken()));
        }

        Collections.sort(list);

        for(int i = 0; i<list.size(); i++){
            sum += list.get(i);
            for(int j = i-1; j >= 0; j--){
                sum += list.get(j);
            }
        }

        System.out.println(sum);

    }
}
