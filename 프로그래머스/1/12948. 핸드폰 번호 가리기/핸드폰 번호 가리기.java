class Solution {
    public String solution(String phone_number) {
        String answer = "";
        String show_number = phone_number.substring(phone_number.length() - 4, phone_number.length());
        String hide_number = phone_number.substring(0, phone_number.length() - 4);
        
        hide_number = hide_number.replaceAll(".", "*");
        
        answer = hide_number + show_number;
        return answer;
    }
}