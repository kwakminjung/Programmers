/* 나의 풀이
- 큐와 우선순위 큐 사용
- 다른 분들의 풀이를 보니 자료구조(큐) 하나만으로 구현할 수 있는 방법이 존재했다. 큐를 sorting한 뒤에 index를 잘 만져서(?) 하던데 코드 간결성이나 호율성 면에서 좋아보인다.
*/

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<priorities.length; i++) {
            q.add(i);
            pq.add(priorities[i]);
        }
        
        int num = 0;
        while(!pq.isEmpty()) {
            int head = pq.poll();
            while(!q.isEmpty()) {
                int index = q.poll();
                if(head != priorities[index]) {
                    q.offer(index);
                } else {
                    num ++;
                    if(index == location) return num;
                    break;
                }
            }
        }
        
        return 0; 
    }
}

