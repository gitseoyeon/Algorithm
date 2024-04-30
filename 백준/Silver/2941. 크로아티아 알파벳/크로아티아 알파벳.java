import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    for(String str : arr){
        if(s.contains(str)){
            s = s.replace(str, " ");
        }
    }

    System.out.println(s.length());
  }
}
