import java.util.*;

class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    static int cnt = 1;
    
    public int solution(String word) {
        int answer = 0;
        recur(0, "");
        
        String target = "";
        for(char c: word.toCharArray()) {
            if(c == 'A') target += "1";
            else if(c == 'E') target += "2";
            else if(c == 'I') target += "3";
            else if(c == 'O') target += "4";
            else if(c == 'U') target += "5";
        }
        answer = map.get(target);
        
        return answer;
    }
    
    public static void recur(int depth, String str) {
        if(depth >= 5) return;
        for(int i=1; i<=5; i++) {
            String next = str + String.valueOf(i);
            map.put(next, cnt);
            cnt ++;
            recur(depth + 1, next);
        }
    }
}
