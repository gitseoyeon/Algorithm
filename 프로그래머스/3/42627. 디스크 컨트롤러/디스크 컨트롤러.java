import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int[][] arr = new int[jobs.length][3];
        
        for(int i = 0; i < jobs.length; i++){
            arr[i][0] = i;     
            arr[i][1] = jobs[i][0];
            arr[i][2] = jobs[i][1]; 
        }
        
        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1] != o2[1]) {
                return Integer.compare(o1[1], o2[1]);
          
          } else if(o1[2] != o2[2]) { 
                return Integer.compare(o1[2], o2[2]);
            } else { 
                return Integer.compare(o1[0], o2[0]);
            }
        });
        for(int[] i : arr){
            System.out.println(Arrays.toString(i));
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        
        int time = 0;     
        int completed = 0; 
        int index = 0;
        int[] timeArr = new int[arr.length];
        
        while (completed < jobs.length) {
            while (index < jobs.length && arr[index][1] <= time) {
                pq.offer(arr[index]);
                index++;
            }

            if (!pq.isEmpty()) {
                int[] current = pq.poll();
                time += current[2];
                timeArr[completed] = time - current[1];
                completed++;
            } else {
                time = arr[index][1];
            }
        }
        
        for (int t : timeArr) {
            answer += t;
        }
        answer /= timeArr.length;
        
        return answer;
    }
}