import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> house = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for(int i = 0; i < N; i++) {
            house.offer(Integer.parseInt(str.nextToken()));
        }

        if(N == 1) { 
            if(house.peek() > 1440) {
                System.out.println(-1);
                return;
            }
            System.out.println(house.poll());
            return;
        }


        while(!house.isEmpty()) {
            if(house.size() > 1) {
                int a = house.poll();
                int b = house.poll();
    
                a -= 1;
                b -= 1;
    
                if(a > 0) house.offer(a);
                if(b > 0) house.offer(b);
                answer += 1;
            } else {
                answer += house.poll();
            }
        }

        if (answer > 1440) {
            System.out.println(-1);
        }else {
            System.out.println(answer);
        }
    }
}
