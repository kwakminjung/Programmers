class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pl = p.length();
        double target = Double.valueOf(p);
        
        String tmp;
        for(int i=0; i<=t.length() - pl; i++) {
            tmp = t.substring(i, i+pl);
            if(Double.valueOf(tmp) <= target) answer ++;
        }
        
        return answer;
    }
}
