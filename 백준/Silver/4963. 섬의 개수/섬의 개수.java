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
	static int cnt = 0;
	static int[] dx = {0,0,1,-1,1,-1,-1,1};
	static int[] dy = {1,-1,0,0,-1,1,-1,1};
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			check[nowX][nowY] = true;
			
			for(int i=0;i<8;i++) {
				int nextX = nowX+dx[i];
				int nextY = nowY+dy[i];
				if(nextX>=0&&nextX<n && nextY>=0&&nextY<m) {
					if(graph[nextX][nextY]==1&&!check[nextX][nextY]) {
						check[nextX][nextY]=true;
						q.add(new int[] {nextX, nextY});
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		while(n!=0 && m!=0) {
			graph = new int[n][m];
			check = new boolean[n][m];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<m;j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(graph[i][j]==1 && !check[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			sb.append(cnt+"\n");
			cnt = 0;
		}
		
		System.out.println(sb);
		
	}	
}

