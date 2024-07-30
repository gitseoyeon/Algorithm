import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, List<Integer>> recordMap = new HashMap<>();


        for (String record : records) {
            String[] str = record.split(" ");
            String timeStr = str[0];
            String carNumber = str[1];

            String[] timeArr = timeStr.split(":");
            int hour = Integer.parseInt(timeArr[0]);
            int minute = Integer.parseInt(timeArr[1]);
            int time = hour * 60 + minute;

            recordMap.putIfAbsent(carNumber, new ArrayList<>());
            recordMap.get(carNumber).add(time);
        }

  
        for (List<Integer> times : recordMap.values()) {
            if (times.size() % 2 == 1) {
                times.add(23 * 60 + 59);
            }
        }
        
        List<String> carNum = new ArrayList<>(recordMap.keySet());
        Collections.sort(carNum);

        int[] answer = new int[carNum.size()];
        int index = 0;

        for (String car : carNum) {
            List<Integer> times = recordMap.get(car);
            int totalTime = 0;
            for (int i = 0; i < times.size(); i += 2) {
                totalTime += times.get(i + 1) - times.get(i);
            }

            int money = fees[1];
            if (totalTime > fees[0]) {
                money += Math.ceil((double) (totalTime - fees[0]) / fees[2]) * fees[3];
            }

            answer[index++] = money;
        }

        return answer;
    }
}