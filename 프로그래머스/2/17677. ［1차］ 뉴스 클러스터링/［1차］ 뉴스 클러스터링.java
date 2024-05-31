import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        String st1 = str1.toLowerCase();
        String st2 = str2.toLowerCase();

        List<String> list1 = makeList(st1);
        List<String> list2 = makeList(st2);

        List<String> gyo = new ArrayList<>();
        List<String> hap = new ArrayList<>(list1);

        for (String s : list2) {
            if (list1.contains(s)) {
                gyo.add(s);
                list1.remove(s);
            }
            hap.add(s);
        }

        int gyoSize = gyo.size();
        int hapSize = hap.size() - gyoSize;

        if (hapSize == 0) {
            return 65536;
        }

        double jaccard = (double) gyoSize / hapSize * 65536;
        answer = (int) jaccard;
        return answer;
    }

    private List<String> makeList(String str) {
        List<String> makeList = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);
            if (Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
                makeList.add(String.valueOf(c1) + String.valueOf(c2));
            }
        }
        return makeList;
    }
}
