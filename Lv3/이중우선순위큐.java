/* 나의 풀이
- 솔직히 틀릴 것 같아서 일단 해보고 나중에 고치자고 생각했는데 맞을 줄은.. 허무하지만 기분은 조타 쿠히히
- 자신감을 가져도 될 것 같다 우하하
- 사실 힙(heap)이라는 게 PriorityQueue 인지 처음 알았다.. ㄱㅡ

- 다른 분들 풀이 보니까 PriorityQueue 두개로 풀이한 것이 대부분이었다. 나도 그 생각은 해봤지만 아무리 생각해도 굳이 싶어서 list로 해결!

*/

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            
            if(st.nextToken().equals("I")) {
                int tmp = Integer.parseInt(st.nextToken());
                list.add(tmp);
                list.sort((x, y) -> Integer.compare(x, y));
            } else {
                if(!list.isEmpty()) {
                    if(st.nextToken().equals("1")) {
                        list.remove(list.size()-1);
                    } else {
                        list.remove(0);
                    }
                }
            }
        }
        
        if(!list.isEmpty()) {
            return new int[]{list.get(list.size()-1), list.get(0)};
        } else {
            return new int[]{0, 0};
        }
    }
}
