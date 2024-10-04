class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int end = 0;
        int minLength = 1000001;
        int[] answer = new int[2];
        int sum = 0;

        while (end < sequence.length) {
            sum += sequence[end];

            while (sum >= k) {
                if (sum == k) {
                    int length = end - start + 1;
                    if (length < minLength) {
                        minLength = length;
                        answer[0] = start;
                        answer[1] = end;
                    }
                }
                sum -= sequence[start];
                start++;
            }
            end++;
        }

        return answer;
    }
}