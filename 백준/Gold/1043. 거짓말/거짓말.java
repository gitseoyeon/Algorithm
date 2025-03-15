import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());

        str = new StringTokenizer(br.readLine());
        int truth = Integer.parseInt(str.nextToken());
        ArrayList<HashSet<Integer>> graph = new ArrayList<>();
        boolean[] knowTruth = new boolean[N + 1];
        Queue<Integer> truthMem = new LinkedList<>();

        for (int i = 0; i < truth; i++) {
            int person = Integer.parseInt(str.nextToken());
            truthMem.add(person);
            knowTruth[person] = true;
        }
        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(str.nextToken());
            HashSet<Integer> hs = new HashSet<>();
            for (int j = 0; j < n; j++) {
                hs.add(Integer.parseInt(str.nextToken()));
            }
            graph.add(hs);
        }

        while (!truthMem.isEmpty()) {
            int current = truthMem.poll();

            for (HashSet<Integer> party : graph) {
                if (party.contains(current)) {
                    for (int person : party) {
                        if (!knowTruth[person]) {
                            knowTruth[person] = true;
                            truthMem.add(person);
                        }
                    }
                }
            }
        }

        int cnt = 0;
        for (HashSet<Integer> party : graph) {
            boolean canLie = true;
            for (int person : party) {
                if (knowTruth[person]) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) cnt++;
        }

        System.out.println(cnt);
    }
}