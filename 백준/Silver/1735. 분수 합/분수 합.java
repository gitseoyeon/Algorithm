import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;

        str = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(str.nextToken());
        int n2 = Integer.parseInt(str.nextToken());

        str = new StringTokenizer(br.readLine());
        int n3 = Integer.parseInt(str.nextToken());
        int n4 = Integer.parseInt(str.nextToken());

        int bunmo = n2 * n4;
        int bunja = n1 * n4 + n3 * n2;

        BigInteger gcd = BigInteger.valueOf(bunja).gcd(BigInteger.valueOf(bunmo));
                
        System.out.print(bunja / gcd.intValue() + " " + bunmo / gcd.intValue());
    }
}
