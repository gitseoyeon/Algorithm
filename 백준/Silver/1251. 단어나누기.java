import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine(); // 값 입력 받기
        List<String> words = new ArrayList<>(); // 모든 경우가 담긴 리스트

        for (int i = 1; i < word.length() - 1; i++) {
            for (int j = i + 1; j < word.length(); j++) {
                // 잘라서 뒤집기
                String reversedPart1 = new StringBuilder(word.substring(0, i)).reverse().toString(); 
                String reversedPart2 = new StringBuilder(word.substring(i, j)).reverse().toString();
                String reversedPart3 = new StringBuilder(word.substring(j)).reverse().toString();
                String combined = reversedPart1 + reversedPart2 + reversedPart3; // 모두 합치기
                words.add(combined);
            }
        }

        Collections.sort(words); // 오름차순으로 정렬
        System.out.println(words.get(0)); // 사전순으로 가장 앞에 있는 값 출력
    }
}