class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        String[] str = s.split("");
        int o = 0;
        int c = 0;
        
        if(str[0].equals(")") || str[str.length - 1].equals("(")){
            return answer = false;
        }else{
            for(int i = 0; i < str.length; i++){
                if(str[i].equals("(")){
                   o++; 
                }else{
                    c++;
                }
                
                if(o < c){
                    return answer = false;
                }
            }
            
            if(o == c){
                return answer;
            }else{
                return answer = false;
            }
            
        }
    }
}