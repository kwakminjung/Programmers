/* 나의 풀이
- 처음에는 인덱스와 플래그를 이용해서 reserve를 탐색하는 동안 lost를 체크하려고 했는데, 문제 조건 중에 체육복 여벌이 있는 사람이 
도난당할 수도 있다는 것을 뒤늦게 확인하고서야 다시 코드를 고쳤다. ^_ㅠ
- 결국 n길이의 배열을 만들어서 체크하는 식으로 진행했다. answer = n - lost.length로 초기에 설정해두었던 것이 위에서 잊었던 조건때문에 안 되는 것을
모르고 계속 돌리다가 나중에야 깨달았다. 으휴휴

- 다른 분의 풀이를 보니까 비슷하게 푼 것 같다. 칭찬받은 코드와 비슷하게 짜버렸는데 기분 좋아질지도 우하하 성장하고 있다는 것이 느껴질 때 너무 짜릿하다

*/

import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] stu = new int[n];
        
        for(int i=0; i<n; i++) stu[i] = 1;
        for(int i: reserve) stu[i-1] = 2;
        for(int i: lost) stu[i-1] --;
        
        for(int i=0; i<n; i++) {
            if(stu[i] == 2) {
                if(i>0 && stu[i-1] == 0) {
                    stu[i] =1;
                    stu[i-1] = 1;
                } else if(i<n-1 && stu[i+1] == 0) {
                    stu[i] = 1;
                    stu[i+1] = 1;
                }
            }
        }
        
        int answer = 0;
        for(int i: stu) {
            if(i >= 1) answer ++;
        }
        
        return answer;
        
        
    }
}
