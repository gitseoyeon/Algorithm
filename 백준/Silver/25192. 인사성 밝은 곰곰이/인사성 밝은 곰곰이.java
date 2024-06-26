import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> hs = new HashSet<>();
        int cnt = 0;

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            if(str.equals("ENTER")){
                cnt += hs.size();
                hs.clear();
            }else{
                hs.add(str);
            }
        }

        int total = cnt + hs.size();

        System.out.println(total);
    }
}
