import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] board = br.readLine().split("");
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        boolean check = true;

        for (String s : board) {
            if (s.equals("X")) {
                cnt++;
            } else {
                if (cnt % 2 != 0) {
                    check = false;
                    break;
                } else {
                    int A = cnt / 4;
                    int B = cnt % 4;

                    for (int i = 0; i < A; i++) {
                        sb.append("AAAA");
                    }
                    for (int i = 0; i < B / 2; i++) {
                        sb.append("BB");
                    }
                    cnt = 0;
                }
                sb.append(".");
            }
        }

        if (cnt > 0) {
            if (cnt % 2 != 0) {
                check = false;
            } else {
                int A = cnt / 4;
                int B = cnt % 4;

                for (int i = 0; i < A; i++) {
                    sb.append("AAAA");
                }
                for (int i = 0; i < B / 2; i++) {
                    sb.append("BB");
                }
            }
        }

        if (check) {
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }
}