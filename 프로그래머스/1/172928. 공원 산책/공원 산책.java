import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2]; 
        
        int g = park[0].length();
        int s = park.length;
        int startIdxA = 0;
        int startIdxB = 0;
        
        String[][] map = new String[s][g];
        
        for(int i = 0; i < park.length; i++){
            String[] tmp = park[i].split("");
            for(int j = 0; j < tmp.length; j++){
                map[i][j] = tmp[j];
                if(tmp[j].equals("S")){
                    startIdxA = i;
                    startIdxB = j;
                }
            }
        }
              
        for(int i = 0; i < routes.length; i++){
            StringTokenizer str = new StringTokenizer(routes[i]);
            String op = str.nextToken();
            int n = Integer.parseInt(str.nextToken());

            int nowA = startIdxA;
            int nowB = startIdxB;
            
            if(op.equals("E")){
                for(int j = 0; j < n; j++){
                    nowB++;
                    if(nowB >= g || map[nowA][nowB].equals("X")){
                        nowB = startIdxB;
                        break;
                    }            
                }
                startIdxB = nowB;
            }else if(op.equals("W")){
                for(int j = 0; j < n; j++){
                    nowB--;
                    if(nowB < 0 || map[nowA][nowB].equals("X")){
                        nowB = startIdxB;
                        break;
                    }  
                }
                startIdxB = nowB;
            }else if(op.equals("N")){
                for(int j = 0; j < n; j++){
                    nowA--;
                    if(nowA < 0 || map[nowA][nowB].equals("X")){
                        nowA = startIdxA;
                        break;
                    }
                }
                startIdxA = nowA;
            }else if(op.equals("S")){
                for(int j = 0; j < n; j++){
                    nowA++;
                    if(nowA >= g || map[nowA][nowB].equals("X")){
                        nowA = startIdxA;
                        break;
                    }
                    
                }
                startIdxA = nowA;
            }
        }
        
        answer[0] = startIdxA;
        answer[1] = startIdxB;

        return answer;
    }
}