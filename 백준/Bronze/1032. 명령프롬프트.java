import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] fWord = br.readLine().toCharArray(); 
        
        for(int i = 0; i < N - 1; i++){
            char[] word = br.readLine().toCharArray();
            for(int j = 0; j < fWord.length; j++){
                if(fWord[j] != word[j]){
                    fWord[j] = '?';
                }
            
            }
        }

        System.out.println(fWord);

        
    }
    
}
