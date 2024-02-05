import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            
            List<String> list = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            if(N == 0){
                System.exit(0);
            }
            String st = br.readLine().toUpperCase().replaceAll(" ", "");
    
            for(String s : st.split("")){
                list.add(s);
            }
    
            String pass[] = new String[list.size()];
            int idx = 0;
            for(int i = 0; i < list.size(); i++){
                if(i % N == 0){
                    pass[i] = list.get(idx);
                    idx++;
                }else{
                    pass[i] = " ";
                }
            }
    
            for(int j = 1; j < N; j++){
                for(int i = j; i< list.size(); i += N){
                    pass[i] = list.get(idx);
                    idx++;
                }
            }
    
            for(int i = 0; i < pass.length; i++){
                System.out.print(pass[i]);
            }
            
            System.out.println();

        }
        }
    
}
