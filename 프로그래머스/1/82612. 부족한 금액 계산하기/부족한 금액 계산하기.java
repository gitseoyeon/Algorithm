class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1L;
        Long sum = 0L;
        for(int i = 1; i <= count; i++){
            sum += price * i;
        }

        answer = money - sum;
        
        if(answer <= 0){
            return Math.abs(answer);
        }else{
            return answer = 0;
        }
    }
}