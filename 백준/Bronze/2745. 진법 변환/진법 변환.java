import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String N = st.nextToken();
		int B = Integer.parseInt(st.nextToken());
		int result = 0;
		int tmp = 1;
		
		for(int i=N.length()-1;i>=0;i--) {
			char word = N.charAt(i);
			if(word>='A' && word<='Z')
				result += (word-'A'+10)*tmp;
			else {
				result += (word-'0')*tmp;
			}
			tmp*=B;
		}
		System.out.println(result);
	
	}
}