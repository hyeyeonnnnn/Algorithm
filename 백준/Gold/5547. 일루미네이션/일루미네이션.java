import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int W,H;
    static int[][] graph;
    static boolean[][] check;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {0, 0, -1, -1, 1, 1};
    static int[] dy1 = {-1, 1, 0, 1, 0, 1};
    static int[] dy2 = {-1, 1, 0, -1, 0, -1};
    static int length = 0;
    
    static void bfs(){
        check = new boolean[H+2][W+2];

        for(int i=0;i<=H;i++) {
        	for(int j=0;j<=W;j++) {
        		if(i==0 || j==0 || i==H+1 || j==W+1 || i==1 || i==H || j==1 || j==W) {
        			if(graph[i][j] == 0 && !check[i][j]) {
        				q.add(new int[] {i, j});
            			check[i][j] = true;
            			sum_length(q);
        			}	
//        			else if(graph[i][j] == 1 ) {
//        				if(i%2==1) {
//                			if(i==1 || i==H)
//                				length += 2;
//                			if(j==1)
//                				length += 1;
//                			if(i==1&&j==W || i==H&&j==W)
//                				length += 2;
//                			else if(j==W)
//                				length += 3;
//                		}
//                		else {
//                			if(i==2&&j==1)
//                				length += 3;
//                			if(i==H&&j==1)
//                				length += 2;
//                			if(i==H)
//                				length += 2;
//                			if(j==W)
//                				length++;
//                		}
//        			}
        		}
        		
        	}
        }
        

    }
    
    static void sum_length(Queue<int[]> q) {
        while(!q.isEmpty()) {
        	int[] now = q.poll();
        	int nowX = now[0];
        	int nowY = now[1];
        	
        	if(nowX%2 == 1) {
        		for(int i=0;i<6;i++) {
            		int nextX = nowX + dx[i];
            		int nextY = nowY + dy1[i];
            		
            		if(nextX>=0&&nextX<=H+1 && nextY>=0&&nextY<=W+1) {
            			if(graph[nextX][nextY] == 0 && !check[nextX][nextY]) {
            				q.add(new int[] {nextX, nextY});
            				check[nextX][nextY] = true;
            			}
            			else if(graph[nextX][nextY] == 1) {
                			length++;
                			check[nextX][nextY] = true;
                		}
            		}
            		
        		}
        	}
        	else {
        		for(int i=0;i<6;i++) {
            		int nextX = nowX + dx[i];
            		int nextY = nowY + dy2[i];
            		
            		if(nextX>=0&&nextX<=H+1 && nextY>=0&&nextY<=W+1) {	
            			if(graph[nextX][nextY] == 0 && !check[nextX][nextY]) {
            				q.add(new int[] {nextX, nextY});
            				check[nextX][nextY] = true;
            			}
            			else if(graph[nextX][nextY] == 1) {
                			length++;
                			check[nextX][nextY] = true;
                		}

            		}
            	}
        	
        	}
        }
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        graph = new int[H+2][W+2];
        
        for(int i=1;i<=H;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=W;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        bfs();
     
        System.out.println(length);
       
    }
}
