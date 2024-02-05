import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] n = input.replaceAll("9", "6").split(""); // 9를 6으로 대체

        int[] arr = new int[9]; // 등장 횟수 저장
        for (String s : n) 
            arr[Integer.parseInt(s)]++;

        if (arr[6] % 2 != 0){ // 6의 횟수가 홀수 일 경우
            arr[6] = arr[6] / 2 + 1; // 한세트가 더 필요함
        } else{
            arr[6] /= 2;

        } 
        Arrays.sort(arr);
        System.out.print(arr[8]);
    }
}
