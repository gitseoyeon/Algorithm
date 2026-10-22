class Solution {
    public int solution(int[] a) {
        int answer = 2;
        int min = a[0];

        for (int num : a) {
            min = Math.min(min, num);
        }

        int left = a[0];
        int right = a[a.length - 1];

        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] < left) {
                left = a[i];
                answer++;
            }

            if (a[a.length - 1 - i] < right) {
                right = a[a.length - 1 - i];

                if (right != min) answer++;
            }
        }
        
        return answer;
    }
}