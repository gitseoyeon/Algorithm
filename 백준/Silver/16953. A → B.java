import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(str.nextToken());
        int B = Integer.parseInt(str.nextToken());
        int count = 1;

        while(A != B){
            if(B % 2 != 0 & B % 10 != 1 || A > B){
                System.out.println(-1);
                System.exit(0);
            }else{
                if(B % 2 == 0){
                    B /= 2;
                    count++;
                }else if(B % 10 == 1){
                    B /= 10;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(str.nextToken());
        int B = Integer.parseInt(str.nextToken());
        int count = 1;

        while(A != B){
            if(B % 2 != 0 & B % 10 != 1 || A > B){
                System.out.println(-1);
                System.exit(0);
            }else{
                if(B % 2 == 0){
                    B /= 2;
                    count++;
                }else if(B % 10 == 1){
                    B /= 10;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
