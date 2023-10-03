import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] graph;
	static boolean[][] check;
	static int[][] dp;
	static int[] dx = {1,-1,1,-1,0,0,1,-1};
	static int[] dy = {0,0,1,-1,1,-1,-1,1};
	
	static void bfs(int x, int y) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		q.add(y);
		check[x][y] = true;
		
		while(!q.isEmpty()) {
			int nextX = q.poll();
			int nextY = q.poll();
			for(int i=0;i<8;i++) {
				int newX = nextX+dx[i];
				int newY = nextY+dy[i];
				if(newX>0&&newX<=n && newY>0&&newY<=m) {
					if(!check[newX][newY]) {		
						if(graph[newX][newY]==0) {
							dp[newX][newY] = Math.min(dp[newX][newY],  dp[nextX][nextY]+1);
							q.add(newX);
							q.add(newY);
							check[newX][newY] = true;
					}
				}
				}
			}
			
		
		}
	
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new int[n+1][m+1];
		check = new boolean[n+1][m+1];
		dp = new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=m;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = Integer.MAX_VALUE; //dp 배열값 큰 값으로 초기화
			}
		}
		
		for(int i=1;i<=n;i++)
			for(int j=1;j<=m;j++) {
				if(graph[i][j]==1) {
					dp[i][j] = 1;
					bfs(i,j);
					check = new boolean[n+1][m+1]; //매번 체크해줘야 함
				}
			}
		
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=n;i++)
			for(int j=1;j<=m;j++) {
				if(dp[i][j]>max)
					max = dp[i][j];
			}
		System.out.println(max-1);
			
	}
	
}
