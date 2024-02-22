import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        int N = Integer.parseInt(br.readLine());
        
        str = new StringTokenizer(br.readLine());
        int[] nArr = new int[N];
        
        for(int i = 0; i < nArr.length; i++){
            nArr[i] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(nArr);
        
        int M = Integer.parseInt(br.readLine());
        str = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            boolean check = false;
            int target = Integer.parseInt(str.nextToken());

            int start = 0;
            int end = nArr.length - 1;

            while(start <= end){
                int mid = (start + end) / 2;

                if(nArr[mid] > target){
                    end = mid - 1;
                }else if(nArr[mid] < target){
                    start = mid + 1;
                }else{
                    check = true;
                    break;
                }
            }

            if(check){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
        
    }
}
