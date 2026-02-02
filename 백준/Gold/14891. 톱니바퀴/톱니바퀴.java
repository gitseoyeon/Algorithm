import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[][] wheels;
    static int[] rotate;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wheels = new String[4][8];
        for(int i = 0; i < 4; i++) {
            wheels[i] = br.readLine().split("");
        }

        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int wheel = Integer.parseInt(str.nextToken()) - 1;
            int dir = Integer.parseInt(str.nextToken());
            rotate = new int[4];
            rotate[wheel] = dir;

            changeLeft(wheel, dir);
            changeRight(wheel, dir);

            for(int j = 0; j < 4; j++) {
                if(rotate[j] == 1) {
                    rotateRight(j);
                } else if(rotate[j] == -1){
                    rotateLeft(j);
                }
            }
        }
        int score = getScore();
        System.out.println(score);
    }
    
    private static void rotateRight(int idx) {
       String tmp = wheels[idx][7];
       for(int i = 7; i > 0; i--) {
           wheels[idx][i] = wheels[idx][i - 1];
       }
       wheels[idx][0] = tmp;
    }

    private static void rotateLeft(int idx) {
        String tmp = wheels[idx][0];
        for(int i = 0; i < 7; i++) {
            wheels[idx][i] = wheels[idx][i + 1];
        }
        wheels[idx][7] = tmp;
    }

    private static void changeLeft(int idx, int dir) {
        if(idx == 0) return;
        if(!wheels[idx][6].equals(wheels[idx - 1][2])) {
            rotate[idx - 1] = -dir;
            changeLeft(idx - 1, -dir);
        }
    }
    
    private static void changeRight(int idx, int dir) {
        if(idx == 3) return;
        if(!wheels[idx][2].equals(wheels[idx + 1][6])) {
            rotate[idx + 1] = -dir;
            changeRight(idx + 1, -dir);
        }
    }

    private static int getScore() {
        int sum = 0;
        int plus = 1;
        for(int i = 0; i < 4; i++) {
            if(wheels[i][0].equals("1")) {
                sum += plus;
            }
            plus *= 2;
        }

        return sum;
    }


}
