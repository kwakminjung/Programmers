/* 나의 풀이
- stack을 이용한 풀이
- 다른 분들의 풀이를 보면서 굳이 '(' 까지 넣지 않고 '('가 나오면 빼는 방식을 쓸 수도 있구나 라는 걸 느꼈다.
*/

import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++) {
            stack.push(arr[i]);
            if(stack.peek() == ')') {
                stack.pop();
                if(stack.isEmpty() || stack.pop() != '(') return false;
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
        
        
    }
}
