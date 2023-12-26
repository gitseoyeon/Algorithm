import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        List<Long> longList = new ArrayList<Long>();
        StringBuilder stb = new StringBuilder();
        
        while (n>0){
            longList.add(n%10);
            n /= 10;
        }
        
        longList.sort(Comparator.reverseOrder());


        for(Long i : longList){
            stb.append(i);
        }

        answer = Long.parseLong(stb.toString());
        
        return answer;
    }
}