import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int solution(String[] friends, String[] gifts) {
        int[][] table = new int[friends.length][friends.length];
        int[] presents = new int[friends.length];
        
        Map<String, Integer> friendMap = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            friendMap.put(friends[i], i);
        }

        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            String giver = parts[0];
            String taker = parts[1];
            table[friendMap.get(giver)][friendMap.get(taker)] += 1;
        }

        int[] t_given = Arrays.stream(table).mapToInt(row -> Arrays.stream(row).sum()).toArray();
        int[] t_taken = new int[friends.length];
        for (int j = 0; j < friends.length; j++) {
            for (int i = 0; i < friends.length; i++) {
                t_taken[j] += table[i][j];
            }
        }
        
        int[] ji = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            ji[i] = t_given[i] - t_taken[i];
        }

        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                if (table[i][j] > table[j][i]) { 
                    presents[i]++;
                } else if (table[j][i] > table[i][j]) {
                    presents[j]++;
                } else {
                    if (ji[i] > ji[j]) {
                        presents[i]++;
                    }
                    if (ji[j] > ji[i]) {
                        presents[j]++;
                    }
                }
            }
        }

        int maxPresents = 0;
        for (int present : presents) {
            maxPresents = Math.max(maxPresents, present);
        }
        return maxPresents;
    }
}
