/* 나의 풀이
- Priority Queue를 정렬하는 것은 class compareTo를 이용해서 쉬웠는데, 전체적인 로직이 생각보다 어려웠다.
- 처음에는 모든 작업들을 pq에 넣어서 작업 가능한 것만 꺼내오려고 했었다. 그런데 실패라고 떠서 gpt에게 물어보니 실행가능한 작업들만 넣어서 효율적으로 짜라는 힌트를 얻었다.
- 배열을 정렬하고서 pq에 넣으려고 하니 작업 번호를 넣는 것이 불가능해졌고, List<Process> 자료구조를 사용하여 해결했다.
- 그 뒤로는 pq에 offer하는 작업에서 논리적 오류가 생겨 수정하는 데에 시간이 많이 지체 되었다.

- 다른 분의 코드를 보니까 class를 사용하지 않으신 분은 소요시간만으로 pq를 짜셨다. 그게.. 되는구나..? 싶긴하다. class는 필수라고 느꼈는데..
*/

import java.util.*;

class Process implements Comparable<Process> {
    int num, strt, oper;
    
    Process(int num, int strt, int oper) {
        this.num = num;
        this.strt = strt;
        this.oper = oper;
    }
    
    @Override
    public int compareTo(Process o) {
        if(this.oper != o.oper) {
            return Integer.compare(this.oper, o.oper);
        } else if(this.strt != o.strt) {
            return Integer.compare(this.strt, o.strt);
        } else {
            return Integer.compare(this.num, o.num);
        }
    }
}

class Solution {
    public int solution(int[][] jobs) {
        List<Process> list = new ArrayList<>();
        for(int i=0; i<jobs.length; i++) {
            list.add(new Process(i, jobs[i][0], jobs[i][1]));
        }
        
        list.sort((x, y) -> Integer.compare(x.strt, y.strt));
        
        PriorityQueue<Process> pq = new PriorityQueue<>();
        
        int complete = 0;
        int index = 0;
        int time = 0;
        int sum = 0;
        while(complete < jobs.length) {
            
            while(index < list.size() && list.get(index).strt <= time) {
                pq.offer(new Process(list.get(index).num, list.get(index).strt, list.get(index).oper));
                index ++;
            }
            
            if(!pq.isEmpty()) {
                Process p = pq.poll();
                time += p.oper;
                sum += time - p.strt;
                complete ++;
            } else {
                if(index < list.size() && list.get(index).strt > time) {
                    time = list.get(index).strt;
                    pq.offer(list.get(index));
                    index ++;
                }
            }
            
        }
        
        return sum / jobs.length;
    }
}
