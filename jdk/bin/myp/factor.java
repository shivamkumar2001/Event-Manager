package myp;
public class factor
{
       public void facto(int n)
      {
             int f=1,i;
            for(i=1;i<=n;i++)
            {
	f=f*i;
            }
        System.out.print("Factorial="+f);
      }
}