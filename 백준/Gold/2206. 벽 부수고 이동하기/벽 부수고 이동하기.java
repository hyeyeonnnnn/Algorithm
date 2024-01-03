import java.util.*;
import java.io.*;
class Main {
	static int N,M;
	static int[][] graph;
	static int[][][] dist;
	static int[] dx={0,0,1,-1};
	static int[] dy={1,-1,0,0};
	
	static int bfs(int w, int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {w,x,y});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowW = now[0];
			int nowX = now[1];
			int nowY = now[2];
			
			if(nowX==N && nowY==M) {
				return dist[nowW][nowX][nowY];
			}
			
			for(int i=0;i<4;i++) {
				int nextX = nowX+dx[i];
				int nextY = nowY+dy[i];
				if(nextX>=1&&nextX<=N && nextY>=1&&nextY<=M) {
					if(dist[nowW][nextX][nextY]==0) {
						if(graph[nextX][nextY]==0) {
							dist[nowW][nextX][nextY] = dist[nowW][nowX][nowY]+1;
							q.add(new int[] {nowW,nextX,nextY});
						}
						else if(graph[nextX][nextY]==1) {
							if(nowW==0) {
								dist[1][nextX][nextY] = dist[nowW][nowX][nowY]+1;
								q.add(new int[] {1,nextX,nextY});
							}
						
						}
					}
				}
			}
		}
		return -1;
	}
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N+1][M+1];
		dist = new int[2][N+1][M+1];
		
		for(int i=1;i<=N;i++) {
			String arr = br.readLine();
			for(int j=1;j<=M;j++) {
				graph[i][j] = arr.charAt(j-1)-'0';
			}
		}
		
		dist[0][1][1] = 1;
		System.out.println(bfs(0,1,1));
		
    }
}



