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
        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 0;
        }

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
                union(parent, rank, u[i], v[i]);
            }
        }

        boolean connected = true;
        if (m > 0){
            int root = -1;
            for(int i = 0; i < n; i++){
                if (degree[i] > 0){
                    if (root == -1){
                        root = find(parent, i);
                    } else {
                        if (find(parent, i) != root){
                            connected = false;
                            break;
                        }
                    }
                }
            }
        }

        int oddCount = 0;
        for(int i = 0; i < n; i++){
            if (degree[i] % 2 != 0){
                oddCount++;
            }
        }

        if (connected && (oddCount == 0 || oddCount == 2)){
            pw.println("YES");
        } else {
            pw.println("NO");
        }

        pw.flush();
        pw.close();
    }

    static int find(int[] parent, int x){
        if (parent[x] != x){
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    static void union(int[] parent, int[] rank, int a, int b){
        int ra = find(parent, a);
        int rb = find(parent, b);
        if (ra == rb){
            return;
        }
        if (rank[ra] < rank[rb]){
            parent[ra] = rb;
        } else if (rank[ra] > rank[rb]){
            parent[rb] = ra;
        } else {
            parent[rb] = ra;
            rank[ra]++;
        }
    }
}