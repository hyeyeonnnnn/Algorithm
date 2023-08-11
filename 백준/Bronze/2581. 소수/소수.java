import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for(int i=M;i<=N;i++) {
			if(result(i)) {
				sum+=i;
				if(i<min)
					min = i;
			}
		}
		if(sum==0)
			System.out.println(-1);
		else
			System.out.println(sum+"\n"+min);

		
	}
	
	static boolean result(int n) {
		if(n==1)
			return false;
		if(n==2)
			return true;
		for(int i=2;i<n;i++)
			if(n%i==0)
				return false;
		return true;
	}
	

	}