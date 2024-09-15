import java.util.*;
class Solution {
    // N, S, W, E
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int row = park.length;
        int col = park[0].length();
        
        int[][] map = new int[row][col];
        StringTokenizer st;
        int nowX = 0, nowY = 0;
        for(int i=0;i<row; i++){
            char[] arr = park[i].toCharArray();
            for(int j=0; j<col; j++) {
                if(arr[j] == 'S') {
                    nowX = i;
                    nowY = j;
                } else if(arr[j] == 'X') {
                    map[i][j] = 1;
                }
            }
        }
        
        boolean flag;
        for(int i=0; i<routes.length; i++) {
            flag = true;
            st = new StringTokenizer(routes[i], " ");
            String d = st.nextToken();
            int n = Integer.valueOf(st.nextToken());
            
            int dir = -1;
            if(d.equals("N")) dir=0;
            else if(d.equals("S")) dir=1;
            else if(d.equals("W")) dir=2;
            else dir=3;
            
            for(int j=1;j<=n; j++) {
                    if(nowX + dx[dir]*j < 0 || nowX + dx[dir]*j >= row || nowY + dy[dir]*j < 0 || nowY + dy[dir]*j >= col || map[nowX + dx[dir]*j][nowY + dy[dir]*j] == 1) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) {
                nowX += dx[dir]*n;
                nowY += dy[dir]*n;
            }
            
        }
        answer[0] = nowX;
        answer[1] = nowY;
        return answer;
    }
}
