import java.util.*;

class Solution {
	    public int solution(int n, int[][] wires) {
	        int answer = 101;
	        
	        int[][] graph = new int[n + 1][];
	        graph = draw(n, wires);
	        
	        for(int i = 0 ; i < wires.length ; i++) {
	        	int cut1 = wires[i][0];
	        	int cut2 = wires[i][1];
	        	
	        	graph[cut1][cut2] = 0;
	        	graph[cut2][cut1] = 0;
	        	
	        	answer = Math.min(answer, dfs(cut1, graph, n));
	        	
	        	graph[cut1][cut2] = 1;
	        	graph[cut2][cut1] = 1;
	        }
	        return answer;
	    }
	    
	    // 인접 행렬 draw 함수
	    public int[][] draw(int n, int[][] wires) {
	    	int[][] graph = new int[n + 1][n + 1];
	    	for(int i = 0 ; i < wires.length ; i++) {
	    		int n1 = wires[i][0];
	    		int n2 = wires[i][1];
	    		graph[n1][n2] = 1;
	    		graph[n2][n1] = 1;
	    	}
	    	
	    	return graph;
	    }
	    
	    // dfs 함수
	    public int dfs(int start_node, int graph[][], int n) {
	    	boolean[] visited = new boolean[n + 1];
	    	
	    	Stack<Integer> s = new Stack<>();
	    	s.add(start_node);
	    	
	    	while(!s.isEmpty()) {
	    		int current = s.pop();
	    		if(!visited[current]) {
	    			visited[current] = true;
	    			
	    			for(int i = 1 ; i < n + 1 ; i++) {
	    				if(graph[current][i] == 1 && !visited[i]) {
	    					s.add(i);
	    				}
	    			}
	    		}
	    	}
	    	int num = 0;
	    	for(boolean isVisited : visited) {
	    		if(isVisited) num ++;
	    	}
	    	return Math.abs(num * 2 - n);
	    }
	}
