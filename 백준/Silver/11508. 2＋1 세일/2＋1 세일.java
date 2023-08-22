import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			int price = Integer.parseInt(br.readLine());
			list.add(price);
		}
		
		Collections.sort(list, Comparator.reverseOrder());
		
		int total = 0;
		for(int i=0;i<N;i++) {
			if(i%3==2)
				continue;
			
			total += list.get(i);
		}
	
		
		System.out.println(total);
		
		
	}
}