/* 나의 풀이
- queue 를 이용한 풀이
- 알고리즘은 단순하나 head를 poll하는 곳(while문 내부)에서 NullPointerException 가 발생하여 에러를 고치는 곳에 시간이 들었다.
- max 값을 설정해서 괜찮을거라고 단순히 생각했지만, 마지막 poll이 두 번 되는 것이 문제였던 것 같다.

*/

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int max = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            int tmp = 100 - progresses[i];
            tmp = tmp % speeds[i] == 0 ? tmp / speeds[i] : tmp / speeds[i] + 1;
            q.offer(tmp);
            max = Math.max(max, tmp);
        }
        
        Integer head = q.poll();
        int num = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=max; i++) {
            if(head == i) {
                int tmp=0;
                while(head != null && head <= i) {
                    head = q.poll();
                    tmp ++;
                }
                list.add(tmp);
            }
            
        }
        
        return list.stream().mapToInt(i->i).toArray();
        
    }
}
