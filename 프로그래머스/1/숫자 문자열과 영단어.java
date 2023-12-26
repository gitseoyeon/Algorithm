class Solution {
    public int solution(String s) {
        int answer = 0;
        String str = "";
        String temp = "";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                str += c;
            }else{
                temp += c;
            }
            
            if(temp.equals("one")){
                str += "1";
                temp = "";
            }else if(temp.equals("two")){
                str += "2";
                temp = "";
            }else if(temp.equals("three")){
                str += "3";
                temp = "";
            }else if(temp.equals("four")){
                str += "4";
                temp = "";
            }else if(temp.equals("five")){
                str += "5";
                temp = "";
            }else if(temp.equals("six")){
                str += "6";
                temp = "";
            }else if(temp.equals("seven")){
                str += "7";
                temp = "";
            }else if(temp.equals("eight")){
                str += "8";
                temp = "";
            }else if(temp.equals("nine")){
                str += "9";
                temp = "";
            }else if(temp.equals("zero")){
                str += "0";
                temp = "";
            }
        }
        answer = Integer.parseInt(str);
        return answer;
    }
}