class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        int[] prime = new int[number+1];
        for(int i=1; i<=number; i++) {
            for(int j=1; j<=Math.sqrt(i); j++) {
                if(i%j==0) {
                    prime[i] ++;
                    if(i!=j*j) prime[i]++;
                }
            }
            if(prime[i] > limit) prime[i]=power;
            answer += prime[i];
        }
        
        return answer;
    }
}
