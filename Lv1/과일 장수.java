import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        int[] apple = new int[k+1];
        for(int n: score) apple[n] ++;
        int box = score.length / m;
        
        int idx=k; // 인덱스 표시
        for(int i=1; i<=box; i++) {
            int sum=0; // 현재 개수
            while(sum<m && idx>0) {
                if(apple[idx] <= 0) {
                    idx--;
                } else {
                    sum ++;
                    apple[idx] --;
                }
            }
            answer += idx * m;
        }
        
        return answer;
    }
}
