import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int r,c,n;
	static char[][] graph;
	static boolean[][] check;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static void dfs(int x, int y) {
		check[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if(newX>=0&&newX<r && newY>=0&&newY<c){
				if(graph[newX][newY]=='O' &&!check[newX][newY]) {
					dfs(newX, newY);
				}
				check[newX][newY]=true;
			}	
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		graph = new char[r][c];
		check = new boolean[r][c];
		
		for(int i=0;i<r;i++) {
			String input = br.readLine();
			for(int j=0;j<c;j++) {
				graph[i][j] = input.charAt(j);
			}
		}
		
		if(n%2==0) {
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					System.out.print('O');
				}
				System.out.println();
			}
		}
		else {
			for(int k=0;k<n/2;k++) {
				for(int i=0;i<r;i++) {
					for(int j=0;j<c;j++) {
						if(graph[i][j]=='O')
							dfs(i,j);
						}
					}
				for(int i=0;i<r;i++) {
					for(int j=0;j<c;j++) {
						if(!check[i][j])
							graph[i][j]='O';
						else
							graph[i][j]='.';
						}
					}
				check = new boolean[r][c];
		}
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					System.out.print(graph[i][j]);
				}
				System.out.println();
				}
		}
	}	
}

