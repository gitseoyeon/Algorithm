import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            String cal = input[0];
            int x = 0;

            switch (cal) {
                case "add":
                    x = Integer.parseInt(input[1]);
                    set.add(x);
                    break;
                case "remove":
                    x = Integer.parseInt(input[1]);
                    set.remove(x);
                    break;
                case "check":
                    x = Integer.parseInt(input[1]);
                    if (set.contains(x))
                        sb.append("1\n");
                    else
                        sb.append("0\n");
                    break;
                case "toggle":
                    x = Integer.parseInt(input[1]);
                    if (set.contains(x))
                        set.remove(x);
                    else
                        set.add(x);
                    break;
                case "all":
                    for (int k = 0; k < 20; k++) {
                        set.add(k + 1);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }

        System.out.print(sb.toString());
        br.close();
    }
}
