import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(str.nextToken());
        int N = Integer.parseInt(str.nextToken());

        int[] oven = new int[D];
        str = new StringTokenizer(br.readLine());
        for (int i = 0; i < D; i++) {
            oven[i] = Integer.parseInt(str.nextToken());
        }

        for (int i = 1; i < D; i++) {
            oven[i] = Math.min(oven[i], oven[i - 1]);
        }

        Queue<Integer> pizza = new LinkedList<>();
        str = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pizza.offer(Integer.parseInt(str.nextToken()));
        }

        int pos = D - 1;

        while (!pizza.isEmpty()) {
            int pizzaSize = pizza.poll();

            while (pos >= 0 && oven[pos] < pizzaSize) pos--;

            if (pos < 0) {
                System.out.println(0);
                return;
            }

            pos--;
        }

        System.out.println(pos + 2);
    }
}