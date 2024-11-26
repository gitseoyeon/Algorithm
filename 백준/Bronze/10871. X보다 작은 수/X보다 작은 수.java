import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N =  Integer.parseInt(str.nextToken());
        int X = Integer.parseInt(str.nextToken());
        List<Integer> list = new LinkedList<>();

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(str.nextToken());
            if(num < X){
                list.add(num);
            }
        }
        for(int i = 0; i < list.size() - 1; i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.print(list.get(list.size() - 1));
    }
}