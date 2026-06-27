import java.io.*;
public class BCalculator{
    public static void main(String args[]) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);
        int T= Integer.parseInt(br.readLine());
        while(T-->0){
            String str= br.readLine();
            String [] arr=str.split(" ");
            int a=Integer.parseInt(arr[1]);
            int b=Integer.parseInt(arr[3]);
            String op=arr[2];

            if (op.equals("/")) {
                out.printf("%.10f%n", (double)a / b);
            }
            else if (op.equals("+")) out.println(a + b);
            else if (op.equals("-")) out.println(a - b);
            else if (op.equals("*")) out.println(a * b);
            else if (op.equals("%")) out.println(a % b);
            else if (op.equals("&")) out.println(a & b);
            else if (op.equals("|")) out.println(a | b);
            else if (op.equals("^")) out.println(a ^ b);
            else if (op.equals("<<")) out.println((long)a << b);
            else if (op.equals(">>")) out.println((long)a >> b);
        }
        out.flush();
    }

}