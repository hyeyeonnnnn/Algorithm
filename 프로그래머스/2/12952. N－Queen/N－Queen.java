class Solution {
    static int cnt = 0;
    static int[] index;
    static boolean[] visited;
    static boolean[] visited2;
    static boolean[] visited3;
    static void dfs(int n, int depth){
       if(depth==n){
            cnt++;
            for(int val:index)
            	System.out.print(val);
            System.out.println();
            return;
        }
        for(int i=0;i<n;i++) {
           boolean flag = false;
           for(int j=0;j<depth;j++) {
				if(i==index[j]-depth+j || i==index[j]+depth-j || i==index[j]){
                    flag = true;
					break;
                }
			}
            if(flag) continue;
	    	if(!visited[i]) {
		    	visited[i] = true;
                index[depth] = i;
			    dfs(n, depth+1);
				visited[i] = false;
			}
		}
        
    }
    public int solution(int n) {
        index = new int[n];
		visited = new boolean[n];
		visited2 = new boolean[n];
        visited3 = new boolean[n];

		dfs(n, 0);
	
        return cnt;
    }
}