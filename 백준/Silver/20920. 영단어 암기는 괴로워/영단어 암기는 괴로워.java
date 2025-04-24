import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < N; i++){
            String voca = br.readLine();
            if(voca.length() >= M){
                hm.put(voca, hm.getOrDefault(voca, 0) + 1);
            }
        }

        List<String> list = new ArrayList<>(hm.keySet());
        list.sort((o1, o2) -> {
            int c1 = hm.get(o1);
            int c2 = hm.get(o2);
            if (c1 != c2) return c2 - c1;
            if (o1.length() != o2.length()) return o2.length() - o1.length();
            return o1.compareTo(o2);
        });

        StringBuilder sb = new StringBuilder();
        for (String word : list) {
            sb.append(word).append('\n');
        }
        System.out.print(sb);
    }
}
