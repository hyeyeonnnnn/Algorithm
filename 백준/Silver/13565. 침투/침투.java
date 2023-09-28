import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] graph;
	static boolean[][] check;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean bfs(int x, int y) {
		Queue<Integer> q = new LinkedList<>();	
		check[x][y] = true;
		
		q.add(x);
		q.add(y);
		while(!q.isEmpty()) {		
				int X = q.poll();
				int Y = q.poll();
				if(X==n) {
					return true;
				}
				for(int i=0;i<4;i++) {
					int nextX = X+dx[i];
					int nextY = Y+dy[i];
				if(nextX>0&&nextX<=n && nextY>0&&nextY<=m) {
					if(graph[nextX][nextY]==0 && !check[nextX][nextY]) {
						check[nextX][nextY] = true;
						q.add(nextX);
						q.add(nextY);
					}
				}
			}
			
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new int[n+1][m+1];
		
	
		for(int i=1;i<=n;i++) {
			String input = br.readLine();
			for(int j=1;j<=m;j++) {
				int value = input.charAt(j-1)-'0';
				graph[i][j] = value;
			}
		}
		
		boolean flag = false;
		for(int j=1;j<=m;j++) {
			if(graph[1][j]==0) {
				check = new boolean[n+1][m+1];
				if(bfs(1, j)) {
					flag = true;
					System.out.println("YES");
					break;
				}
			}
		}
		if(!flag) {
			System.out.println("NO");
		}
		
	}
		
}

