import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> list;
    static int del;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        
        StringTokenizer str = new StringTokenizer(br.readLine());
        int root = 0;
        for(int i = 0; i < N; i++) {
            int parent = Integer.parseInt(str.nextToken());
            if(parent != -1) {
                list.get(parent).add(i);
            } else {
                root = i;
            }
        }

        del = Integer.parseInt(br.readLine());
        cnt = 0;

        if(root == del) {
            System.out.println(cnt);
            return;
        }
        cntLeaf(root);
        System.out.println(cnt);
    }
    
    private static void cntLeaf(int cur) {
        boolean hasChild = false;
        for(int node : list.get(cur)) {
            if(node == del) continue;

            hasChild = true;
            cntLeaf(node);
        }

        if(!hasChild) cnt++;
    }
}
