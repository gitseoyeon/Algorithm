import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] pattern = br.readLine().split("\\*");


        for(int i = 0; i < N; i++){
            String s = br.readLine();
            if((s.length() < pattern[0].length() + pattern[1].length())){
                System.out.println("NE");
            }else{
                if(s.substring(0, pattern[0].length()).equals(pattern[0]) && s.substring(s.length() - pattern[1].length()).equals(pattern[1])){
                    System.out.println("DA");
                }else{
                    System.out.println("NE");
                }
            }
        }
    }
    
}
