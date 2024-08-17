/*
2024 KAKAO WINTER INTERNSHIP
가장 많이 받은 선물

https://school.programmers.co.kr/learn/courses/30/lessons/258712
*/

import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;
        int[][] matrix = new int[n][n];
        int[] gift_score = new int[n]; // 선물 지수; 0:준 1:받은 2:점수
        
        for(int i=0; i<gifts.length; i++) {
            StringTokenizer st = new StringTokenizer(gifts[i], " ");
            String send = st.nextToken();
            String receive = st.nextToken();
            
            int send_idx = Arrays.asList(friends).indexOf(send);
            int receive_idx = Arrays.asList(friends).indexOf(receive);

            matrix[send_idx][receive_idx]+=1;
            gift_score[send_idx] += 1;
            gift_score[receive_idx] -= 1;
        }
        
        int[] expected_gifts = new int[n];
        for(int row=0; row<n-1; row++) {
            for(int col=row+1; col<n; col++) {
                int idx;
                // 주고받은 경우
                if(matrix[row][col] != matrix[col][row]) idx = matrix[row][col] > matrix[col][row] ? row:col;
                // 주고받지 않은 경우, 주고 받았지만 동점인 경우
                else {
                    // 선물 지수가 같은 경우
                    if(gift_score[row] == gift_score[col]) continue;  
                    else idx = gift_score[row] > gift_score[col] ? row:col;
                }
                expected_gifts[idx] += 1;
                answer = answer > expected_gifts[idx] ? answer : expected_gifts[idx];
            }
        }
        
        return answer;
    }
}
