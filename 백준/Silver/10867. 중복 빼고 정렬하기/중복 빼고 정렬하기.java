import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        Set<Integer> set = new TreeSet<Integer>();

        for(int i = 0; i < N; i++){
            set.add(Integer.parseInt(str.nextToken()));
        }

        for(int i : set){
            System.out.print(i + " ");
        }
        

    }
    
}
