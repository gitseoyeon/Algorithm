import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            // n 칸을 채우기 위해 빈 곳은 0으로 채움
            String binary1 = String.format("%" + n + "s", Integer.toBinaryString(arr1[i])).replace(' ', '0');
            String binary2 = String.format("%" + n + "s", Integer.toBinaryString(arr2[i])).replace(' ', '0');

            String resultBinary = Integer.toBinaryString(Integer.parseInt(binary1, 2) | Integer.parseInt(binary2, 2));

            String mapLine = String.format("%" + n + "s", resultBinary).replace('1', '#').replace('0', ' ');
            answer[i] = mapLine;
        }

        return answer;
    }
}
