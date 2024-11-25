import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int answer = 0;
        for(int i = 0; i < 5; i++){
            answer += Math.pow(Integer.parseInt(str.nextToken()), 2);
        }

        System.out.println(answer % 10);
        
    }
}