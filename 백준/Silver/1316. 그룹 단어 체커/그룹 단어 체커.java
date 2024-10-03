import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i = 0; i < N; i++){
            String[] s = br.readLine().split("");
            List<String> str = new ArrayList<>();
            boolean check = true;

            if(s.length == 1){
                cnt++;
                continue;
            }

            String now = s[0];
            str.add(s[0]);

            for(int j = 1; j < s.length; j++){
                if(!now.equals(s[j])){
                    if(str.contains(s[j])){
                        check = false;
                        break;
                    }
                    str.add(s[j]);
                    now = s[j];
                }
            }
            if(check) cnt++;
        }

        System.out.println(cnt);
    }
}