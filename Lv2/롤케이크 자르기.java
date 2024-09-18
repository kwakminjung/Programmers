import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        HashSet<Integer> setL = new HashSet<>();
        HashSet<Integer> setR = new HashSet<>();
        
        int[] left = new int[topping.length];
        for(int i=0; i<topping.length; i++) {
            setL.add(topping[i]);
            left[i] = setL.size();
        }
        
        int[] right = new int[topping.length];
        for(int i=topping.length-1; i>=0; i--) {
            setR.add(topping[i]);
            right[i] = setR.size();
        }
        
        for(int i=0; i<left.length-1; i++) {
            if(left[i] == right[i+1]) {
                answer ++;
            }
        }
        
        return answer;
    }
}
