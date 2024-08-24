/*
연습문제
이상한 문자 만들기

https://school.programmers.co.kr/learn/courses/30/lessons/12930
*/

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] arr = s.toCharArray();
        int d = 'a'-'A';
        int idx=0;
        
        for(int i=0; i<arr.length; i++) {
            
            if(arr[i]!=' ') {
                if(idx%2 == 0 && arr[i]>='a') { arr[i]-=d; }
                else if(idx%2!=0 && 'A'<=arr[i] && arr[i]<'a') { arr[i] += d; }
                idx++;
            }else { idx=0; }
        }
        
        answer = String.valueOf(arr);
        
        return answer;
    }
}
