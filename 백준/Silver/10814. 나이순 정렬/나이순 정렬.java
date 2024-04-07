import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeMap<Integer, List<String>> members = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            if (members.containsKey(age)) {
                members.get(age).add(name);
            } else {
                List<String> names = new ArrayList<>();
                names.add(name);
                members.put(age, names);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, List<String>> entry : members.entrySet()) {
            int age = entry.getKey();
            List<String> names = entry.getValue();
            for (String name : names) {
                sb.append(age).append(" ").append(name).append("\n");
            }
        }
        System.out.print(sb);

    }
}
