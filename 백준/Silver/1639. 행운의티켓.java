import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] arr = new int[s.length()]; 
        int c; // 부분 문자열
        int max = 0;

        for(int i = 0; i < s.length(); i++){ // 입력 문자열 정수로 변환해서 배열에 저장
            arr[i] = Character.getNumericValue(s.charAt(i));
        }
 
        if(arr.length % 2 == 0){
            c = arr.length;
        }else{
            c = arr.length - 1;
        }

        while(c > 0){
            int start = 0;
            while(start + c <= arr.length){
                int mid = c / 2;
                int left = 0;
                int right = 0;
                for(int i = 0; i < mid; i++){ // left right 로 나누어 계산
                    left += arr[start + i];
                    right += arr[start + i + mid];
                }

                if(left == right){
                    max = Math.max(max, c);
                    break;
                }

                start++;
            }
            // 결과 값이 나올 때 까지 부분 문자열을 줄여감
            c -= 2;
        }
        System.out.println(max);
    }
}
