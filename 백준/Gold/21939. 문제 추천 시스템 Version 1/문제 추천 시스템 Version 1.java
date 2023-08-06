import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static class Point implements Comparable<Point>{
		int p, l;
		
		public Point(int p,int l) {
			this.p = p;
			this.l = l;
		}

		@Override
		public int compareTo(Main.Point o) {
			if(this.l==o.l) {
				return p-o.p;
			}
			return this.l-o.l;
		}
		
	}
public static void main(String[] args) throws  IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb = new StringBuilder();
Map<Integer, Integer> map = new HashMap<>();
TreeSet<Point> result = new TreeSet<>();	

	int N = Integer.parseInt(br.readLine());
	for(int i=0;i<N;i++) {
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st1.nextToken());
		int l = Integer.parseInt(st1.nextToken());
		map.put(p, l);
		result.add(new Point(p, l));
	}

	int M = Integer.parseInt(br.readLine());
	for(int i=0;i<M;i++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		String c = st.nextToken();
		if(c.equals("add")) {
			int problem = Integer.parseInt(st.nextToken());
			int difficult = Integer.parseInt(st.nextToken());
			if(!map.containsKey(problem)) {
				map.put(problem, difficult);
				result.add(new Point(problem, difficult));
			}
		}
		else if(c.equals("recommend")){
			if(map.keySet().size()>=1) {
				int num = Integer.parseInt(st.nextToken());
				if(num==1) {
					sb.append(result.last().p+"\n");
				}
				else {
					sb.append(result.first().p+"\n");
				}
			}

		}
		else {
			if(map.keySet().size()>=1) {
				int point = Integer.parseInt(st.nextToken());
				if(map.get(point)!=null) {
					result.remove(new Point(point, map.get(point)));
					map.remove(point);
				}
			}

		}

	}

	System.out.println(sb);
}

}