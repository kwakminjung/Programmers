class Solution {
    public int solution(int n) {
        int answer = 0;
        int j = n%2==0 ? 2:1;
        
        for(int i=n; i>=1; i-=2) {
            answer += Math.pow(i, j);
        }
        
        return answer;
    }
}
