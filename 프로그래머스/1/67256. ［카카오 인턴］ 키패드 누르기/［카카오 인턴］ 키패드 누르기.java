class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;
        int leftDis = 0;
        int rightDis = 0;
        
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
                leftDis = Math.abs(n - left) / 3 + Math.abs(n - left) % 3;
                rightDis = Math.abs(n - right) / 3 + Math.abs(n - right) % 3;
                
                if(leftDis > rightDis){
                    answer += "R";
                    right = n;
                }else if(leftDis < rightDis){
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