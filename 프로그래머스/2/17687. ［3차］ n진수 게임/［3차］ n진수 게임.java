class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String str = "";
        
        for(int i = 0; i <= t * m; i++){
            str += Integer.toString(i, n);
        }
        
        for(int i = p - 1; i < t * m; i += m){
            answer += str.charAt(i);
        }
        return answer.toUpperCase();
    }
}