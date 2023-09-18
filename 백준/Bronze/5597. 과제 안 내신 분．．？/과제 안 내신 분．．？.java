import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> student = new ArrayList<>();
		
		for(int i=0;i<28;i++) {
			int num = Integer.parseInt(br.readLine());
			student.add(num);
		}

		student.add(100);
		Collections.sort(student);
		
		int index = 0;
		int i=1;
		while(i<=30) {
			if(i!=student.get(index)) {
				index--;
				sb.append(i+"\n");
			}
			index++;
			i++;
		}
		
		System.out.println(sb);
		
	}
	
}

