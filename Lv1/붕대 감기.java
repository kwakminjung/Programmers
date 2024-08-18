/*
PCCP 기출문제
[PCCP 기출문제] 1번 / 붕대 감기

https://school.programmers.co.kr/learn/courses/30/lessons/250137
*/

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        
        int n = attacks[attacks.length-1][0];
        int heal_success = 0, attack_row = 0;
        for(int i=0; i<=n; i++) {
            if(i == attacks[attack_row][0]) {
                answer -= attacks[attack_row][1];
                if(answer <= 0) {
                    answer = -1;
                    break;
                }
                attack_row ++;
                heal_success = 1;
            } else if(heal_success == bandage[0]) {
                answer += bandage[1] + bandage[2];
                answer = answer > health ? health: answer;
                heal_success = 1;
            } else {
                answer += bandage[1];
                answer = answer > health ? health: answer;
                heal_success++;
            }
        }
        return answer;
    }
}
