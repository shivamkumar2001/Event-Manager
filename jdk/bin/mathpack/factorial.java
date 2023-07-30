package mathpack;
public class factorial
{
     public void fact(int n)
       {
              int i,f=1;
	for(i=1;i<=n;i++)
	{
		f=f*i;
	}
	System.out.print("Factorial is="+f);
       }
}