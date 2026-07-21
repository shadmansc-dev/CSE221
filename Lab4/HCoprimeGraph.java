import java.io.*;
import java.util.*;

public class HCoprimeGraph {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] adj = new int[n + 1][];
        for(int i = 1; i <= n; i++) {
            int count = 0;
            for(int j = 1; j <= n; j++) {
                if (i != j && gcd(i, j) == 1) {
                    count++;
                }
            }
            adj[i] = new int[count];
            int idx = 0;
            for(int j = 1; j <= n; j++) {
                if (i != j && gcd(i, j) == 1) {
                    adj[i][idx++] = j;
                }
            }
        }

        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if (k > adj[x].length) {
                pw.println(-1);
            } else {
                pw.println(adj[x][k - 1]);
            }
        }

        pw.flush();
        pw.close();
    }

    public static int gcd(int a, int b) {
        while(b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}