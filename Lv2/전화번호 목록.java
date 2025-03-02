/* 내가 푼 풀이

- (알고리즘 고득점 kit 중) 카테고리가 해쉬였지만 해쉬를 이용하지는 않은..? 풀이
- 뭔가 풀면서도 찝찝하긴 했는데 이게 왜 통과지 싶긴 했다. 해시문제라 당연히 시간초과 날 줄...
*/

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length-1; i++) {
            for(int j=0; j<phone_book[i].length(); j++) {
                if(phone_book[i+1].charAt(j) == phone_book[i].charAt(j)) {
                    if(j == phone_book[i].length()-1) {
                        answer = false;
                    }
                    continue;
                } else break;
            }
        }
        
        return answer;
    }
}

/* 배운 점
- String Array List를 sort() 하면 사전순 정렬이 된다!! 대박!!
- 다른 분의 풀이를 보니 startsWith()로 푸는 방법도 있었다.
- substring(0, j) 의 방법을 쓰는 것도 좋아보였다.
*/
