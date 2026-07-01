import java.io.*;
import java.util.*;

public class BTwoSumRevisited {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int [] a=new int[n];
        int [] b=new int[m];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            b[i]=Integer.parseInt(st.nextToken());
        }
        int l=0;
        int r=m-1;
        int sum=0;
        int closest=Integer.MAX_VALUE;
        int i=-1,j=-1;
        boolean flag=false;
        while(l<n && r>=0){
            sum=a[l]+b[r];
            if(Math.abs(sum-k)<closest){
                closest=Math.abs(sum-k);
                i=l+1;
                j=r+1;
            }
            if(sum==k){
                pw.print((l+1)+" "+(r+1));
                flag=true;
                break;
            }
            else if(sum>k){
                r--;
            }
            else{
                l++;
            }
            
        }
        if(flag==false){
            pw.print(i +" "+(j));
        }

        pw.flush();
        pw.close();
    }
}