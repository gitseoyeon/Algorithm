class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] date = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] week = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int sum = 0;
        
        for(int i = 0; i < a - 1; i++){
            sum+= date[i];
        }
        
        sum += b;
        
        answer = week[sum % 7];
        
        return answer;
    }
}