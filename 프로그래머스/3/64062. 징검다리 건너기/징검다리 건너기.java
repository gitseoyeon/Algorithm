class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 0;
        int max = Integer.MAX_VALUE;
        while(min <= max) {
            int mid = (min + max) / 2;
            if(isCross(stones, k, mid)) {
                min = mid + 1;
                answer = mid;
            } else {
                max = mid - 1;
            }       
        }
        return answer;
    }
    
    private static boolean isCross(int[] stones, int k, int mid) {
        int cnt = 0;
        for(int i = 0; i < stones.length; i++) {
            if(stones[i] < mid) {
                cnt += 1;
                if(cnt >= k) return false;
            } else {
                cnt = 0;
            }
        }
        return true;
    }
}