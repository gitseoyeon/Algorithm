import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][N];
        boolean heartCheck = false;
        int[] heartPos = new int[2];
        for(int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                if(s[j].equals("*") && !heartCheck) {
                    heartCheck = true;
                    heartPos[0] = i + 1;
                    heartPos[1] = j;
                }
                arr[i][j] = s[j];
            }
        }

        int lhLen = 0;
        int rhLen = 0;
        int backLen = 0;
        int[] backPos = new int[2];
        int llLen = 0;
        int rlLen = 0;

        for(int i = heartPos[1] - 1; i >= 0; i--) {
            if(!arr[heartPos[0]][i].equals("*")) break;
            lhLen += 1;
        }

        for(int i = heartPos[1] + 1; i < N; i++) {
            if(!arr[heartPos[0]][i].equals("*")) break;
            rhLen += 1;
        }

        for(int i = heartPos[0] + 1; i < N; i++) {
            if(!arr[i][heartPos[1]].equals("*")) {
                backPos[0] = i - 1;
                backPos[1] = heartPos[1];
                break;
            }
            backLen += 1;
        }

        int llIdx = backPos[1] - 1;
        int rlIdx = backPos[1] + 1;
        for(int i = backPos[0] + 1; i < N; i++) {
            if(!arr[i][llIdx].equals("*") && !arr[i][rlIdx].equals("*")) break;
            
            if(arr[i][llIdx].equals("*")) llLen += 1;
            if(arr[i][rlIdx].equals("*")) rlLen += 1;
        }

        System.out.println(heartPos[0] + 1 + " " + (heartPos[1] + 1));
        System.out.println(lhLen+ " " + rhLen + " " + backLen + " " + llLen + " " + rlLen);        
    }
}