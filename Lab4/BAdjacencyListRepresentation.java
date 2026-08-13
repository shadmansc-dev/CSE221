import java.io.*;
import java.util.*;

public class BAdjacencyListRepresentation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<int[]>>adjL=new ArrayList<>();

        for(int i=0;i<=n;i++){
            adjL.add(new ArrayList<>());
        }

        int [] u=new int[m];
        int [] v=new int[m];
        int [] w=new int[m];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            u[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            v[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            w[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<m;i++){
            adjL.get(u[i]).add(new int[]{v[i],w[i]});
        }

        for(int i=1;i<=n;i++){
            pw.print(i+": ");
            for(int j=0;j<adjL.get(i).size();j++){
                pw.print("("+adjL.get(i).get(j)[0]+","+adjL.get(i).get(j)[1]+") ");
            }
            pw.println();
        }
        
        pw.flush();
        pw.close();
    }
}