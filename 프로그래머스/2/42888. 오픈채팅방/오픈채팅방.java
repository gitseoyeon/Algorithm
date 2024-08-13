import java.util.*;

class Solution {
    static HashMap<String, String> user;
    public String[] solution(String[] record) {
        String[] answer = new String[getArrLength(record)];
        int idx = 0;
        
        setUserMap(record);
        
        for(String r : record){
            StringTokenizer str = new StringTokenizer(r);
            String command = str.nextToken();
            String uid = str.nextToken();
            
            if(command.equals("Enter")){
                answer[idx] = user.get(uid) + "님이 들어왔습니다.";
                idx++;
            }else if(command.equals("Leave")){
                answer[idx] = user.get(uid) + "님이 나갔습니다.";
                idx++;
            }
        }
        return answer;
    }
    
    public static int getArrLength(String[] record){
        int cnt = 0;
        for(String r : record){
            StringTokenizer str = new StringTokenizer(r);
            String command = str.nextToken();
            if(command.equals("Enter") || (command.equals("Leave"))){
                cnt++;
            }
        }      
        return cnt;
    }
    
    public static void setUserMap(String[] record){
        user = new HashMap<>();
        
        for(String r : record){
            String[] tmp = r.split(" ");
            if(!tmp[0].equals("Leave")){
                String command = tmp[0];
                String uid = tmp[1];
                String uname = tmp[2];
                
                user.put(uid, uname);
            }
        }  
    }
}
