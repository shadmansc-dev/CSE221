import java.io.*;
import java.util.*;

public class FOrderingBinaryTree {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        long[] a=new long[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i]=Long.parseLong(st.nextToken());
        }
        bst(a,0,n-1,pw);
        pw.flush();
        pw.close();
    }
    public static void bst(long[]a,int l,int r,PrintWriter pw){
        if(l>r){
            return;
        }
        int mid=l+(r-l)/2;
        pw.print(a[mid]+" ");
        bst(a, l, mid-1, pw);
        bst(a, mid+1, r, pw);
    }
}