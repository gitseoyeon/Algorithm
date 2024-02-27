import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        int sum = 0;

        for(int i = 0; i < N; i++){
            listA.add(Integer.parseInt(str.nextToken()));
        }
        
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            listB.add(Integer.parseInt(str.nextToken()));
        }

        Collections.sort(listA);
        Collections.sort(listB, Collections.reverseOrder());

        for(int i = 0; i < listA.size(); i++){
            sum += listA.get(i) * listB.get(i);
        }

        System.out.println(sum);
    }
    
}
