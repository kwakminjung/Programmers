/* 나의 풀이
- 사실 StringBuilder의 존재를 까먹어서 고민하다가 그냥 String에 더하기 했는데 역시 이가 없으면 잇몸 ^-^
- 비교하는 부분 compareTo 찾아본 거다. String은 저렇게 비교한다구 한다.
*/

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (x, y) -> (y + x).compareTo(x + y));
        
        if (arr[0].equals("0")) return "0";
        
        String answer = "";
        for(int i=0; i<arr.length; i++) {
            answer += arr[i]+"";
        }
        
        return answer;
    }
}
