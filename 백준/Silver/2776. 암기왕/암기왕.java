import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int note1Len = Integer.parseInt(br.readLine());
            HashSet<Integer> note1 = new HashSet<>();
            StringTokenizer str = new StringTokenizer(br.readLine());
            for (int n = 0; n < note1Len; n++) {
                note1.add(Integer.parseInt(str.nextToken()));
            }

            int note2Len = Integer.parseInt(br.readLine());
            str = new StringTokenizer(br.readLine());
            for (int n = 0; n < note2Len; n++) {
                int num = Integer.parseInt(str.nextToken());
                if (note1.contains(num)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
        }

        System.out.print(sb);
    }
}