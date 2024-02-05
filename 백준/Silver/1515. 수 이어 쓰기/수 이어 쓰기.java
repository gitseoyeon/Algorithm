import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine(); // 슷자 입력
        int cnt = 0;
        
        while(number.length() != 0){
            cnt++;
            String n = String.valueOf(cnt); // 증가 하는 값 체크

            while(number.length()> 0 && n.length() > 0){
                if(number.charAt(0) == n.charAt(0)){ // n이 늘어나다가 입력한 맨 앞 숫자와 같아질 경우
                    number = number.substring(1); // 맨 앞 숫자 지우기
                }
                n = n.substring(1); // n 값 지우기
            }
        }

        System.out.println(cnt);

    }
    
}
