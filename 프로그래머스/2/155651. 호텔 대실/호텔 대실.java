import java.util.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, (o1, o2) -> 
            o1[0].equals(o2[0]) ? o1[1].compareTo(o2[1]) : o1[0].compareTo(o2[0]));
        
        PriorityQueue<LocalTime> end = new PriorityQueue<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        
        for (String[] time : book_time) {
            LocalTime startTime = LocalTime.parse(time[0], formatter);
            LocalTime endTime = LocalTime.parse(time[1], formatter);

            if (!end.isEmpty() && !end.peek().plusMinutes(10).isAfter(startTime)) { 
                end.poll();
            }
            end.add(endTime);
        }
        answer = end.size();
        return answer;
    }
}