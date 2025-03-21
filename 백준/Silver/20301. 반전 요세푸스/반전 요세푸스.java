import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static Deque<Integer> dq;
    static int N, K, M, idx;
    static StringBuilder sb;
    static boolean reverse;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        dq = new LinkedList<>();
        idx = 0;
        sb = new StringBuilder();
        reverse = false;

        for(int i = 1; i <= N; i++){
            dq.add(i);
        }

        while(dq.size() > 1){
            if(!reverse){
                forward();
            }else{
                reverse();
            }
        }
        sb.append(dq.poll());
        System.out.println(sb);
    }

    public static void forward(){
        for(int i = 1; i < K; i++){
            dq.add(dq.poll());
        }
        sb.append(dq.poll()).append("\n");
        idx++;
        if(idx % M == 0) {
            reverse = !reverse;
        }
    }

    public static void reverse(){
        for(int i = 1; i < K; i++){
            dq.addFirst(dq.removeLast());
        }
        sb.append(dq.removeLast()).append("\n");
        idx++;
        if(idx % M == 0) {
            reverse = !reverse;
        }
    }
}
