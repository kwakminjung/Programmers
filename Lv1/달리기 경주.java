import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = players;
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<players.length; i++){
            map.put(players[i], i);
        }
        
        for(int i=0; i<callings.length; i++) {
            int called = map.get(callings[i]);
            String pre = players[called - 1];
            
            answer[called-1] = answer[called];
            answer[called]=pre;
            
            map.put(answer[called-1], called-1);
            map.put(answer[called], called);
        }
        
        return answer;
    }
}
