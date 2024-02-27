class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int nowHealth = health;
        int lastTime = attacks[attacks.length - 1][0];
        int attIdx = 0;
        int bonus = 0;
        
        for(int i = 1; i <= lastTime; i++){
            if(i == attacks[attIdx][0]){
                nowHealth -= attacks[attIdx][1];
                attIdx++;
                bonus = 0;
                if(nowHealth <= 0){
                    answer = -1;
                    return answer;
                }
            }else{
                if(nowHealth < health){
                    nowHealth += bandage[1];
                    bonus++;
                    if(bandage[0] == bonus){
                        nowHealth += bandage[2];
                        bonus = 0;
                    }
                    if(nowHealth > health){
                        nowHealth = health;
                    }
                }
            }
        }
        
        answer = nowHealth;
        return answer;
    }
}