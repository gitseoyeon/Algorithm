import java.util.*;

public class Solution {
    static List<String> combinations;

    public static String[] solution(String[] orders, int[] course) {
        HashMap<String, Integer> hm = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String order : orders) {
            char[] menu = order.toCharArray();
            Arrays.sort(menu);
            String sortedOrder = new String(menu);

            for (int c : course) {
                combinations = new ArrayList<>();
                dfs(sortedOrder, c, 0, "", new boolean[sortedOrder.length()]);
                for (String comb : combinations) {
                    hm.put(comb, hm.getOrDefault(comb, 0) + 1);
                }
            }
        }

        for (int c : course) {
            int max = 0;

            for (Map.Entry<String, Integer> entry : hm.entrySet()) {
                if (entry.getKey().length() == c && entry.getValue() >= 2) {
                    max = Math.max(max, entry.getValue());
                }
            }

            for (Map.Entry<String, Integer> entry : hm.entrySet()) {
                if (entry.getKey().length() == c && entry.getValue() == max) {
                    result.add(entry.getKey());
                }
            }
        }

        Collections.sort(result);
        
        String[] answer = result.toArray(new String[0]);

        return answer;
    }

    static void dfs(String order, int targetLength, int depth, String current, boolean[] visited) {
        if (current.length() == targetLength) {
            combinations.add(current);
            return;
        }

        for (int i = depth; i < order.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(order, targetLength, i + 1, current + order.charAt(i), visited);
                visited[i] = false;
            }
        }
    }
}