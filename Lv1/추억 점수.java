import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        for(int i=0; i<photo.length; i++) {
            for(String s: photo[i]) {
                if(map.containsKey(s)) {
                    answer[i] += map.get(s);
                }
            }
        }
        
        return answer;
    }
}
