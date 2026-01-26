import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        List<Integer> crane = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            crane.add(Integer.parseInt(str.nextToken()));
        }
        Collections.sort(crane, Collections.reverseOrder());
        
        int M = Integer.parseInt(br.readLine());
        List<Integer> box = new ArrayList<>();
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            box.add(Integer.parseInt(str.nextToken()));
        }
        Collections.sort(box, Collections.reverseOrder());

        if(crane.get(0) < box.get(0)) {
            System.out.println(-1);
            return;
        }

        int answer = 0;
        while (!box.isEmpty()) {
            int idx = 0;

            for (int i = 0; i < crane.size(); i++) {
                while (idx < box.size()) {
                    if (box.get(idx) <= crane.get(i)) {
                        box.remove(idx);
                        break;
                    }
                    idx++;
                }
            }

            answer++;
        }

        System.out.println(answer);

    }
}
