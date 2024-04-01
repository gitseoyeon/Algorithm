class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }
    
    public int gdc(int n1, int n2){
        if(n1 < n2){
            int tmp = n1;
            n1 = n2;
            n2 = tmp;
        }
        
        while(n2 != 0){
            int n = n1 % n2;
            n1 = n2;
            n2 = n;
        }
        
        return n1;
    }
    
    public int lcm(int n1, int n2){
        return n1 * n2 / gdc(n1, n2);
    }
}