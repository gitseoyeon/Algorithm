class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pAc = 0;
        int yAc = 0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P'){
                pAc += 1;
            }else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y'){
                yAc += 1;
            }
        }
        
        if(pAc != yAc){
            answer = false;
        }else{
            answer = true;
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(answer);

        return answer;
    }
}