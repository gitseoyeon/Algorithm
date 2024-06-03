class Solution {
    public static int answer;
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, 0, 0, target);
        
        return answer;
    }
    
    private void dfs(int[] numbers, int idx, int value, int target){
        if(numbers.length == idx){
            if(value == target){
                answer++;
            }   
            return;
        }
        
        dfs(numbers, idx + 1, value + numbers[idx], target);
        dfs(numbers, idx + 1, value - numbers[idx], target);
    }
}