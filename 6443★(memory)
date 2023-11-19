import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    static int N;
    static char[] arr;
    static char[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int depth, int n, HashSet<String> set) {
        if (depth == n) {
            String str = new String(result);
            if (set.add(str)) {
                sb.append(str).append("\n");
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                dfs(depth + 1, n, set);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String arrList = br.readLine();
            arr = arrList.toCharArray();
            result = new char[arrList.length()];
            visited = new boolean[arrList.length()];
            Arrays.sort(arr);

            HashSet<String> set = new HashSet<>();
            dfs(0, arrList.length(), set);
        }
        System.out.println(sb);
    }
}
