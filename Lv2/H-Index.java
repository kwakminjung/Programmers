/* 나의 풀이
- chatGPT와 열심히 토론을 나눈 뒤에 나온 답..
- 내가 너무 어렵게 생각했구나..

*/

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int idx = 0;
        while(idx < citations.length && citations[idx] < citations.length - idx) {
            idx ++;
        }
        
        return citations.length - idx;
    }
}
