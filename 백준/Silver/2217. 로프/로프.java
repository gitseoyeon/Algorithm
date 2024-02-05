import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] rope = new int[N];
        int w = 0;

        for(int i = 0; i < N; i++){
            rope[i] = Integer.parseInt(br.readLine());
        }

        rope = Arrays.stream(rope).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();

        int cnt = 1;
        for(int i = 0; i < N; i++){
            w = Math.max(w, rope[i] * cnt);
            cnt++;
        }

        System.out.println(w);

    }
    
}
