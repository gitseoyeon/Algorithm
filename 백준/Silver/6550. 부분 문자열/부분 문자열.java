import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String st = br.readLine();
            if(st == null) break;

            StringTokenizer str = new StringTokenizer(st);
            String s = str.nextToken();
            String t = str.nextToken();
            int idx = 0;

            for(int i = 0; i < t.length(); i++) {
                if(s.charAt(idx) == t.charAt(i)) {
                    idx += 1;
                }
                if(idx == s.length()) break;
            }

            System.out.println(idx == s.length() ? "Yes" : "No");
        }

    }
}