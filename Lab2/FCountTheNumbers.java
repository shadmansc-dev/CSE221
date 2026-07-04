import java.io.*;
import java.util.*;

public class FCountTheNumbers {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int [] arr=new int[n];
        int q=Integer.parseInt(st.nextToken());
        st =new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        while(q-->0){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int start=getLeftIndex(arr,x);
            int end=getRightIndex(arr,y);
            int counter=(end-start)+1;
            pw.println(counter);
        }
        pw.flush();
        pw.close();
    }
    public static int getLeftIndex(int[]arr,int key){
        int l=0,r=arr.length-1,result=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]>=key){
                result=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return result;
    }
    public static int getRightIndex(int[]arr,int key){
        int l=0,r=arr.length-1,result=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]<=key){
                result=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return result;
    }
}