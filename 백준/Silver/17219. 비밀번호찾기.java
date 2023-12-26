import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(str.nextToken()); // 저장된 사이트 주소의 수
        int M = Integer.parseInt(str.nextToken()); // 비밀번호를 찾으려는 사이트 주소의 수
        HashMap<String, String> hm = new HashMap<String, String>();

        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            hm.put(str.nextToken(), str.nextToken());
        }

        for(int i = 0; i < M; i++){
            sb.append(hm.get(br.readLine())).append("\n");
        }

        System.out.println(sb);

    }
}
