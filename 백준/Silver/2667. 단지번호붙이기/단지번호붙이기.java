import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int cnt = 0;
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		cnt++;
		for(int i=0;i<4;i++) {
			int a = x+dx[i];
			int b = y+dy[i];
			
			if(a>0 && b>0 && a<=N && b<=N) {
				if(!visited[a][b] && graph[a][b]==1) {
					dfs(a,b);
				}
			}
			
		}
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
				
		N = Integer.parseInt(br.readLine());
		
		graph = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			String map = br.readLine();
			for(int j=1;j<=N;j++) {
				graph[i][j] = map.charAt(j-1)-'0';
			}
		}
		
		int total = 0;
		ArrayList<Integer> home = new ArrayList<>();
		for(int x=1;x<=N;x++) {
			for(int y=1;y<=N;y++) {
				if(!visited[x][y] && graph[x][y]==1) {
					dfs(x, y);
					total++;
					home.add(cnt);
					cnt=0;
				}
			}
		}
		
		sb.append(total+"\n");
		Collections.sort(home);
		for(int i=0;i<home.size();i++) {
			sb.append(home.get(i)+"\n");
		}
		
		System.out.println(sb);
	}
}