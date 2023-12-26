class Solution {
    public int[] solution(int[] arr) {
        
        if(arr.length == 1){
            int[] answer = {-1};
            return answer;
        }
        
        int [] answer = new int[arr.length-1];
        int num = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            num = Math.min(num, arr[i]);
        }
        
        int idx = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == num){
                continue;
            }
            answer[idx++] = arr[i];
        }
        return answer;
    }
}