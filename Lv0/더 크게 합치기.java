class Solution {
    public double solution(int a, int b) {
        double answer = 0;
        
        int aStr = String.valueOf(a).length();
        int bStr = String.valueOf(b).length();
        
        double bInt = a*Math.pow(10, bStr) + b;
        double aInt = b*Math.pow(10, aStr) + a;
        
        
        answer = bInt > aInt? bInt: aInt; 
        
        return answer;
    }
}
