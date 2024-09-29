class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i=0; i<balls.length; i++) {
            if(balls[i][0] != startY && balls[i][1] != startX) {
                if(balls[i][0] != startX && balls[i][0]) {
                    balls[i][0] = (startY+balls[i][0])/2;
                    startX = 
                }
            }
        }
        
        return answer;
    }
}
