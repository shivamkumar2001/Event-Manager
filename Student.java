import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;

public class Student extends Frame implements ActionListener,ItemListener
{
 Dimension di =Toolkit.getDefaultToolkit().getScreenSize();
 JLabel lblimg = new JLabel(new ImageIcon("images/black.jpg"));
 JLabel lbhead = new JLabel("Student Details");
 JLabel lbre = new JLabel("Registration NO.");
 JLabel lbname = new JLabel("Name");
 JLabel lbgn = new JLabel("Gender");
 JComboBox comgn=new JComboBox();

 JLabel lbdb = new JLabel("Date of Birth");
 JLabel lbdp = new JLabel("Department");
 JLabel lbbch = new JLabel("Batch");
 JLabel lbemail = new JLabel("Email ID");
 JLabel lbphn = new JLabel("Phone No."); 
 JLabel lbad = new JLabel("Address");
 JTextField txt=new JTextField();
 JButton btn= new JButton("OK");
 
 JTextField txtrg = new JTextField();
 JTextField txtname = new JTextField(); 
 JTextField txtgn = new JTextField();
 JTextField txtdob=new JTextField();

 JComboBox comdpart = new JComboBox();
 JTextField txtbch = new JTextField(); 
 JTextField txtemail = new JTextField();
 JTextField txtphn=new JTextField();
 JTextField txtadd = new JTextField();
 JButton btnew = new JButton(new ImageIcon("images/im/btnn.jpg"));
 JButton btsave = new JButton(new ImageIcon("images/im/btnss.jpg"));
 JButton btser = new JButton(new ImageIcon("images/im/btns.jpg"));
 JButton btedit = new JButton(new ImageIcon("images/im/btne.jpg"));
 JButton btcan = new JButton(new ImageIcon("images/im/btnc.jpg"));
 
 public Student()
 {
	 setTitle("Student Form");
	 setLocation((int)(di.getWidth()/2)-550,(int)(di.getHeight()/2)-530);
	// getContentPane().setBackground(Color.WHITE);
  setLayout(null);
  setVisible(true);
  setSize(1000,1000);
   setBackground(new Color(0,0,0));
  setResizable(false);
  lbhead.setBounds(300,50,500,40);
  lbre.setBounds(30,170,200,20);
   lblimg.setBounds(-2,-100,1000,1000);
  txtrg.setBounds(300,160,150,35);
 
  lbname.setBounds(30,220,200,40);
  txtname.setBounds(300,230,250,35);
  
  lbgn.setBounds(30,290,200,40);
  comgn.setBounds(300,290,100,35);
 
  lbdb.setBounds(30,360,200,40);
  txtdob.setBounds(300,360,150,35);
 
  lbdp.setBounds(30,430,200,40);
  comdpart.setBounds(300,430,100,30);
  txt.setBounds(450,430,80,30);
  btn.setBounds(600,430,80,30);

  lbbch.setBounds(30,500,200,40);
  txtbch.setBounds(300,500,150,35);

  lbemail.setBounds(30,570,200,40);
  txtemail.setBounds(300,570,250,35);

  lbphn.setBounds(30,640,200,40);
  txtphn.setBounds(300,640,200,35);
 
  lbad.setBounds(30,710,200,40);
  txtadd.setBounds(300,710,230,35);
   
  btnew.setBounds(50,820,150,60);
  btsave.setBounds(240,820,150,60);
  btser.setBounds(410,820,150,60);
  btedit.setBounds(580,820,150,60);
  btcan.setBounds(750,820,150,60);
  txtrg.setEditable(false);
  txt.setVisible(false);
  btn.setVisible(false);
  Font f1 = new Font("Algerian",Font.BOLD,50);
  lbhead.setForeground(new Color(100,0,60));
  lbhead.setFont(f1);
  comgn.addItem("Select");
  comgn.addItem("Male");
  comgn.addItem("Female");
  comgn.addItem("Others");

  comdpart.addItem("--Select--");
  comdpart.addItem("CSE");
  comdpart.addItem("ECE");
  comdpart.addItem("EEE");
  comdpart.addItem("Civil");
  comdpart.addItem("Mechanical");
  comdpart.addItem("Chemical Engineering");
  comdpart.addItem("Others");
  btsave.setEnabled(false);
  btedit.setEnabled(false);
  add(lbhead);
  add(lbre);
  add(lbname);
  add(txtrg);
  add(txtname);
  add(comdpart);
  add(comgn);
  //add(lblimg);
  lbre.setForeground(Color.WHITE);
  lbbch.setForeground(Color.WHITE);
  lbdb.setForeground(Color.WHITE);
  lbemail.setForeground(Color.WHITE);
  lbgn.setForeground(Color.WHITE);
  lbname.setForeground(Color.WHITE);
  lbphn.setForeground(Color.WHITE);
  lbdp.setForeground(Color.WHITE);
  lbad.setForeground(Color.WHITE);
  Font f5 = new Font("Californian FB",Font.BOLD,20);
  lbre.setFont(f5);
  lbad.setFont(f5);
  lbbch.setFont(f5);
//lbdp.setFont(f5);
lbdp.setFont(f5);
lbemail.setFont(f5);
lbname.setFont(f5);
lbphn.setFont(f5);
lbgn.setFont(f5);
lbdb.setFont(f5);
txtrg.setFont(new Font("Arial",Font.PLAIN,18));
txtbch.setFont(new Font("Arial",Font.PLAIN,18));
txtdob.setFont(new Font("Arial",Font.PLAIN,18));
txtemail.setFont(new Font("Arial",Font.PLAIN,18));
txtgn.setFont(new Font("Arial",Font.PLAIN,18));
txtname.setFont(new Font("Arial",Font.PLAIN,18));
txtadd.setFont(new Font("Arial",Font.PLAIN,18));
txtphn.setFont(new Font("Arial",Font.PLAIN,18));
txt.setFont(new Font("Arial",Font.PLAIN,18));
lbhead.setForeground(new Color(204,0,102));
  add(lbgn);
  add(lbdb);
  add(txtdob);
  add(lbbch);
  add(txtbch);
  add(lbdp);
  add(lbemail);
  add(txtemail);
  add(lbphn);
  add(txtphn);
  add(lbad);
  add(txtadd);
  add(btnew);
  add(btsave);
  add(btser);
  add(btedit);
  add(btcan);
  add(btn);
  add(txt);
  comdpart.addItemListener(this);
  btn.addActionListener(this);
  btnew.addActionListener(this);
  btsave.addActionListener(this);
  btser.addActionListener(this);
  btedit.addActionListener(this);
  btcan.addActionListener(this);

repaint(); 
}    
 public void itemStateChanged(ItemEvent ie)
 {
     txt.setVisible(false);
     btn.setVisible(false);
  if(comdpart.getSelectedItem()==("Others"))
   {
    txt.setVisible(true);
    btn.setVisible(true);
   }
   }
 public void actionPerformed(ActionEvent e)
 {
 if(e.getSource()==btn)
  {
    comdpart.addItem(txt.getText());
  }

  if(e.getSource() == btnew)
  {
	btsave.setEnabled(true);
   txtrg.setText("");
   txtname.setText("");
   txtdob.setText("");
   txtbch.setText("");
   txtemail.setText("");
   txtphn.setText("");
   txtadd.setText("");

   try
   {
   Connection con1 = DriverManager.getConnection("jdbc:odbc:eventdsn");
   Statement st = con1.createStatement();
   String str1 = "insert into studenttbl(REGISTRATIONNO,sNAME,GENDER,DATEOFBIRTH,DEPARTMENT,BATCH,EMAILID,PHNNO,ADDRESS)values(?,?,?,?,?,?,?,?,?)";
   ResultSet res1 = st.executeQuery("select * from keytable");
   while(res1.next())
   {
    txtrg.setText("E/" + res1.getString(3));
    comdpart.setSelectedItem("--Select--");
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
	  btsave.setEnabled(false);
   if(txtname.getText().length()!=0 && txtrg.getText().length()!=0 && txtdob.getText().length()!=0 && txtemail.getText().length()!=0 && txtphn.getText().length()!=0 && txtadd.getText().length()!=0)
{
try
{
   Connection con = DriverManager.getConnection("jdbc:odbc:eventdsn");
   String str = "insert into studenttbl(REGISTRATIONNO,SNAME,GENDER,DATEOFBIRTH,DEPARTMENT,BATCH,EMAILID,PHNNO,ADDRESS)values(?,?,?,?,?,?,?,?,?)";
   PreparedStatement ps = con.prepareStatement(str);

   ps.setString(1,txtrg.getText());
   ps.setString(2,txtname.getText());
   ps.setString(3,""+comgn.getSelectedItem());
   ps.setString(4,txtdob.getText());
   ps.setString(5,""+comdpart.getSelectedItem());
   ps.setString(6,txtbch.getText());
   ps.setString(7,txtemail.getText());
   ps.setString(8,txtphn.getText());
   ps.setString(9,txtadd.getText());
   ps.executeUpdate();
   Statement st = con.createStatement();
   str = "update keytable set REGISTRATIONNO=REGISTRATIONNO+1";
   st.executeUpdate(str);
   JOptionPane.showMessageDialog(null,"SAVED");
   con.close();
}  
catch(Exception ee)
{
System.out.println(ee);
}
}
else 
JOptionPane.showMessageDialog(null,"Empty Field Cannot be Saved");
}
  if(e.getSource() == btser)
  {
	  btedit.setEnabled(true);
try
{ 
    Connection con = DriverManager.getConnection("jdbc:odbc:eventdsn");
    Statement st = con.createStatement();
    String s=JOptionPane.showInputDialog(null,"Enter Event Id");  
    ResultSet res = st.executeQuery("select * from Studenttbl where REGISTRATIONNO='"+s+"'");
    while(res.next())
    {
     txtrg.setText(res.getString(1));
     txtname.setText(res.getString(2));
     comgn.setSelectedItem(res.getString(3));
     txtdob.setText(res.getString(4));
     comdpart.setSelectedItem(res.getString(5));
     txtbch.setText(res.getString(6));
     txtemail.setText(res.getString(7)); 
     txtphn.setText(res.getString(8));
     txtadd.setText(res.getString(9));
                  
    }
	con.close();
}
catch(Exception ee)
{
System.out.println(ee);
}
   }
  if(e.getSource() == btedit)
  { 
    btedit.setEnabled(false);
      if(txtname.getText().length()!=0 && txtrg.getText().length()!=0 && txtdob.getText().length()!=0 && txtemail.getText().length()!=0 && txtphn.getText().length()!=0 && txtadd.getText().length()!=0)
	{
  try
  {
    Connection con = DriverManager.getConnection("jdbc:odbc:eventdsn");
    Statement st = con.createStatement();
    String Str="Update studenttbl set sName='"+txtname.getText()+"',gender='"+comgn.getSelectedItem()+"',dateofbirth='"+txtdob.getText()+"',department='"+comdpart.getSelectedItem()+"',batch='"+txtbch.getText()+"',emailid='"+txtemail.getText()+"',phnno='"+txtphn.getText()+"',address='"+txtadd.getText()+"' where registrationno='"+txtrg.getText()+"'";
    st.executeUpdate(Str);
    JOptionPane.showMessageDialog(null,"Edited");
	con.close();
  } 
  catch(Exception ee)
 {
  System.out.println(ee);
  }
}
else 
JOptionPane.showMessageDialog(null,"Empty Field Cannot be Searched");	
  } 
  if(e.getSource() == btcan)
  {
   this.dispose();
  }
 }
 public static void main(String args[])
 {
 Student sp = new Student();
 }
}