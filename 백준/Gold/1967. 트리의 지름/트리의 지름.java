import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static ArrayList<Edge>[] graph;
	static boolean[] visited;
	static int max_length = Integer.MIN_VALUE;
	static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
	static void dfs(int index, int length) {
		for (Edge edge : graph[index]) {
			int next = edge.to;
			if (!visited[next]) {
                visited[next] = true;
				dfs(next, length + edge.weight);
			}
		}
      max_length = Math.max(max_length, length);

	}

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      n = Integer.parseInt(br.readLine());
      
      graph = new ArrayList[n+1];
      
      for(int i=1;i<=n;i++)
    	  graph[i] = new ArrayList<>();
      
      for(int i=0;i<n-1;i++) {
    	  StringTokenizer st = new StringTokenizer(br.readLine());
    	  int start = Integer.parseInt(st.nextToken());
    	  int end = Integer.parseInt(st.nextToken());
    	  int weight = Integer.parseInt(st.nextToken());
    	  graph[start].add(new Edge(end, weight));
    	  graph[end].add(new Edge(start, weight));
      }
          
      for(int i=1;i<=n;i++) { 
    	visited = new boolean[n+1];
        visited[i] = true;
		dfs(i,0); 
	}
		 
	System.out.println(max_length);
   
   }
}