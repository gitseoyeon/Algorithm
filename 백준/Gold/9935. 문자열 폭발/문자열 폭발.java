import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String bomb = br.readLine();

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            str.append(s.charAt(i));
            if (str.length() >= bomb.length() && str.substring(str.length() - bomb.length()).equals(bomb)) {
                str.delete(str.length() - bomb.length(), str.length());
            }
        }

        if (str.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(str.toString());
        }
    }
}