import java.util.*;

class Solution {
    static HashMap<String, Integer> hm;
    static HashMap<String, String> connect;

    public int[] solution(String[] enroll, String[] referral,
                           String[] seller, int[] amount) {

        int[] answer = new int[enroll.length];

        hm = new HashMap<>();
        connect = new HashMap<>();

        setMap(enroll);
        setConnect(enroll, referral);

        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int price = amount[i] * 100;

            divide(name, price);
        }

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = hm.get(enroll[i]);
        }

        return answer;
    }

    private static void setMap(String[] enroll) {
        for (String name : enroll) {
            hm.put(name, 0);
        }
    }

    private static void setConnect(String[] enroll, String[] referral) {
        for (int i = 0; i < enroll.length; i++) {
            connect.put(enroll[i], referral[i]);
        }
    }

    private static void divide(String sell, int price) {
        while (!sell.equals("-")) {
            int div = price / 10;
            int myPrice = price - div;

            hm.put(sell, hm.get(sell) + myPrice);

            if (div == 0) break;

            sell = connect.get(sell);
            price = div;
        }
    }
}