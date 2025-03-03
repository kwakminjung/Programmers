/* 나의 풀이
- 많은 테스트 케이스에서 실패했다.
- hash를 사용하는 것은 쉬웠지만, arr로 변환하는 함수를 모르는 기본적인 구멍부터 조합 공식을 모르는 것이 문제가 되었다.
- chat gpt를 이용하여 내 코드의 문제점을 알게 되었다.
*/
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++)
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        
        Integer[] arr = map.values().toArray(new Integer[0]);
        
        int answer = 1;
        for(int i=0; i<arr.length; i++) {
            answer *= (arr[i]+1);
        }
                
        return answer-1;
    }
}

/* 배운 점
- 다른 분의 풀이를 보니까 stream을 사용하는 풀이가 있었다. 단기간에 코딩테스트 훈련을 해야하는 지금으로써는 stream사용은 좀 나중으로 미루려고 한다...
- getOrDefault 왜이렇게 헷갈리는지 모르겠다. 이건 계속 눈에 익혀할 것 같다.
- hash map의 value 값들을 array로 바꾸는 것도 익혀둬야 할 것 같다.
- 조합하는 공식도 !!  (A+1) * (B+1) * ... -1 로 하면된다. 1을 빼는 이유는 아무것도 착용하지 않는 경우까지 포함하기 때문이다.
*/
