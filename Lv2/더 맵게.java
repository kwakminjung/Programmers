/* 나의 풀이
- 힙 문제라서 어떻게 해야하지 하다가 그냥 우선순위 큐로 풀어졌다. 역시 코테에는 답이 없구나아~
- 다른 분들도 우선순위 큐로 풀으셨네.. List 로 푸는 방법도 있나본데 효율성에서 실패한다고 한다.
*/

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s: scoville) {
            pq.offer(s);
        }
        
        int answer = 0;
        while(!pq.isEmpty()) {
            int a = pq.poll();
            if(a < K) {
                if(pq.isEmpty()) return -1;
                int b = pq.poll();
                int tmp = a + b*2;
                pq.offer(tmp);
                answer ++;
            }
        }
        
        return answer;
    }
}
