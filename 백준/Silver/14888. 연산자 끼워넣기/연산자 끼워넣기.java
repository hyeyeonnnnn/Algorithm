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
	static int N;
	static int[] mathArr;
	static int[] maths;
	static int[] arr;
	static int[] result;
	static boolean[] visit;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static StringBuilder sb = new StringBuilder();
	
	static void dfs(int depth) {
		if(depth == N-1) {
			int sum = calculate(result);
			
			if(max<sum)
				max = sum;
			if(min>sum)
				min = sum;

			return;
		}
		
		for(int i=0;i<N-1;i++) {
			if(!visit[i]) {
				visit[i] = true;
				result[depth] = maths[i];
				dfs(depth+1);
				visit[i] = false;
			}
		}
	}
	
	static int calculate(int[] list) {
		int sum = arr[0];

		for(int i=0;i<list.length;i++) {
			switch (list[i]) {
			case 1: 
				sum = sum + arr[i+1];
				break;
			case 2:
				sum = sum - arr[i+1];
				break;	
			case 3:
				sum = sum * arr[i+1];
				break;
			case 4:
				sum = sum / arr[i+1];
				break;
			}
		}
				
		return sum;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		mathArr = new int[4];
		maths = new int[N-1]; //연산자 순서대로 1 1 2 3 4
		visit = new boolean[N-1];
		result = new int[N-1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++)
			mathArr[i] = Integer.parseInt(st.nextToken());
		

		int i = 0;
		int j = 0;
		while(i<N-1) {
			while(mathArr[j]!=0) {
				maths[i] = j+1;
				mathArr[j] -= 1;
				i++;
			}
			j++;
		}
		
		dfs(0);
	
		System.out.println(max+"\n"+min);
		
	}
}