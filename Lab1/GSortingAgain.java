import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.io.*;
/**
 * GSortingAgain
 */
public class GSortingAgain {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int t=Integer.parseInt(st.nextToken());
        while(t-->0){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int []id=new int[n];
            int[]marks=new int[n];
            st=new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                id[i]=Integer.parseInt(st.nextToken());
            }
            st=new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                marks[i]=Integer.parseInt(st.nextToken());
            }
            int count=0;
            for(int i=0;i<n-1;i++){
                int min=i;
                for(int j=i+1;j<n;j++){
                    if(marks[j]>marks[min]){
                        min=j;
                    }
                    else if(marks[j]==marks[min]){
                        if(id[j]<id[min]){
                            min=j;
                        }
                    }
                }
                if(min!=i){
                    count++;
                    int temp=marks[min];
                    int temp1=id[min];
                    marks[min]=marks[i];
                    id[min]=id[i];
                    marks[i]=temp;
                    id[i]=temp1;
                }
            }
            pw.println("Minimum swaps: "+count);
            for(int i=0;i<n;i++){
                pw.println("ID: "+id[i] +" Mark: "+marks[i]);
            }
        }

        pw.close();
    }
}