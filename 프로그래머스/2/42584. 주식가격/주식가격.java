import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);		
        	while(!q.isEmpty()) {
			int now = q.poll();
			int time = 0;
			boolean flag = false;
				
				for(int i=now+1;i<prices.length;i++) {
					if(prices[now]>prices[i]) {
						flag = true;
						time = i-now;
						break;
					}
				}
				if(now<prices.length) {
					if(flag)
						answer[now] = time;
					else
						answer[now] = prices.length-1-now;
					q.add(now+1);
				}
		}
        return answer;
    }
}