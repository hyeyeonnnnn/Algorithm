package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon12845 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		int max = 0;
		int max_idx = 0;
		for(int i=0;i<n-1;i++) {
			if(arr[i]>=max) {
				max = arr[i];
				max_idx = i;
			}
		}
		
		for(int j=0;j<n;j++) {
			if(j!=max_idx)
				sum+=max+arr[j];
		}
		
		System.out.println(sum);
			
	}
}
