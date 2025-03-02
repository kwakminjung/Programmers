/* 나의 풀이
- HashMap을 이용한 풀이
- value값이 0보다 큰 것을 찾는 부분이 비효율적이라고 느껴졌다.
*/

import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(String p: participant) {
            if(map.containsKey(p))
                map.put(p, map.get(p)+1);
            else map.put(p, 1);
        }
        
        for(String c: completion) {
            map.put(c, map.get(c)-1);
        }
        
        for(String key: map.keySet()) {
            if(map.get(key) > 0) answer = key;
        }
        return answer;
    }
}


/* 다른 분의 풀이 참고
- 기본 로직은 같지만, participant를 돌면서 map에 넣는 방식에서 (line 39) 코드 간결화가 이루어졌다.
*/

import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(String p: participant)
            map.put(p, map.getOrDefault(p, 0) + 1);
        
        for(String c: completion)
            map.put(c, map.get(c)-1);
        
        for(String key: map.keySet()) {
            if(map.get(key) > 0) answer = key;
        }
        return answer;
    }
}
