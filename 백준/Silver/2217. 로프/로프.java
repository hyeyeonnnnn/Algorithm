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
		int max = Integer.MIN_VALUE;
		ArrayList<Integer> list = new ArrayList<>();
		int min = Integer.MAX_VALUE;

		for(int i=0;i<N;i++) {
			int w = Integer.parseInt(br.readLine());
			list.add(w);
		}
		
		Collections.sort(list, Comparator.reverseOrder());
		for(int j=0;j<N;j++) {
			min = Math.min(min, list.get(j));
			max = Math.max(max, min*(j+1));
		}
		System.out.println(max);
		
		
		
	}
}