class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int length = number.length() - k;
        int start = 0;

        for (int i = 0; i < length; i++) {
            int end = number.length() - (length - i) + 1;
            int idx = getMaxIndex(number, start, end);
            answer.append(number.charAt(idx));
            start = idx + 1;
        }

        return answer.toString();
    }

    private int getMaxIndex(String number, int start, int end) {
        int maxIdx = start;

        for (int i = start; i < end; i++) {
            if (number.charAt(i) > number.charAt(maxIdx)) {
                maxIdx = i;
            }
        }

        return maxIdx;
    }
}
