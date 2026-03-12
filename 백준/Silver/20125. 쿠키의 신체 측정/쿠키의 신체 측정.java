import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        boolean heartCheck = false;
        int[] heartPos = new int[2];
        for(int i = 0; i < N; i++) {
            char[] s = br.readLine().toCharArray();
            for(int j = 0; j < N; j++) {
                if(s[j] == '*' && !heartCheck) {
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
        StringBuilder sb = new StringBuilder();
        sb.append(heartPos[0] + 1).append(' ').append(heartPos[1] + 1).append('\n');

        for(int i = heartPos[1] - 1; i >= 0; i--) {
            if(arr[heartPos[0]][i] != '*') break;
            lhLen += 1;
        }
        sb.append(lhLen).append(' ');
        
        for(int i = heartPos[1] + 1; i < N; i++) {
            if(arr[heartPos[0]][i] != '*') break;
            rhLen += 1;
        }
        sb.append(rhLen).append(' ');
        
        for(int i = heartPos[0] + 1; i < N; i++) {
            if(arr[i][heartPos[1]] != '*') {
                backPos[0] = i - 1;
                backPos[1] = heartPos[1];
                break;
            }
            backLen += 1;
        }
        sb.append(backLen).append(' ');
        
        int llIdx = backPos[1] - 1;
        int rlIdx = backPos[1] + 1;
        for(int i = backPos[0] + 1; i < N; i++) {
            if(arr[i][llIdx] != '*' && arr[i][rlIdx] != '*') break;
            
            if(arr[i][llIdx] == '*') llLen += 1;
            if(arr[i][rlIdx] == '*') rlLen += 1;
        }
        sb.append(llLen).append(' ');
        sb.append(rlLen);
        
       System.out.println(sb);        
    }
}