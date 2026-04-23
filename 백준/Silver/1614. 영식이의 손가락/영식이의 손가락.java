import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int[] pattern = {1, 2, 3, 4, 5, 4, 3, 2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int finger = Integer.parseInt(br.readLine());
        int limit = Integer.parseInt(br.readLine());
        int hurtCnt = getHurtCnt(finger);

        int cycle = limit / hurtCnt;
        int remain = limit % hurtCnt;

        long answer = pattern.length * (long)cycle;
        for(int i = 0; i < pattern.length; i++) {
            if(pattern[i] == finger) {
                if(remain == 0) break;
                remain -= 1;
            }
            answer++;
        }

        System.out.println(answer);
    }

    private static int getHurtCnt(int finger) {
        int cnt = 0;
        for(int n : pattern) {
            if(finger == n) {
                cnt += 1;
            }
        }
        return cnt;
    }


}