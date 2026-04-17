import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int cnt = 0;
        boolean passE = false;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'E') {
                passE = true;
            } else if(c =='W') {
                if(passE) {
                    passE = false;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
               
    }
}