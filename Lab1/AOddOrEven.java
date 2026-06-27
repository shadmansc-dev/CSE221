import java.io.*;
public class AOddOrEven{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T =Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            int N=Integer.parseInt(br.readLine());
            if(N%2==0){
                out.println(N+" is an Even number.");
            }
            else{
                out.println(N+" is an Odd number.");
            }
        }
        out.flush();
    }
}
