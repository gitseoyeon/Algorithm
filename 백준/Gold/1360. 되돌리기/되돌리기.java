import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] texts = new String[N + 1];
        int[] times = new int[N + 1];

        texts[0] = ""; 
        times[0] = 0;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            if (op.equals("type")) {
                String c = st.nextToken();
                int t = Integer.parseInt(st.nextToken());

                texts[i] = texts[i - 1] + c;
                times[i] = t;

            } else { 
                int x = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                int targetTime = t - x;

                int idx = i - 1;
                while (idx > 0 && times[idx] >= targetTime) {
                    idx--;
                }

                texts[i] = texts[idx];
                times[i] = t;
            }
        }

        System.out.println(texts[N]);
    }
}
