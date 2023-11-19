import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr = {9,8,7,6,5,4,3,2,1,0};
	static ArrayList list = new ArrayList<Long>();
	//(current 앞자리)start=0,current=0,depth=0,length=1
	static void dfs(long num, int index) {
		if(!list.contains(num))
			list.add(num);
		
		if(index>=10) return;
		
		dfs((num*10)+arr[index], index+1);
		dfs(num, index+1);
	}
		
	
	
	
	public static void main(String[] args) throws IOException, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dfs(0,0);
		Collections.sort(list);
		
		try {
			System.out.println(list.get(N-1));
		} catch (Exception e) {
			System.out.println(-1);
		}
		
	}
}