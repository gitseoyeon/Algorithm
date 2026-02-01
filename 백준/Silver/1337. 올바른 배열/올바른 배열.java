import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);
        int answer = 4;
        for(int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            int need = 4;
            for(int j = 0; j < 4; j++) {
                if(list.contains(++num)) {
                    need -= 1;
                }
            }

            answer = Math.min(answer, need);
        }

        System.out.println(answer);


    }    
}
