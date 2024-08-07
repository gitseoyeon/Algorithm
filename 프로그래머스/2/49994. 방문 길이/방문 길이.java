import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();

        int x = 0;
        int y = 0;

        String[] str = dirs.split("");

        for(String s : str){
            String before = Integer.toString(x) + Integer.toString(y);
            switch (s) {
                case "U":
                    if(y + 1 > 5)
                        continue;
                    y++;
                    break;
                case "D":
                    if(y - 1 < -5)
                        continue;
                    y--;
                    break;
                case "R":
                    if(x + 1 > 5)
                        continue;
                    x++;
                    break;
                case "L":
                    if(x - 1 < -5)
                        continue;
                    x--;
                    break;
            }

            String after = Integer.toString(x) + Integer.toString(y);

            set.add(before + after);
            set.add(after + before);
        }
        return set.size() / 2;
    }
}