class Solution {
    public int solution(String s) {
        int answer = 1;
        int fw = 1;
        int lw = 0;
        int fIdx = 0;
        int lIdx = 1;
        
        while(lIdx < s.length()){
            if(fw == lw){
                fIdx = lIdx;
                lIdx += 1;
                fw = 1;
                lw = 0;
                answer++;
            }else{
                if(s.charAt(fIdx) == s.charAt(lIdx)){
                    fw += 1;
                }else{
                    lw += 1;
                }
                lIdx++;
            }   
        }
               
        return answer;
    }
}