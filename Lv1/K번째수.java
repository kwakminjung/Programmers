/* 나의 풀이
- 단순하다 그런데 문제에서 준 인덱스의 의미를 착각해서 왜 안 돼 ?! 하다가 문제를 다시 보고 알았다. 아.

- 다른 분들의 풀이를 보니까 copyOfRange를 이용한다. 저런 함수가 있었구나.. 한 수 배워갑니다..
*/

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j=commands[i][0]-1; j<commands[i][1]; j++) {
                list.add(array[j]);
            }
            list.sort((x, y) -> Integer.compare(x, y));
            answer[i] = list.get(commands[i][2]-1);
        }
        
        return answer;
    }
}
