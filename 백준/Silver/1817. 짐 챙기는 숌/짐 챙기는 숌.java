import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        int cnt = 0;

        if (N == 0) {
            System.out.println(0);
            return;
        }

        int[] books = new int[N];
        str = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            books[i] = Integer.parseInt(str.nextToken());
        }

        int box = M; // 박스 무게

        for (int i = 0; i < N; i++) {
            if (books[i] > box) { // 허용 무게 넘을 경우
                cnt++;
                box = M;
            }
            box -= books[i]; // 박스에 책 넣음
        }

        // 마지막 박스
        if (box != M) {
            cnt++;
        }

        System.out.println(cnt);
    }
}
