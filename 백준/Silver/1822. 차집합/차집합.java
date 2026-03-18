import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(str.nextToken());
        int B = Integer.parseInt(str.nextToken());

        TreeSet<Integer> ts = new TreeSet<>();
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < A; i++) {
            ts.add(Integer.parseInt(str.nextToken()));
        }

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < B; i++) {
            int n = Integer.parseInt(str.nextToken());
            if(ts.contains(n)) ts.remove(n);
        }

        if(ts.size() == 0) {
            System.out.println(0);
        } else {
            System.out.println(ts.size());
            for(int i : ts) {
                System.out.print(i + " ");
            }
        }
               
    }
}