import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();

        for(int i = 0; i < N; i++){
            String[] arr = br.readLine().split("");
            int len = arr.length;
            for(int j = 0; j < len; j++){
                hm.put(arr[j], hm.getOrDefault(arr[j], 0) + (int)Math.pow(10, len - 1 - j));
            }
        }
        List<String> list = new ArrayList<>(hm.keySet());
        list.sort((o1, o2) -> hm.get(o2).compareTo(hm.get(o1)));

        int num = 9;
        int sum = 0;
        for(String s : list){
            sum += hm.get(s) * num;
            num -= 1;
        }

        System.out.println(sum);
    }

}
