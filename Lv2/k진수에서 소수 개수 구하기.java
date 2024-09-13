import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String kForm = "";
        
        while(n >= k) {
            kForm += String.valueOf(n%k);
            n /= k;
            if(n < k) kForm += String.valueOf(n);
        }
        
        StringTokenizer st = new StringTokenizer(kForm, "0");
        StringBuffer sb = new StringBuffer();
        for(int i=0; st.countTokens() > 0; i++) {
            sb = new StringBuffer(st.nextToken());
            String str = sb.reverse().toString();
            double curr = Double.valueOf(str);
            if(isPrime(curr)) answer++;
        }
        
        return answer;
    }
    
    public static boolean isPrime(double num) {
        if(num <= 1) return false;
        
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        
        return true;
    }
}
