import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Boolean> hm = new HashMap<>();
        hm.put("ChongChong", true);

        for(int i = 0; i < N; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            String s1 = str.nextToken();
            String s2 = str.nextToken();
            boolean check = false;

            if(hm.containsKey(s1)){
                if(hm.get(s1)){
                    check = true;
                }
            }
            if(hm.containsKey(s2)){
                if(hm.get(s2)){
                    check = true;
                }
            }
            
            if(check){
                hm.put(s1, true);
                hm.put(s2, true);
            } 
            else{
                hm.put(s1, false);
                hm.put(s2, false);
            }
        }

        int cnt = 0;

        for(String key : hm.keySet()){
            if(hm.get(key)){
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
