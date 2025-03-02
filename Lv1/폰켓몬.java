/* 나의 풀이 
- HashMap을 이용한 풀이
*/

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int s = nums.length;
        s = s/2;

        HashMap<Integer,Integer> pok = new HashMap<Integer, Integer>();

        for(Integer num: nums) {
            if(pok.containsKey(num)) {
                pok.replace(num, pok.get(num)+1);
            } else {
                pok.put(num, 1);
            }
        }

        if(pok.size() >= s) answer = s;
        else answer = pok.size();

        return answer;
    }
}


/* 다른 사람의 풀이 (풀이 본 다음에 학습 후 다시 작성) */

/* 풀이 1 
- 코드의 길이가 짧다는 장점이 있으나, 코드 실행 시간은 나의 풀이보다 좀 더(3.x ms 정도?) 길었다.
*/

import java.util.stream.Collectors;
import java.util.Arrays;

class Solution {
  public int solution(int[] nums) {
    return Arrays.stream(nums).boxed()
      .collect(Collectors.collectingAndThen(Collectors.toSet(), 
                                           ponkemons -> Integer.min(ponkemons.size(), nums.length/2)));
  }
}

/* 배운 내용
- Arrays.stream을 통해서 반복문의 사용없이 코드를 간결화 시킬 수 있다.
- .boxed() : Integer 형태로 변환
- collect.(Collectors.toSet()) : 스트림요소를 set<Integer>로 변환하여 중복 제거
- Collectors.collectingAndThen(수집연산, 변환연산)
  - 첫 번째 인자(수집연산): 데이터를 어떻게 모을것인가?
  - 두 번째 인자(변환연산): 모은 데이터를 어떻게 변환할 것인가?
- 람다 표현식
  - (매개변수) -> (매개변수 처리)
  - ponkemons 매개변수를 매개변수 처리 부분에서 받아서 ponkemons의 크기와 전체 배열/2 한 것중 min 값을 최종적으로 return 하기 된다.
*/


/* ---------------------- 

풀이 2 
- 다른 분의 풀이에서 좀 더 간단하게 하고자 풀이1을 참고하여 return부분을 수정했다.
- HashSet이 있다는 걸 오랜만에 해서 까먹었었다.. 나의 풀이보다 코드 간결성이라던지 시간적으로라던지 모두 훨씬 나은 풀이라는 생각이 든다.
*/

import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(Integer num: nums)
            set.add(num);
        
        return Integer.min(set.size(), nums.length/2);
    }
}


