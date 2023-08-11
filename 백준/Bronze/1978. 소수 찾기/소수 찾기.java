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
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		int cnt = 0;
 		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(result(arr[i]))
				cnt++;
		}
 		System.out.println(cnt);
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