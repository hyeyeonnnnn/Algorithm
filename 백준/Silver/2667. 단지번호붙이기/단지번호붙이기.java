import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] graph;
	static boolean[][] check;
	static int cnt = 1;	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static void dfs(int x, int y) {
		check[x][y] = true;

		for(int i=0;i<4;i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if(newX>=0&&newX<N && newY>=0&&newY<N && graph[newX][newY]==1 &&!check[newX][newY]) {
				cnt++;
				dfs(newX, newY);
			}	
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		check = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			for(int j=0;j<N;j++) {
				graph[i][j] = input.charAt(j)-'0';
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!check[i][j] && graph[i][j]==1) {
					dfs(i, j);
					list.add(cnt);
					cnt = 1;
				}
			}
		}
		
		sb.append(list.size()+"\n");
		Collections.sort(list);
		for(int i=0;i<list.size();i++)
			sb.append(list.get(i)+"\n");
		System.out.println(sb);
	}	
}

