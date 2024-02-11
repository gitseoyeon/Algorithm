class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;
        int left_distance = 0;
        int right_distance = 0;
        
        for(int n : numbers){
            if(n == 1 || n == 4 || n == 7){
                answer += "L";
                left = n;
            }else if(n == 3 || n == 6 || n == 9){
                answer += "R";
                right = n;
            }else{
                if(n == 0){
                    n += 11;
                }
                left_distance = Math.abs(n - left) / 3 + Math.abs(n - left) % 3;
                right_distance = Math.abs(n - right) / 3 + Math.abs(n - right) % 3;
                
                if(left_distance > right_distance){
                    answer += "R";
                    right = n;
                }else if(left_distance < right_distance){
                    answer += "L";
                    left = n;
                }else{
                    if(hand.equals("right")){
                        answer += "R";
                        right = n;
                    }else{
                        answer += "L";
                        left = n;
                    }
                }
            }
        }
        return answer;
    }
}