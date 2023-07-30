import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;
public class Venue extends Frame implements ActionListener
{
 Dimension di =Toolkit.getDefaultToolkit().getScreenSize();
 JLabel lbhead = new JLabel("VENUE   DETAILS");
 JLabel lbveid = new JLabel("VENUE ID");
 JLabel lbna = new JLabel("VENUE  NAME");
 JLabel lbadd = new JLabel("ADDRESS");
 JLabel lbcod = new JLabel("CONTACT  DETAILS:-");
 JLabel lbcon = new JLabel("CONTACT  NUMBER");
 JLabel lbfac = new JLabel("FACILITIES");
 JLabel lbchg = new JLabel("CHARGES");
 JLabel lbrem = new JLabel("REMARKS");
 JTextField txtid = new JTextField();
 JTextField txtna = new JTextField(); 
 JTextField txtadd = new JTextField();
 JTextField txtcon = new JTextField();
 JTextField txtfac = new JTextField();
 JTextField txtchn =new JTextField();
 JTextField txtrem =new JTextField();
 JButton btnew = new JButton(new ImageIcon("images/im/btnn.jpg"));
 JButton btsave = new JButton(new ImageIcon("images/im/btnss.jpg"));
 JButton btser = new JButton(new ImageIcon("images/im/btns.jpg"));
 JButton btedit = new JButton(new ImageIcon("images/im/btne.jpg"));
 JButton btcan = new JButton(new ImageIcon("images/im/btnc.jpg"));
 public Venue()
 {
  setLayout(null);
  setVisible(true);
  setTitle("Venue Form");
  setResizable(false);
  setSize(1000,850);
  setLocation((int)(di.getWidth()/2)-500,(int)(di.getHeight()/2)-425);
  setBackground(new Color(0,0,0));
  lbhead.setBounds(280,50,450,60);
  lbveid.setBounds(260,170,180,30);
  txtid.setBounds(600,160,100,40);
  lbna.setBounds(260,240,180,30);
  txtna.setBounds(600,230,150,40);
  lbfac.setBounds(260,300,150,30);
  txtfac.setBounds(600,300,220,40);
  lbchg.setBounds(260,370,150,30);
  txtchn.setBounds(600,370,200,40);
  lbcod.setBounds(260,450,250,30);
  lbcon.setBounds(260,520,250,30);
  txtcon.setBounds(600,510,140,40);
  
  lbadd.setBounds(260,590,250,30);
  txtadd.setBounds(600,580,220,40);
  //lbchg.setBounds(260,480,250,30);
  //txtchn.setBounds(600,510,170,40);
  lbrem.setBounds(260,660,200,30);
  txtrem.setBounds(600,650,140,40);
  btnew.setBounds(100,740,140,40);
  btsave.setBounds(280,740,140,40);
  btser.setBounds(460,740,140,40);
  btedit.setBounds(640,740,140,40);
  btcan.setBounds(820,740,150,40);
  txtid.setEditable(false);
  Font f1 = new Font("Imprint MT Shadow",Font.BOLD,45);
  Font f2 = new Font("Californian FB",Font.BOLD,25);
  lbadd.setFont(f2);
  lbchg.setFont(f2);
  lbcon.setFont(f2);
  lbfac.setFont(f2);
  lbcod.setFont(f2);
  lbna.setFont(f2);
  lbrem.setFont(f2);
  lbveid.setFont(f2);
  lbhead.setForeground(new Color(255,192,0));
  lbhead.setFont(f1);
  lbadd.setForeground(Color.WHITE);
  lbchg.setForeground(Color.WHITE);
  lbcon.setForeground(Color.WHITE);
  lbfac.setForeground(Color.WHITE);
  lbcod.setForeground(Color.WHITE);
  lbna.setForeground(Color.WHITE);
  lbrem.setForeground(Color.WHITE);
  lbveid.setForeground(Color.WHITE);
  add(lbhead);
  add(lbveid);
  add(txtid);
  add(lbna);
  add(txtna);
  add(lbadd);
  add(txtadd);
  add(lbcon);
  add(txtcon);
  add(lbcod);
  add(lbfac);
  add(txtfac);
  add(lbchg);
  add(txtchn);
  add(lbrem);
  add(txtrem);
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
   txtid.setText("");
   txtna.setText("");
   txtadd.setText("");
   txtcon.setText("");
   txtfac.setText("");
   txtchn.setText("");
   txtrem.setText("");
   try
   {
   Connection con1 = DriverManager.getConnection("jdbc:odbc:eventdsn");
   Statement st = con1.createStatement();
  // String str1 = "insert into venuetbl(VENUEID,VENUENAME,ADDRESS,CONTACT,FACILITIESPROVIDED,CHARGES,REMARKS1)values(?,?,?,?,?,?,?)";
   ResultSet res1 = st.executeQuery("select * from keytable");
   while(res1.next())
   {
    txtid.setText("V/" + res1.getString(6));
    }
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
   String str = "insert into venuetbl(VENUEID,VENUENAME,ADDRESS,CONTACT,FACILITIESPROVIDED,CHARGES,REMARKS1)values(?,?,?,?,?,?,?)";
   PreparedStatement ps = con.prepareStatement(str);

   ps.setString(1,txtid.getText());
   ps.setString(2,txtna.getText());
   ps.setString(3,txtadd.getText());
   ps.setString(4,txtcon.getText());
   ps.setString(5,txtfac.getText());
   ps.setString(6,txtchn.getText());
   ps.setString(7,txtrem.getText());
   ps.executeUpdate();
   Statement st = con.createStatement();
   str = "update keytable set venueid=venueid+1";
   st.executeUpdate(str);
   JOptionPane.showMessageDialog(null,"SAVED");
   con.close();
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
    String s=JOptionPane.showInputDialog(null,"Enter Venue Id");
    ResultSet res = st.executeQuery("select * from venuetbl where venueid='"+s+"'");
    while(res.next())
    {
     txtid.setText(res.getString(1));
     txtna.setText(res.getString(2));
     txtadd.setText(res.getString(3));
     txtcon.setText(res.getString(4));
     txtfac.setText(res.getString(5));
     txtchn.setText(res.getString(6));
     txtrem.setText(res.getString(7));
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
    String Str="Update venueid set venuename='"+txtna.getText()+"',address='"+txtadd.getText()+"',contact='"+txtcon.getText()+"',facilitiesprovided='"+txtfac.getText()+"',charges='"+txtchn.getText()+"',remarks='"+txtrem.getText()+"',where venueid='"+txtid.getText()+"'";
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
 Venue vp = new Venue();
 }
}