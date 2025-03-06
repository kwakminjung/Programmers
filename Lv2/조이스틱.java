/* 나의 풀이
- 이게 왜 레벨2 인지 모르겠네.. 3아냐..??
- 조이스틱을 위아래로 하는 것은 수월했지만 좌우로 움직이는 것은 어려웠다.
- Math.min의 활용도가 돋보였던 문제. if문도 Math.min으로 줄일 수 있다는게 신기하다.
- 좌우로 움직이는 것은 너무 어려워서 gpt의 도움을 받았다. (도서관에서 앞자리 사람이 자꾸 기침해가지고. 집중력 떨어져서 못 풀은 거임. 암튼 그럼. (초예민.))

*/

class Solution {
    public int solution(String name) {
        int[] num = new int['Z'-'A' + 1];
        
        for(int i=0; i<='Z'-'A'; i++) {
            if(i <= ('Z'-'A') / 2) num[i] = i;
            else num[i] = 'Z' - 'A' - i + 1;
        }
        
        int answer = 0;
        for(char c: name.toCharArray()) answer += num[c-'A'];
        
        int min = name.length() - 1;
        for(int i=0; i<name.length(); i++) {
            
            int next = i+1;
            while(next < name.length() && name.charAt(next) == 'A') {
                next ++;
            }
            
            min = Math.min(min, name.length() + i - next + Math.min(i, name.length() - next));
        }
        
        return answer + min;
    }
}
