import java.util.*;

class Node {
    int x, y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int[] dx = {-1, 1, 0 , 0};
    public int[] dy = {0, 0, -1, 1};
    public int R, C;
    public int[][] visited;
    
    public int solution(String[] board) {
        int answer = 0;
        R = board.length;
        C = board[0].length();
        visited = new int[R][C];
        
        Node red = findR(board);
        answer = BFS(board, red);
        
        return answer;
    }
    
    public Node findR(String[] board) {
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(board[i].charAt(j) == 'R') {
                    visited[i][j] = 1;
                    return (new Node(i, j));
                } 
            }
        }
        return new Node(0, 0);
    }
    
    public int BFS(String[] board, Node red) {
        int answer = -1;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(red);
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            if(board[curr.x].charAt(curr.y) == 'G') {
                answer = visited[curr.x][curr.y] - 1;
                break;
            }
            
            for(int i=0; i<4; i++) {
                int nextX = curr.x + dx[i];
                int nextY = curr.y + dy[i];
                while(true) {
                    if(isInrage(nextX, nextY) && board[nextX].charAt(nextY) != 'D') {
                        nextX += dx[i];
                        nextY += dy[i];
                    } else {
                        nextX -= dx[i];
                        nextY -= dy[i];
                        break;
                    }
                }
                if(visited[nextX][nextY] == 0) {
                    visited[nextX][nextY] = visited[curr.x][curr.y] + 1;
                    q.offer(new Node(nextX, nextY));
                }
            }
        }
        
        return answer;
    }
    
    public boolean isInrage(int r, int c) {
        if(r >= 0 && r <= R-1 && c >= 0 && c <= C-1) return true;
        return false;
    }
}
