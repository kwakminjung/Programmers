import java.util.*;

class Solution {
    public int solution(int[] number) {
        int answer = 0;
        Arrays.sort(number);
        for(int curr=0; curr<=number.length-3; curr++) {
            int left = curr+1, right=number.length-1;
            while(left < right) {
                
                if(number[left]+number[right]==(-1)*number[curr]) {
                    answer ++;
                    
                    if(number[left]==number[right]) {
                        int tmp = right-left+1;
                        answer += tmp*(tmp-1)/2-1;
                        break;
                    }
                    if(number[left]==number[left+1]&&number[right]==number[right-1]) {
                        if(left+1 == right) {
                            break;
                        }
                        left++;
                        right--;
                        answer += 2;
                    }
                    else if(number[left]==number[left+1]) {
                        left++;
                    } 
                    else if(number[right]==number[right-1]) {
                        right--;
                    } else {
                        left++;
                        right--;
                    }
                } else if(number[left]+number[right]>(-1)*number[curr]) right--;
                else if(number[left]+number[right]<(-1)*number[curr]) left++;
            }
        }
        
        return answer;
    }
}
