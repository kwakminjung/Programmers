import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<keymap.length; i++) {
            for(int j=keymap[i].length()-1; j>=0; j--) {
                Character c = keymap[i].charAt(j);
                if(map.containsKey(c)) map.put(c, Math.min(j+1, map.get(c)));
                else map.put(c, j+1);
            }
        }
        
        for(int i=0; i<targets.length; i++) {
            for(int j=0; j<targets[i].length(); j++) {
                Character c = targets[i].charAt(j);
                if(map.containsKey(c)) answer[i] += map.get(c);
                else {
                    answer[i] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}
