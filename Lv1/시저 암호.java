import java.util.*;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] arr = s.toCharArray();
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == ' ') continue;
            
            char range = Character.isUpperCase(arr[i]) ? 'A' : 'a';
            int gap = (arr[i] - range + n) % 26;
            arr[i] = (char)(range + gap);
        }
        answer = String.valueOf(arr);
        return answer;
    }
}
