class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        int impo = 0;
        String[] two = {"ye", "ma"};
        String[] three = {"aya", "woo"};

        for (String s : babbling) {
            while (s.length() > 0) {
                if (s.length() >= 2 && (s.startsWith("ye") || s.startsWith("ma"))) {
                    if (s.length() >= 4 && s.substring(0, 2).equals(s.substring(2, 4))) {
                        impo++;
                        break;
                    } else {
                        s = s.substring(2);
                    }
                }
                else if (s.length() >= 3 && (s.startsWith("aya") || s.startsWith("woo"))) {
                    if (s.length() >= 6 && s.substring(0, 3).equals(s.substring(3, 6))) {
                        impo++;
                        break;
                    } else {
                        s = s.substring(3);
                    }
                } else {
                    impo++;
                    break;
                }
            }
        }
        return answer = babbling.length - impo;
    }
}