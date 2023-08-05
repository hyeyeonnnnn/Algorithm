import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int count = 0;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		queen(0);
		System.out.println(count);
	}
	
	public static void queen(int depth) {
		if(depth==N) {
			count++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			arr[depth] = i;
			if(possible(depth))
				queen(depth+1);
		}
	}
	
	public static boolean possible(int col) {
		for(int i=0;i<col;i++) {
			if(arr[col]==arr[i])
				return false;
		
			if(Math.abs(col-i) == Math.abs(arr[col]-arr[i]))
				return false;
		}
		return true;
	}
}
