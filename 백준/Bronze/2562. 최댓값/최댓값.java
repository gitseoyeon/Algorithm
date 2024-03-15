import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[9];
        for(int i = 0; i < num.length; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        int max = Arrays.stream(num).max().getAsInt();

        int idx = 0;
        boolean check = false;

        for(int i = 0; i < num.length; i++){
            if(num[idx] == max){
                check = true;
                break;
            }
            
            idx++;
        }

        if(check == true){
            System.out.println(max);
            System.out.println(idx + 1);
        }else{
            System.out.println('?');
        }

    }
}