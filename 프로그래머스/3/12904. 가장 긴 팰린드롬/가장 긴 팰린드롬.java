class Solution {
    public int solution(String s) {
        int answer = 1;

        for(int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;

            while(left >= 0 && right < s.length()) {
                if(s.charAt(left) != s.charAt(right)) break;
                
                answer = Math.max(answer, right - left + 1);
                left--;
                right++;
            }
            left = i;
            right = i + 1;

            while(left >= 0 && right < s.length()) {
                if(s.charAt(left) != s.charAt(right)) break;

                answer = Math.max(answer, right - left + 1);
                left--;
                right++;
            }
        }
        return answer;
    }
}