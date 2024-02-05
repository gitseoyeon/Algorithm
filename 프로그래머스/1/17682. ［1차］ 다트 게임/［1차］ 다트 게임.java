class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        String[] str = dartResult.split("");
        int num[] = new int[3];
        int idx = -1;

        for (int i = 0; i < str.length; i++) {
            try {
                int isNum = Integer.parseInt(str[i]);
                if (isNum == 1 && str[i + 1].equals("0")) {
                    isNum = 10;
                    i++;
                }
                idx++;
                num[idx] = isNum;
            } catch (NumberFormatException ex) {
                if (str[i].equals("D")) {
                    num[idx] = (int) Math.pow(num[idx], 2);
                } else if (str[i].equals("T")) {
                    num[idx] = (int) Math.pow(num[idx], 3);
                } else if (str[i].equals("*")) {
                    num[idx] *= 2;
                    if (idx - 1 != -1) {
                        num[idx - 1] *= 2;
                    }
                } else if (str[i].equals("#")) {
                    num[idx] *= -1;
                }
            }
        }

        for (int n : num) {
            answer += n;
        }
        return answer;
    }
}
