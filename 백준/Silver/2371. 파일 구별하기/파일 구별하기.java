import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> file = new ArrayList<>();
        int max = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            while(str.hasMoreTokens()) {
                int n = Integer.parseInt(str.nextToken());
                if(n == -1) break;
                list.add(n);
            }

            int[] tmp = new int[list.size()];
            for(int j = 0; j < tmp.length; j++) {
                tmp[j] = list.get(j);
            }
            max = Math.max(max, tmp.length);
            file.add(tmp);
        }

        for (int K = 1; K <= max; K++) {
            HashSet<List<Integer>> set = new HashSet<>();

            for (int[] arr : file) {
                ArrayList<Integer> prefix = new ArrayList<>(K);
                for (int i = 0; i < K; i++) {
                    if(i < arr.length) {
                        prefix.add(arr[i]);
                    } else {
                        prefix.add(0);
                    }
                }
                set.add(prefix);
            }

            if (set.size() == N) {
                System.out.println(K);
                return;
            }
        }

        System.out.println(max);
        
    }    
}
