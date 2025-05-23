import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String X = br.readLine();
        int len = X.length();

        StringBuilder[] result = new StringBuilder[5];
        result[0] = new StringBuilder(".");
        result[1] = new StringBuilder(".");
        result[2] = new StringBuilder("#");
        result[3] = new StringBuilder(".");
        result[4] = new StringBuilder(".");

        for (int n = 0; n < len; n++) {
            char word = X.charAt(n);
            int num = n + 1;
            char s = '#';

            if (num % 3 == 0) {
                s = '*';
                result[2].setCharAt(result[2].length() - 1, s);
            }

            result[0].append(".").append(s).append("..");
            result[1].append(s).append(".").append(s).append(".");
            result[2].append(".").append(word).append(".").append(s);
            result[3].append(s).append(".").append(s).append(".");
            result[4].append(".").append(s).append("..");
        }

        for (StringBuilder line : result) {
            System.out.println(line);
        }
    }
}