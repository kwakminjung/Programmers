class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char c = s.charAt(0);
        int[] cnt = new int[2];
        cnt[0] = 1;
        for(int i=1; i<s.length(); i++) {
            if(c == s.charAt(i)) {
                cnt[0] ++;
            } else {
                cnt[1] ++;
            }
            if(cnt[0] == cnt[1]) {
                answer ++;
                
                cnt[0] = 0;
                cnt[1] = 0;
                
                if(i+1 >= s.length()) break;
                c = s.charAt(i+1);
            }
        }
        
        if(cnt[0] > 0 || cnt[1] > 0) answer ++;
        return answer;
    }
}
