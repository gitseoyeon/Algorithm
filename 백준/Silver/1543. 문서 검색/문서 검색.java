import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();
        int count = 0;

        while(s1.length() > 0){
            if(s1.startsWith(s2)){
                count++;
                s1 = s1.substring(s2.length());
            }else{
                s1 = s1.substring(1);
            }
        }

        System.out.println(count);
    }

}
