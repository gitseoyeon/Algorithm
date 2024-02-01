import java.util.Arrays;

class Solution {
    public String solution(String X, String Y) {
        int[] countX = new int[10];
        int[] countY = new int[10];

        for (char digit : X.toCharArray()) {
            countX[digit - '0']++;
        }

        for (char digit : Y.toCharArray()) {
            countY[digit - '0']++;
        }

        StringBuilder answer = new StringBuilder();
        boolean hasCommonDigits = false;

        for (int i = 9; i >= 0; i--) {
            int commonDigits = Math.min(countX[i], countY[i]);

            if (commonDigits > 0) {
                hasCommonDigits = true;
                for (int j = 0; j < commonDigits; j++) {
                    answer.append(i);
                }
            }
        }

        if (!hasCommonDigits) {
            return "-1";
        }

        if (answer.toString().replaceAll("0", "").isEmpty()) {
            return "0";
        }

        return answer.toString();
    }
}
