import java.io.*;
import java.util.*;

public class EEdgeQueries {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] diff = new int[n];

        int[] u = new int[m];
        int[] v = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            u[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            v[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        for(int i = 0; i < m; i++){
            diff[u[i]]--;
            diff[v[i]]++;
        }

        for(int i = 0; i < n; i++){
            if (i < n - 1){
                pw.print(diff[i] + " ");
            } else {
                pw.print(diff[i]);
            }
        }

        pw.flush();
        pw.close();
    }
}