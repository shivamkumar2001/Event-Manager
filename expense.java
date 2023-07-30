import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;
public class expense extends JFrame implements ActionListener
{
 Dimension di =Toolkit.getDefaultToolkit().getScreenSize();
 JLabel lbhead = new JLabel("EXPENSE");
 JLabel lbexid = new JLabel("EXPENSE ID");
 JLabel lbexfor = new JLabel("EXPENSE FOR");
 JLabel lbexpd = new JLabel("EXPENSE TO");
 JLabel lbexdes = new JLabel("DESCRIPTION");
 JLabel lbexamt = new JLabel("AMOUNT");
 JLabel lbexdt = new JLabel("EXPENSE DATE");
 JTextField exid = new JTextField();
 JTextField exfor = new JTextField(); 
 JTextField expd = new JTextField();
 JTextField exdes = new JTextField();
 JTextField examt = new JTextField();
 JTextField exdt = new JTextField();
 JButton btnew = new JButton("NEW");
 JButton btsave = new JButton("SAVE");
 JButton btser = new JButton("SEARCH");
 JButton btedit = new JButton("EDIT");
 JButton btcan = new JButton("CANCEL");
 public expense()
 {
  setLayout(null);
  setVisible(true);
  setSize(1000,1000);
  setLocation((int)(di.getWidth()/2)-550,(int)(di.getHeight()/2)-530);
  lbhead.setBounds(300,20,300,40);
  lbexid.setBounds(20,125,150,20);
  exid.setBounds(220,120,100,40);
  lbexfor.setBounds(20,185,150,20);
  exfor.setBounds(220,180,200,40);
  lbexpd.setBounds(20,245,100,20);
  expd.setBounds(220,240,220,40);
  lbexdes.setBounds(20,305,100,20);
  exdes.setBounds(220,300,200,40);
  lbexamt.setBounds(20,365,250,20);
  examt.setBounds(220,360,220,40);
  lbexdt.setBounds(20,425,200,20);
  exdt.setBounds(220,420,220,40);
 // lbchg.setBounds(20,425,250,20);
 // txtchn.setBounds(220,420,170,40);
 //lbrem.setBounds(20,485,200,20);
 //txtrem.setBounds(220,480,200,40);
  btnew.setBounds(100,700,140,40);
  btsave.setBounds(250,700,140,40);
  btser.setBounds(400,700,140,40);
  btedit.setBounds(550,700,140,40);
  btcan.setBounds(700,700,140,40);
  exid.setEditable(false);
  Font f1 = new Font("Imprint MT Shadow",Font.BOLD,30);
  Font f2 = new Font("Californian FB",Font.BOLD,18);
  lbexid.setFont(f2);
  lbexfor.setFont(f2);
  lbexpd.setFont(f2);
  lbexdes.setFont(f2);
  lbexamt.setFont(f2);
  lbhead.setForeground(new Color(100,0,60));
  lbhead.setFont(f1);
  add(lbhead);
  add(lbexid);
  add(lbexfor);
  add(lbexdt);
  add(lbexpd);
  add(lbexdes);
  add(lbexamt);
  add(examt);
  add(exdes);
  add(exfor);
  add(exid);
  add(exdt);
  add(expd);
  add(btnew);
  add(btsave);
  add(btser);
  add(btedit);
  add(btcan);
  
  btnew.addActionListener(this);
  btsave.addActionListener(this);
  btser.addActionListener(this);
  btedit.addActionListener(this);
  btcan.addActionListener(this);
 }
 public void actionPerformed(ActionEvent e)
 {
  if(e.getSource() == btnew)
  {
   exid.setText("");
   exfor.setText("");
   expd.setText("");
   exdes.setText("");
   examt.setText("");
   exdt.setText("");
   try
   {
   Connection con1 = DriverManager.getConnection("jdbc:odbc:eventdsn");
   Statement st = con1.createStatement();
   ResultSet res1 = st.executeQuery("select * from keytable");
   while(res1.next())
   {
    exid.setText("EX/" + res1.getString(7));
    }
	con1.close();
   }
   catch(Exception ee)
   {
       System.out.println(ee);
   }
  }
  if(e.getSource() == btsave)
  {
try
{
   Connection con = DriverManager.getConnection("jdbc:odbc:eventdsn");
   String str = "insert into expensetbl(EXPENSEID,EXPENSEFOR,EXPENSETO,DESCRIPTION,AMOUNT,EXPENSEDATE)values(?,?,?,?,?,?)";
   PreparedStatement ps = con.prepareStatement(str);

   ps.setString(1,exid.getText());
   ps.setString(2,exfor.getText());
   ps.setString(3,expd.getText());
   ps.setString(4,exdes.getText());
   ps.setString(5,examt.getText());
   ps.setString(6,exdt.getText());
   ps.executeUpdate();
   Statement st = con.createStatement();
   str = "update keytable set expenseid=expenseid+1";
   st.executeUpdate(str);
   JOptionPane.showMessageDialog(null,"SAVED");
  }
catch(Exception ee)
{
System.out.println(ee);
}
}
  if(e.getSource() == btser)
  {
try
{ 
    Connection con = DriverManager.getConnection("jdbc:odbc:eventdsn");
    Statement st = con.createStatement();
    String s=JOptionPane.showInputDialog(null,"Enter Event Id");
    ResultSet res = st.executeQuery("select * from expensetbl where expenseid='"+s+"'");
    while(res.next())
    {
     exid.setText(res.getString(1));
     exfor.setText(res.getString(2));
     expd.setText(res.getString(3));
     exdes.setText(res.getString(4));
     examt.setText(res.getString(5));
	 exdt.setText(res.getString(6));
    }
}
catch(Exception ee)
{
System.out.println(ee);
}
   }
  if(e.getSource() == btedit)
  { 
try
{
    Connection con = DriverManager.getConnection("jdbc:odbc:eventdsn");
    Statement st = con.createStatement();
    String Str="Update expenseid set expensefor='"+exfor.getText()+"',expenseto='"+expd.getText()+"',description='"+exdes.getText()+"',amount='"+examt.getText()+"'expensedate='"+exdt.getText()+"',where expenseid='"+exid.getText()+"'";
    st.executeUpdate(Str);
    JOptionPane.showMessageDialog(null,"Edited");
  } 
  catch(Exception ee)
{
System.out.println(ee);
}
}
  if(e.getSource() == btcan)
  {
   this.dispose();
  }
 }
 public static void main(String args[])
 {
 expense ob = new expense();
 }
}