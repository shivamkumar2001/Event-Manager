package mathpack;
import java.io.*;
public class mathclass
{
int i,f=1;
public int factfun(int num)throws IOException
 {
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 System.out.println("Enter the number:");
 num=Integer.parseInt(br.readLine());
         for(i=1;i<=num;i++)
		 {
		 f=f*i;
         }
		 return(f);
 }
}