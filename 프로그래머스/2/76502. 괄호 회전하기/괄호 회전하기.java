import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(isCorrect(s)){
                answer++;
            }
            s = s.substring(1) + s.substring(0, 1);
        }
        return answer;
    }
    
    public static boolean isCorrect(String s){
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek() == '(' && s.charAt(i) == ')'){
                    stack.pop();
                }else if(stack.peek() == '{' && s.charAt(i) == '}'){
                    stack.pop();
                }else if(stack.peek() == '[' && s.charAt(i) == ']'){
                    stack.pop();
                }else{
                    return false;
                }
            }
        } 
        return stack.isEmpty();
    }
}