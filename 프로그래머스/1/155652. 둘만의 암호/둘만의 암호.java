public class Solution {
    public static String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (char sk : skip.toCharArray()) {
            alphabet = alphabet.replace(Character.toString(sk), "");
        }

        for (char a : s.toCharArray()) {
            int idx = (alphabet.indexOf(a) + index) % alphabet.length();
            answer.append(alphabet.charAt(idx));
        }

        return answer.toString();
    }
}