import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = 0;
        int score = 0;
        int P = 0;
        
        while(str.hasMoreTokens()){
            N = Integer.parseInt(str.nextToken());
            score = Integer.parseInt(str.nextToken());
            P = Integer.parseInt(str.nextToken());
        }
        List<Integer> list = new ArrayList<Integer>(P);
        
        
        if(N == 0){
            System.out.println(1);
        }else{
            int rank = 1;
            str = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                while(str.hasMoreTokens()){
                    list.add(Integer.parseInt(str.nextToken()));
                }
            }

            for(int i = 0; i < N; i++){
                if(list.get(i) == score){
                    if(i == N - 1){
                        if(N < P){
                            break;
                        }else{
                            rank = -1;
                            break;
                        }
                    }else{
                        continue;
                    }
                }else if(score < list.get(i)){
                    if (i == N - 1){
                        if(N < P){
                            rank += 1;
                        }else{
                            rank = -1;
                        }
                    }else{
                        rank += 1;
                        continue;
                    }
                }else{
                    break;
                }
            }
            System.out.println(rank);
        }

        
        
    }
    
}
