import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        // X의 각 자릿수를 배열로 변환
        char[] digits = Integer.toString(X).toCharArray();

        // X의 자릿수 중 뒤에서부터 오름차순이 아닌 첫 번째 자리를 찾음
        int i = digits.length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        // 더 큰 숫자가 없으면 X가 가장 큰 숫자이므로 0을 출력하고 종료
        if (i < 0) {
            System.out.println(0);
            return;
        }

        // i번째 자리 뒤에서 X[i]보다 큰 수 중 가장 작은 수를 찾음
        int j = digits.length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }   

        // i번째 자리와 j번째 자리의 숫자를 교환
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        // i번째 자리 이후의 숫자들을 오름차순 정렬하여 구성이 같으면서 X보다 큰 수를 만듦
        Arrays.sort(digits, i + 1, digits.length);

        // 결과 문자열을 숫자로 변환하여 출력
        System.out.println(Integer.parseInt(new String(digits)));
    }
}
