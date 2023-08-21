import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	static void result(int N) {
		if(N==0)
			return;
		for(int i=2;i<=N;i++) {
			if(N%i==0) {
				System.out.println(i);
				N=N/i;
				result(N);
				return;
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		result(N);
		
	}
}