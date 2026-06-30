import java.io.*;
import java.util.*;

public class CABeautifulSortedList {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int arr1[]=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr1[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        int m=Integer.parseInt(st.nextToken());
        int arr2[]=new int[m];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            arr2[i]=Integer.parseInt(st.nextToken());
        }
        int [] mergeAray=new int[n+m];
        int p1=0;
        int p2=0;
        int current=0;
        for(int i=0;i<n+m;i++){
            if(p1<n && p2<m){
                if(arr1[p1]>arr2[p2]){
                    mergeAray[i]=arr2[p2++];

                }
                else{
                    mergeAray[i]=arr1[p1++];
                }
            }
            else{
                current=i;
                break;
            }
        }
        while(p1<n){
            mergeAray[current++]=arr1[p1++];
        }
        while(p2<m){
            mergeAray[current++]=arr2[p2++];
        }
        for(int i=0;i<n+m;i++){
            pw.print(mergeAray[i]+" ");
        }

        pw.flush();
        pw.close();
    }
}