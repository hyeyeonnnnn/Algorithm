import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int time = 0;
		int total = 0;
		int tired = 0; //피로도
		
		while(time!=24) {
			if(tired+A<=M) {
				total += B;
				tired += A;
			}
			else {
				if(tired-C<0){
					tired = 0;
                }
				else
					tired -= C;
			}
			
		
			time++;
		}
		
		System.out.println(total);
		
	}
}