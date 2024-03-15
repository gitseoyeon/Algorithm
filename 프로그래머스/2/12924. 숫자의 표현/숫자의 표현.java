class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; i++){
            int sum = 0;
            int now = i;
            while(sum < n){
                sum += now;
                now++;
                if(sum == n){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}