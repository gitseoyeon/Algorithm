import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hm = new HashMap<>();
        String[] works = {"Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex"};
        double cnt = 0;

        for(String work : works){
            hm.put(work, 0);
        }
        String work = "";
        while((work = br.readLine()) != null){
            String[] str = work.split(" ");
            cnt += str.length;
            for(String s : str){
                hm.put(s, hm.getOrDefault(s, 0) + 1);
            }
        }
        for(int i = 0; i < 7; i++){
            System.out.printf("%s %d %.2f\n",works[i], hm.get(works[i]), hm.get(works[i]) / cnt);
        }
        System.out.printf("%s %d %.2f\n","Total", (int)cnt, 1.00);
        
    }
}
