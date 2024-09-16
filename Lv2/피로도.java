class Solution {
    static boolean[] visited;
    static int n = 0;
    
	static int solution(int k, int[][] dungeons) {
		
        int answer = -1;
        
        int dunLen = dungeons.length;
        visited = new boolean[dunLen];
        
        backtracking(k, 0, dunLen, dungeons);
        
        answer = n;
        return answer;
    }
	
	// n은 정답 누적값
	public static void backtracking(int energy, int depth, int dunLen, int[][] dungeons) {
    	if(depth > n) n = depth;
		
		if(depth == dunLen) return;
    	
    	for(int i = 0 ; i < dunLen ; i++) {
    		if(!visited[i]) {
    			if(energy >= dungeons[i][0]) {
                    visited[i] = true;
    				backtracking(energy - dungeons[i][1], depth + 1, dunLen,  dungeons);
        			visited[i] = false;
    			}
    		}
    	}
    }
}
