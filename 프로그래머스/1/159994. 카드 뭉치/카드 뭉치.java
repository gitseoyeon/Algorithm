class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int n1 = 0;
        int n2 = 0;
        
        for(int i = 0; i < goal.length; i++){
            if(n1 < cards1.length && cards1[n1].equals(goal[i])){
                n1++;
                continue;
            }
            if(n2 < cards2.length && cards2[n2].equals(goal[i])){
                n2++;
                continue;
            }
            
            return answer = "No";
        }
        
        return answer = "Yes";
    }
}