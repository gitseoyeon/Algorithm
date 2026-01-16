import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<BigInteger> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            String digit = "";
            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if(Character.isDigit(c)) {
                    digit += c;
                    if(j == s.length() - 1) {
                        list.add(new BigInteger(digit));
                        digit = "";
                    }
                } else {
                    if(!digit.isEmpty()) {
                        list.add(new BigInteger(digit));
                        digit = "";
                    }
                }
            }
        }

        Collections.sort(list);
        for(BigInteger n : list) {
            System.out.println(n);
        }
    }
}