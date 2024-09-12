// 1. DFS 코드 (Stack 사용)

import java.util.*;

class Solution {
    static class Node {
        int data;
        int idx;
        
        Node(int data, int idx) {
            this.data = data;
            this.idx = idx;
        }
    }
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        answer = DFS(numbers, target);
        
        return answer;
    }
    
    public static int DFS(int[] numbers, int target) {
        int answer = 0;
        Stack<Node> s = new Stack<>();
        s.push(new Node(numbers[0], 0));
        s.push(new Node(-numbers[0], 0));
        while(!s.isEmpty()) {
            Node curr = s.pop();
            if(curr.idx >= numbers.length-1) {
                if(curr.data == target) answer ++;
                continue;
            }
            
            int pos = curr.data+numbers[curr.idx+1];
            int neg = curr.data-numbers[curr.idx+1];
            s.push(new Node(pos, curr.idx+1));
            s.push(new Node(neg, curr.idx+1));
        }
        
        return answer;
    }
}


// 2. DFS 코드 (재귀 사용)
import java.util.*;

class Solution {
    static int answer;
    static int target;
    static int[] numbers;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        Solution.numbers = numbers;
        Solution.target = target;
        
        DFS(numbers[0], 0);
        DFS(-numbers[0], 0);
        
        return answer;
    }
    
    public static void DFS(int data, int idx) {
        
        int pos = data+numbers[idx+1];
        int neg = data-numbers[idx+1];
        
        if(idx+1 >= numbers.length-1) {
            if(pos == target) answer++;
            if(neg == target) answer++;
            
            return;
        }
        
        DFS(pos, idx+1);
        DFS(neg, idx+1);
        
    }
}
