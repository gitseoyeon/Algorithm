import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(str.nextToken());
    int K = Integer.parseInt(str.nextToken());
    int maxSum = 0;
    int sum = 0;

    int[] taste = new int[N];
    int left = 0;
    int right = K - 1;

    str = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++){
        taste[i] = Integer.parseInt(str.nextToken());
    }
    for(int i = 0; i < K; i++){
        sum += taste[i];
    }

    maxSum = sum;

    while(true){
      sum -= taste[left];
      left = (left + 1) % N;
      right = (right + 1) % N;
      sum += taste[right];
      if(left == 0){
        break;
      }
      maxSum = Math.max(maxSum, sum);
     }

    System.out.println(maxSum);
  }
}
