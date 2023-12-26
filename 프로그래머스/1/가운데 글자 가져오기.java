class Solution {
    public String solution(String s) {
        String answer = "";
        int n = s.length() / 2;
        if(s.length() % 2 == 0){
            answer = s.substring(n - 1, n + 1);
        }else{
            answer = s.substring(n, n + 1);
        }
        return answer;
    }
}