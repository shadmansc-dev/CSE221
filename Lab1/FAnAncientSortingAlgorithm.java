import java.util.*;
import java.io.*;
/**
 * FAnAncientSortingAlgorithm
 */
public class FAnAncientSortingAlgorithm {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int arr[]=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){        
            arr[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if((arr[j]%2==0 && arr[j+1]%2==0)||(arr[j]%2!=0 && arr[j+1]%2!=0)){
                    if(arr[j]>arr[j+1]){
                        int temp=arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=temp;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            pw.print(arr[i]+" ");
        }
        pw.close();
    }
}