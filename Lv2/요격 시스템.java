import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0; i<targets.length; i++) {
            int a = targets[i][0];
            int b = targets[i][1];
            for(int j=a+1; j<=b; j++) {
                if(map.containsKey(j)) {
                    map.get(j).add(i);
                    map.put(j, map.get(j));
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(i);
                    map.put(j, set);
                }
            }
        }
        
        for(int key: map.keySet()) {
            
        }
        
        return answer;
    }
}
