import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int n = N;
		int result = -1;
		int cnt = 0;
		
		while(result!=N) {		
			int newN = n/10 + n%10;
			result = (n%10)*10 + newN%10;
			n = result;
			cnt++;
		}
		
		System.out.println(cnt);
		
		
	}
}