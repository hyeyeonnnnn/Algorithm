package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int S = Integer.parseInt(st1.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st2.nextToken());
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		int length = 0;
		
		while(true) {
			if(sum>=S) {
				sum -= arr[start++];
			}
			else if(end==N)
				break;
			else
				sum += arr[end++];
			
			if(sum>=S) {
				length = end-start;
				if(length<min)
					min = length;
			}
		}
		if(min == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(min);
	}
}
