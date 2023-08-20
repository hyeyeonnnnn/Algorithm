import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int M;
	static int N;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {0,  0, -1, 1};
	static int[] dy = {1, -1, 0, 0}; 
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int a = x+dx[i];
			int b = y+dy[i];
			
			if(a>=0 && b>=0 && a<M && b<N) {
				if(!visited[a][b] && graph[a][b]==1)
					dfs(a,b);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			graph = new int[M][N];
			visited = new boolean[M][N];
			
			for(int j=0;j<K;j++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st2.nextToken());
				int Y = Integer.parseInt(st2.nextToken());
				
				graph[X][Y] = 1;
				
		}
			int count = 0;
			for(int x=0;x<M;x++) {
				for(int y=0;y<N;y++) {					
					if(!visited[x][y] && graph[x][y]==1) {
						dfs(x, y);
						count++;
					}
				}
			}
			
			sb.append(count+"\n");
	}
		System.out.println(sb);
	
	

	}
}