import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
public class todayexpense extends JFrame implements ActionListener
{
JLabel lbhead = new JLabel("Today's Expense");
JLabel lbdate = new JLabel("Today's Date");
JTextField txtdate = new JTextField();
JButton btda = new JButton("OK");                                                                 
Dimension d1 = Toolkit.getDefaultToolkit().getScreenSize();
public todayexpense()
{
  setLayout(null);
  setVisible(true);
  int x = (int)d1.getWidth();
  int y = (int)d1.getHeight();
  setResizable(false);
  setSize(x,y);
  lbhead.setBounds(550,20,400,60);
  lbdate.setBounds(450,200,220,30);
  txtdate.setBounds(680,200,150,30);
  btda.setBounds(680,280,100,25);
  Font f1 = new Font("Monotype Corsiva",Font.BOLD,36);
  lbhead.setForeground(new Color(100,0,60));
  lbhead.setFont(f1);
  Font f2 = new Font("Monotype Corsiva",Font.BOLD,20);
  Font f3 = new Font("Berlin Sans FB",Font.PLAIN,18);
  lbdate.setFont(f2);
  txtdate.setFont(f3);
  btda.setFont(f2);
  btda.setBackground(new Color(100,0,50));
  btda.setForeground(new Color(200,250,150));
  add(lbdate);
  add(lbhead);
  add(txtdate);
  add(btda);
  btda.addActionListener(this);
  repaint();
  }   
   public void actionPerformed(ActionEvent ae)
    {
          if(ae.getSource()==btda)
 {
 try
         {
                 Connection con1 = DriverManager.getConnection("jdbc:odbc:eventdsn");
                 Statement st=con1.createStatement();
                 ResultSet res1=st.executeQuery("Select * from expensetbl where expensedate='"+txtdate.getText()+"'");
				 PrintWriter pw=new PrintWriter("todayexpensereport.txt");
                 pw.println("Today's Date :- "+txtdate.getText()+" and Expense.....");
                 pw.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                 pw.println("Expense id         Expense For          Paid To          Description           Amount           Total");
                 pw.println("-----------------------------------------------------------------------------------------------");
				 double s=0.0,x=0.0;
                 while(res1.next())
                 {
					 x=Double.parseDouble(res1.getString(5));
                     pw.printf("%-20s",res1.getString(1));
                     pw.printf("%-20s",res1.getString(2));
					 pw.printf("%-20s",res1.getString(3));
					 pw.printf("%-20s",res1.getString(4));
                     pw.printf("%-20s",x);
                     pw.printf("\n");
					 s=s+x;
					
                 }
				  pw.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
pw.printf("%8s",s);
pw.println();
pw.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
pw.println();
pw.close();
Runtime rt=Runtime.getRuntime();
                 rt.exec("notepad.exe todayexpensereport.txt");
    con1.close();
}

            
            catch(Exception e)
            {
                  System.out.println(e);
            }
         }
	}
   public static void main(String args[])
   {
         todayexpense sp = new todayexpense();
   }
}