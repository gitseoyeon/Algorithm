public class Solution {

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            int times = 0;

            for (char ch : targets[i].toCharArray()) {
                boolean flag = false;
                int time = 101;

                for (String key : keymap) {
                    if (key.indexOf(ch) != -1) {
                        time = Math.min(key.indexOf(ch) + 1, time);
                        flag = true;
                    }
                }

                if (!flag) {
                    times = -1;
                    break;
                }

                times += time;
            }

            answer[i] = times;
        }

        return answer;
    }
}