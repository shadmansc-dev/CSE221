import java.io.*;
import java.util.*;

public class DTheSevenBridgesOfKonigsberg {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] degree = new int[n];

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
            if (u[i] == v[i]){
                degree[u[i]] += 2;
            } else {
                degree[u[i]]++;
                degree[v[i]]++;
            }
        }

        int oddCount = 0;
        for(int i = 0; i < n; i++){
            if (degree[i] % 2 != 0){
                oddCount++;
            }
        }

        if (oddCount == 0 || oddCount == 2){
            pw.println("YES");
        } else {
            pw.println("NO");
        }

        pw.flush();
        pw.close();
    }
}