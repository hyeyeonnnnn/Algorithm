import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1)>Math.abs(o2))
					return Math.abs(o1)-Math.abs(o2);
				else if(Math.abs(o1)==Math.abs(o2))
					return o1-o2;
				else 
					return -1;
			}
			
		});
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			int input = Integer.parseInt(br.readLine());
			if(input==0) {
				if(queue.isEmpty())
					sb.append(0+"\n");
				else {
					sb.append(queue.poll()+"\n");
				}
			}
			else {
				queue.add(input);
			}
		}
		System.out.println(sb);
	}
}
