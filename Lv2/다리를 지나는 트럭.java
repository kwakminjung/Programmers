/* 나의 풀이
- while 문의 조건에서 처음에 index 조건을 걸었었는데, 이것 때문에 계속 잘못 생각하게 되어 시간이 많이 걸렸다.
*/

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        for(int i=0; i<bridge_length; i++) {
            bridge.offer(0);
        }
        
        int index = 0, sum_weight = 0, answer = 0;
        
        while(!bridge.isEmpty()) {
            int tmp = bridge.poll();
            sum_weight -= tmp;
            answer ++;
            
            if(index < truck_weights.length) {
                if(sum_weight + truck_weights[index] <= weight) {
                    bridge.offer(truck_weights[index]);
                    sum_weight += truck_weights[index];
                    index ++;
                } else {
                    bridge.offer(0);
                }
            }
        }
        
        return answer;
    }
}
