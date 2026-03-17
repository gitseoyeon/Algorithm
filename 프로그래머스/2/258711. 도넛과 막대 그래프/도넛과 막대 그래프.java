class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        int[] in = new int[1000001];
        int[] out = new int[1000001];
        int maxIdx = 0;
        for(int[] edge : edges) {
            out[edge[0]]++;
            in[edge[1]]++;
            maxIdx = Math.max(maxIdx, Math.max(edge[0], edge[1]));
        }
        
        int stick = 0;
        int eight = 0;
        int donut = 0;
        int start = 0;
        int total = 0;
        
        for(int i = 1; i <= maxIdx; i++) {
            if(in[i] == 0 && out[i] >= 2) {
                start = i;
                total = out[i];   
            } else if(in[i] >= 1 && out[i] == 0) stick++;
            else if(in[i] >= 2 && out[i] >= 2) eight++;
        }
        
        donut = total - (stick + eight);
        
        answer[0] = start;
        answer[1] = donut;
        answer[2] = stick;
        answer[3] = eight;
        
        
        return answer;
    }
}