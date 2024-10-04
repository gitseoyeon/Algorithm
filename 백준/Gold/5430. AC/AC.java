import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String p = br.readLine();
            char[] cArr = p.toCharArray();
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            Deque<String> deque = getDeque(s);
            boolean isReversed = false;
            boolean error = false;

            for (char c : cArr) {
                if (c == 'R') {
                    isReversed = !isReversed;
                } else if (c == 'D') {
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (isReversed) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }

            if (error) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(isReversed ? deque.removeLast() : deque.removeFirst());
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }

    public static Deque<String> getDeque(String s) {
        Deque<String> deque = new LinkedList<>();
        if (s.equals("[]")) {
            return deque;
        }
        String[] sArr = s.substring(1, s.length() - 1).split(",");
        deque.addAll(Arrays.asList(sArr));
        return deque;
    }
}