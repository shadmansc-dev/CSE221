import java.io.*;
import java.util.*;

public class GCanYouSplitTheArray {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int [] a=new int[n];
        int k=Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }
        long low=0,high=0;
        for(int i=0;i<n;i++){
            if(a[i]>low){
                low=a[i];
            }
            high+=a[i];
        }
        while(low<high){
            long mid=low+(high-low)/2;
            int subArray=1;
            long sum=0;
            for(int i=0;i<n;i++){
                if(sum+a[i]<=mid){
                    sum+=a[i];
                }
                else{
                    sum=a[i];
                    subArray++;
                }                
            }
            if(subArray<=k){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        pw.print(low);

        pw.flush();
        pw.close();
    }
}