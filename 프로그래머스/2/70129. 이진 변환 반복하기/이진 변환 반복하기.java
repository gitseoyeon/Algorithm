class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zeroCnt = 0;
        int cnt = 0;
        
        while(!s.equals("1")){
            for(String str : s.split("")){
                if(str.equals("0")){
                    zeroCnt++;
                }
            }
        
            s = s.replaceAll("0", "");
            int c = s.length();
            s = Integer.toBinaryString(c);
            
            cnt++;
        }
        
        answer[0] = cnt;
        answer[1] = zeroCnt;
        
        
        return answer;
    }
}