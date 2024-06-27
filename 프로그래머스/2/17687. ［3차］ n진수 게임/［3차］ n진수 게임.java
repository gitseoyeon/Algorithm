class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int num = 0;
        int cnt = 0;
        int position = 0;

        while (cnt < t) {
            String str = Integer.toString(num, n);
            for (int i = 0; i < str.length(); i++) {
                if (position % m == p - 1) {
                    answer += str.charAt(i);
                    cnt++;
                    if (cnt == t) break;
                }
                position++;
            }
            num++;
        }
        
        return answer.toUpperCase();
    }
}