import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][4];

        // 값 입력 받기
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            while(str.hasMoreTokens()){
                arr[i][0] = str.nextToken();
                arr[i][1] = str.nextToken(); 
                arr[i][2] = str.nextToken(); 
                arr[i][3] = str.nextToken(); 

            }
        }

        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2){
                if(Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])){ // 국어 점수
                    if(Integer.parseInt(o1[2]) == Integer.parseInt(o2[2])){ // 영어 점수
                        if(Integer.parseInt(o1[3]) == Integer.parseInt(o2[3])){ // 수학 점수
                            return o1[0].compareTo(o2[0]);
                        }
                        return Integer.compare(Integer.parseInt(o2[3]), Integer.parseInt(o1[3]));
                    }
                    return Integer.compare(Integer.parseInt(o1[2]), Integer.parseInt(o2[2]));
                }
                return Integer.compare(Integer.parseInt(o2[1]), Integer.parseInt(o1[1]));
            }
        });

        for(int i = 0; i < N; i++){
            System.out.println(arr[i][0]);
        }
    }
}
