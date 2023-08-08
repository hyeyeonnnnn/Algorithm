import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> vertex;
        int cnt = 1;

        while(true) {
            vertex = new HashMap<>();
            int edge = 0;
            while (true) {
                int start = sc.nextInt();
                int end = sc.nextInt();

                if(start == -1 && end == -1) return;
                else if(start == 0 && end == 0) break;

                vertex.put(start ,vertex.getOrDefault(start, 0));
                vertex.put(end, vertex.getOrDefault(end,0)+1);
                edge++;
            }
            int root = 0;
            boolean flag = true;
            for(int x: vertex.keySet()) {
                if(vertex.get(x)== 0) root++;
                else if(vertex.get(x)>1) {
                    flag = false;
                    break;
                }
            }

            if(vertex.size()==0) {
                System.out.println("Case "+cnt+" is a tree.");
            } else if(flag && root == 1 && edge == vertex.size()-1) {
                System.out.println("Case "+cnt+" is a tree.");
            } else {
                System.out.println("Case "+cnt+" is not a tree.");
            }
            cnt++;

        }
    }
}