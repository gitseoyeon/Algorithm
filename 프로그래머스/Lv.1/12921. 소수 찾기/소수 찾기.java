class Solution {
    public int solution(int n) {
        int answer = 1;
        for(int i = 3; i <= n; i += 2){
            boolean isPrime = true;
            int sqrt = (int) Math.sqrt(i);
            for(int j = 2; j <= sqrt; j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                answer++;
            }
        }
        return answer;
    }
}