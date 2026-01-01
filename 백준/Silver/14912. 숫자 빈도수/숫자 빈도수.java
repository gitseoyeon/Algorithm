import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(str.nextToken());
        String d = str.nextToken();
        int answer = 0;

        for(int i = 1; i <= n; i++) {
            String[] arr = String.valueOf(i).split("");
            for(String s : arr) {
                if(s.equals(d)) answer++;
            }
        }

        System.out.println(answer);
    }
}