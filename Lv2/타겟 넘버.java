import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int tmp = 0;
        for(int i: numbers) {
            if(map.containsKey(i)) map.put(i, map.get(i)+1);
            else map.put(i, 1);
            tmp += i;
        }
        if(tmp == target) {
            answer = 1;
            return answer;
        }
        numbers = Arrays.sort(numbers);
        boolean[] visited = new boolean[numbers[number.length-1]];
        
        for(int i=0; i<numbers.length-1; i++) {
            int rest=target-numbers[i];
            visited[numbers[i]] = true;
            
            
            for(int j=0; j<numbers.length; j++) {
                
                for(int k=0; k<numbers.length; k++) {
                    if(!visited[numbers[j]]) {
                        if()
                    } else {
                        tmp += numbers
                    }
                }
                
                
            }
        }
        
        return answer;
    }
}
