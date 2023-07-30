import java.io.*;
class palin
{
public static void main(String arg[])throws IOException
{
InputStreamReader in=new InputStreamReader(System.in);
BufferedReader bf=new BufferedReader(in);
int num,sum,tnum,dig;
for(num=ll;num<=ul;num=tnum+1)
{
sum=0;
tnum=num;
   while(num>0)
     {
dig=num%10;
sum=sum*10+dig;
num=num/10;
}
if (sum==tnum)
System.out.println(tnum);
}
}
}
