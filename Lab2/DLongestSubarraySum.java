import java.io.*;
import java.util.*;

public class DLongestSubarraySum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int l=0,r=0;
        int sum=0,max_len=0;
        while(r<n){            
            if(sum+arr[r]<=k){
                sum+=arr[r++];
                if(r-l>max_len){
                    max_len=r-l;
                }
            }
            else {
                if (l == r) {
                    r++;
                    l++;
                } 
                else {
                    sum -= arr[l];
                    l++;
                }
            }
        }
        pw.print(max_len);

        pw.flush();
        pw.close();
    }
}