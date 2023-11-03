import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, S;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static int[] result;
	static boolean[] visit;
	static int sum = 0;
	static int cnt = 0;
	static void dfs(int depth, int n, int k, int start) {
		if(depth == k) {
			if(sum == S) 
				cnt++;
			return;
		}
		
		for(int i=start;i<n;i++) {
			if(!visit[i]) {
				visit[i] = true;
				int pre = sum;
				sum += arr[i];
				dfs(depth+1, n, k, i+1);
				sum = pre;
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());

		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
	
		visit = new boolean[N];
		result = new int[N];

		
		for(int i=1;i<=N;i++) {
			dfs(0, N, i, 0);
		}
		
	
		System.out.println(cnt);
	}
}