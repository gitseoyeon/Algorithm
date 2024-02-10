import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> books = new HashMap<String, Integer>();

        for(int i = 0; i < N; i++){
            String s = br.readLine();

            if(books.containsKey(s)){
                books.replace(s, books.get(s)+ 1);
            }else{
                books.put(s, 1);
            }
        }

        Integer max = Collections.max(books.values());

        List<String> list = new ArrayList<>(books.keySet());
        Collections.sort(list);

        for(String s : list){
            if(books.get(s) == max){
                System.out.println(s);
                break;
            }
        }
    }
}
