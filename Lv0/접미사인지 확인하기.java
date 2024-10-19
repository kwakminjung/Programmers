class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 1;
        
        int i=my_string.length()-1;
        int j=is_suffix.length()-1;
        
        if(i < j) answer = 0;
        else {
            for(; i>=0 && j>=0; i--, j--) {
                if(my_string.charAt(i) != is_suffix.charAt(j)) answer = 0;
            }
        }
        return answer;
    }
}
