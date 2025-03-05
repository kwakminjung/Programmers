/* 나의 풀이
- 뭔가 레벨2 풀이로 푼 기분이었다.. 그래도 전에 풀었던 문제들에서 배운 개념을 잊지 않고 써먹을 수 있어서 좋았다. (return 부분 list 를 배열로 바꾸기)

*/

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] score = new int[3];
        int max = 0;
        int[][] s = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        for(int i=0; i<answers.length; i++) {
            for(int j=0; j<3; j++) {
                if(s[j][i % s[j].length] == answers[i]) {
                    score[j] ++;
                    max = Math.max(max, score[j]);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i =0; i<3; i++) {
            if(score[i] == max) list.add(i+1);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}
