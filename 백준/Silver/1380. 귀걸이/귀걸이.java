import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> angry = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        while (true) {
            if (N == 0) break;
            HashMap<Integer, String> hm = new HashMap<>();
            List<Integer> stu = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                hm.put(i + 1, br.readLine());
                stu.add(i + 1);
            }

            int[] cnt = new int[N];
            for (int i = 0; i < 2 * N - 1; i++) {
                String[] s = br.readLine().split(" ");
                cnt[Integer.parseInt(s[0]) - 1]++;
            }

            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i] == 1) {
                    angry.add(hm.get(i + 1));
                }
            }
            N = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < angry.size(); i++){
            System.out.println(i + 1 + " " +angry.get(i));
        }
    }
}
