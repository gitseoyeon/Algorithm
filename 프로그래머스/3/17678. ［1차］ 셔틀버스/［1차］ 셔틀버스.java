import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int answer = 0;
        int[] crewTime = new int[timetable.length];

        for (int i = 0; i < timetable.length; i++) {
            String[] time = timetable[i].split(":");

            crewTime[i] = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        }

        Arrays.sort(crewTime);

        int[] busTime = new int[n];

        for (int i = 0; i < n; i++) {
            busTime[i] = 9 * 60 + (i * t);
        }

        int crewIdx = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;

            while (crewIdx < crewTime.length 
                   && crewTime[crewIdx] <= busTime[i] && cnt < m) {
                crewIdx++;
                cnt++;
            }

            if (i == n - 1) {
                if (cnt < m) {
                    answer = busTime[i];
                } else {
                    answer = crewTime[crewIdx - 1] - 1;
                }
            }
        }

        return String.format("%02d:%02d", answer / 60, answer % 60);
    }
}