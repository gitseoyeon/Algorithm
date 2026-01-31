import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(str.nextToken());
            int stu = Integer.parseInt(str.nextToken());
            int score = Integer.parseInt(str.nextToken());

            list.add(new int[]{c, stu, score});
        }

        list.sort((a, b) -> b[2]- a[2]);
        int[] countryCnt = new int[101];
        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < list.size(); i++) {
            if(cnt == 3) break;
            int[] cur = list.get(i);
            int countryIdx = cur[0];
            if(countryCnt[countryIdx] < 2) {
                sb.append(cur[0]).append(" ").append(cur[1]).append("\n");
                countryCnt[countryIdx] += 1;
                cnt += 1;
            }
        }

        System.out.println(sb);
    }
}