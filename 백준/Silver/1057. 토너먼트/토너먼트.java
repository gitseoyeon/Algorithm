import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(str.nextToken());
        int jimin = Integer.parseInt(str.nextToken());
        int hansu = Integer.parseInt(str.nextToken());
        int round = 0;

        while(jimin != hansu){
            jimin -= jimin / 2;
            hansu -= hansu / 2;
            round++;
        }

        System.out.println(round);
    }
    
}
