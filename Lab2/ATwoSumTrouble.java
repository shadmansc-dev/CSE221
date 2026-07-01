import java.io.*;
import java.util.*;

public class ATwoSumTrouble {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int [] arr=new int[n];
        int target=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        boolean flag=false;
        int l=0;
        int r=n-1;
        while (l<r) {
            if(arr[l]+arr[r]==target){
                flag=true;
                break;
            }
            else if(arr[l]+arr[r]>target){
                r--;
            }
            else{
                l++;
            }
        }
        if(flag){
            pw.print((l+1)+" "+(r+1));
        }
        else{
            pw.print(-1);
        }

        pw.flush();
        pw.close();
    }
}