class Solution {
    public int solution(int sticker[]) {
        int answer = 0;

        if(sticker.length == 1) return sticker[0];
        if(sticker.length == 2) return Math.max(sticker[0], sticker[1]);
        
        int[] sum1 = new int[sticker.length - 1];
        int[] sum2 = new int[sticker.length];
        
        sum1[0] = sticker[0];
        sum1[1] = sticker[0];
        for(int i = 2; i < sum1.length; i++) {
            sum1[i] = Math.max(sticker[i] + sum1[i - 2], sum1[i - 1]);
        }
    
        sum2[0] = 0;
        sum2[1] = sticker[1];
        for(int i = 2; i < sum2.length; i++) {
            sum2[i] = Math.max(sticker[i] + sum2[i - 2], sum2[i - 1]);
        }
        
        answer = Math.max(sum1[sum1.length - 1], sum2[sum2.length - 1]);

        return answer;
    }
}