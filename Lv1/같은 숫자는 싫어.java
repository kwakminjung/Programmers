/* 나의 풀이 1
- stack을 이용하여 풀었다.
- top을 보는 함수가 .top()인 줄 알았는데 .peek()이었다. peek은 큐에만 쓰는줄.. 이거 완전 반전아니냐고~
- if문을 두개 써놨는데, or로 해서 하나로 줄일 수 있을 것 같다.
*/

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<arr.length; i++) {
            if(!s.isEmpty()) {
                if(s.peek() != arr[i]) s.push(arr[i]);
            } else {
                s.push(arr[i]);
            }
        }
        answer = s.stream().mapToInt(i->i).toArray();

        return answer;
    }
}

/* 나의 풀이 2
- list를 이용하여 풀었다.
- 풀이 1보다 시간이 적게 걸린다.
*/

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++) {
            if(list.isEmpty() || list.get(list.size()-1) != arr[i]) list.add(arr[i]);
        }

        return list.stream().mapToInt(i->i).toArray();
    }
}
