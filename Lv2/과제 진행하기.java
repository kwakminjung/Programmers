class Time() {
    String name;
    String start;
    int playtime;
    
    @Override
    public int compareTo(Time o) {
        return this.start.compareTo(o.start);
    }
}

class Solution {
    public PriorityQueue<Time> pq = new PriorityQueue<>();
    public String now;
    
    public String[] solution(String[][] plans) {
        String[] answer = {};
        
        init(plans);
        
        while(!pq.isEmpty()) {
            Time curr = pq.poll();
            now = curr.start;
        }
        
        return answer;
    }
    
    public void init(String[][] plans) {
        for(int i=0; i<plans; i++) {
            Time t = new Time();
            t.name = plans[i][0];
            String[] parts = plans[i][1].split(":");
            int h = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            t.startH = h;
            t.startM = m;
            t.playtime = Integer.parseInt(plans[0][2]);
            
            pq.offer(t);
        }
    }
    
    public String addTime(String time, int extra) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        
        int next = m + extra;
        if(next >= 60) {
            h += next/60;
            m = next%60;
        } else {
            m = next;
        }
        return String.format("%02d:%02d", h, m);
    }
    
    public String subTime(String time, int extra) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        
        int next = m - extra;
        if(next < 0) {
            h -= -next/60 + 1;
            m = -next%60;
        } else {
            m = next;
        }
        return String.format("%02d:%02d", h, m);
    }
}
