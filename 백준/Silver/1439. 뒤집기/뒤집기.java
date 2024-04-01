import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int oCnt;
    public static int zCnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] str = s.split("");
        oCnt = 0;
        zCnt = 0;
        String tmp = str[0];

        cnt(tmp);

        if(tmp.equals("0")){
            zCnt++;
        }else{
            oCnt++;
        }

        for(int i = 0; i < str.length; i++){
            if(!str[i].equals(tmp)){
                tmp = str[i];
                cnt(tmp);
            }
        }

        if(oCnt >= zCnt){
            System.out.println(zCnt);
        }else{
            System.out.println(oCnt);
        }
 
    }

    public static void cnt(String st){
        if(st.equals("0")){
            zCnt++;
        }else{
            oCnt++;
        }
    }
    
}
