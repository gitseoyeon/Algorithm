import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int M = Integer.parseInt(br.readLine());
        List<String> broken = new ArrayList<>();
        int target = Integer.parseInt(N);
        int cnt = Math.abs(target - 100);


        if(M != 0){
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                broken.add(str.nextToken());
            }
        }

        if(broken.isEmpty()){
            cnt = Math.min(N.length(), cnt);
            System.out.println(cnt);
            return;
        }

        for(int i = 0; i <= 999999; i++){
            String now = String.valueOf(i);
            boolean check = true;

            for(int j = 0; j < now.length(); j++){
                if(broken.contains(String.valueOf(now.charAt(j)))){
                    check = false;
                    break;
                }
            }

            if(check){
                int pressCnt = Math.abs(target - i) + now.length();
                cnt = Math.min(cnt, pressCnt);
            }
        }

        System.out.println(cnt);

    }
}
