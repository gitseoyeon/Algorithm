import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static PriorityQueue<Integer> burger;
    private static PriorityQueue<Integer> side;
    private static PriorityQueue<Integer> drink;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int B = Integer.parseInt(str.nextToken());
        int C = Integer.parseInt(str.nextToken());
        int D = Integer.parseInt(str.nextToken());
        int price = 0;

        burger = new PriorityQueue<>(Collections.reverseOrder());
        side = new PriorityQueue<>(Collections.reverseOrder());
        drink = new PriorityQueue<>(Collections.reverseOrder());

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < B; i++) {
            int b = Integer.parseInt(str.nextToken());
            price += b;
            burger.offer(b);
        }

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++) {
            int s = Integer.parseInt(str.nextToken());
            price += s;
            side.offer(s);
        }

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < D; i++) {
            int d = Integer.parseInt(str.nextToken());
            price += d;
            drink.offer(d);
        }

        System.out.println(price);
        System.out.println(getSalePrice());
    }

    private static int getSalePrice() {
        double sale = 0;
        while(!burger.isEmpty() && !side.isEmpty() && !drink.isEmpty()) {
            double b = burger.poll() * 0.9;
            double s = side.poll() * 0.9;
            double d = drink.poll() * 0.9;

            sale += (b + s + d);
        }

        if(!burger.isEmpty()) {
            while(!burger.isEmpty()) {
                sale += burger.poll();
            }
        }
        if(!side.isEmpty()) {
            while(!side.isEmpty()) {
                sale += side.poll();
            }
        }
        if(!drink.isEmpty()) {
            while(!drink.isEmpty()) {
                sale += drink.poll();
            }
        }

        return (int)sale;
    }
}
