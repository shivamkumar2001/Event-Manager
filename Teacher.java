import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;
public class Teacher extends Frame implements ActionListener,ItemListener
{   
	JPanel pnl = new JPanel();
	JLabel lblimg = new JLabel(new ImageIcon("images/black.jpg"));
 JLabel lbhead = new JLabel("TEACHER DETAILS");
 JLabel lbre = new JLabel("Staff ID.");
 JLabel lbname = new JLabel("Name");
 JLabel lbgn = new JLabel("Gender");
 JComboBox comgn=new JComboBox();

 JLabel lbdj = new JLabel("Date of Joining");
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
 JTextField txtdoj=new JTextField();

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
 Dimension d1 = Toolkit.getDefaultToolkit().getScreenSize();
 public Teacher()
 {
  setLayout(null);
  setTitle("Teacher Form");
  setVisible(true);
  setLocation((int)(d1.getWidth()/2)-550,(int)(d1.getHeight()/2)-530);
  setResizable(false);
  setBackground(new Color(0,0,0));
  setSize(1000,1000);
  lblimg.setBounds(-2,-100,1000,1000);
  pnl.setBounds(-2,-100,1000,1000);
  lbhead.setBounds(330,70,430,40);
  lbre.setBounds(20,175,100,20);
  txtrg.setBounds(200,170,100,40);
 
  lbname.setBounds(20,235,100,20);
  txtname.setBounds(200,230,200,40);
  
  lbgn.setBounds(20,295,100,20);
  comgn.setBounds(200,290,100,40);
 
  lbdj.setBounds(20,355,150,20);
  txtdoj.setBounds(200,350,150,40);
 
  lbdp.setBounds(20,415,100,20);
  comdpart.setBounds(200,410,100,40);
  txt.setBounds(650,410,80,40);
  btn.setBounds(655,410,80,40);

  lbbch.setBounds(20,475,100,20);
  txtbch.setBounds(200,470,150,40);

  lbemail.setBounds(20,535,100,20);
  txtemail.setBounds(200,530,250,40);

  lbphn.setBounds(20,595,100,20);
  txtphn.setBounds(200,590,220,40);
 
  lbad.setBounds(20,655,100,20);
  txtadd.setBounds(200,650,250,40);
   
  btnew.setBounds(40,750,150,60);
  btsave.setBounds(230,750,150,60);
  btser.setBounds(410,750,150,60);
  btedit.setBounds(580,750,150,60);
  btcan.setBounds(750,750,150,60);
  Font f1 = new Font("Imprint MT Shadow",Font.BOLD,35);
  Font f2 = new Font("Californian FB",Font.BOLD,18);
  Font f3 = new Font("Berlin Sans FB",Font.PLAIN,16);
  lbhead.setForeground(new Color(100,0,60));
  //.setForeground(Color.WHITE);
  
  lbhead.setFont(f1);
  lbre.setFont(f2);
  lbname.setFont(f2);
  lbgn.setFont(f2);
  lbdj.setFont(f2);
  lbdp.setFont(f2);
  lbbch.setFont(f2);
  lbemail.setFont(f2);
  lbphn.setFont(f2);
  lbad.setFont(f2);
  btnew.setFont(f2);
  btsave.setFont(f2);
  btser.setFont(f2);
  btedit.setFont(f2);
  btcan.setFont(f2);
  txtadd.setFont(f3);
  txtbch.setFont(f3);
  txtdoj.setFont(f3);
  txtemail.setFont(f3);
  txtname.setFont(f3);
  txtphn.setFont(f3);
  txtrg.setFont(f3);
  
  lbad.setForeground(Color.WHITE);
  lbbch.setForeground(Color.WHITE);
  lbre.setForeground(Color.WHITE);
  lbdj.setForeground(Color.WHITE);
  lbemail.setForeground(Color.WHITE);
  lbgn.setForeground(Color.WHITE);
  lbhead.setForeground(Color.WHITE);
  lbname.setForeground(Color.WHITE);
  lbphn.setForeground(Color.WHITE);
  txtrg.setEditable(false);
  txt.setVisible(false);
  btn.setVisible(false);
  //Font f1 = new Font("Monotype Corsiva",Font.BOLD,30);
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

  add(lbgn);
  add(lbdj);
  add(txtdoj);
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
 // pnl.add(lblimg);
  //add(lblimg);
  
  lbhead.setForeground(new Color(255,192,0));
  
  
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
   txtdoj.setText("");
   txtbch.setText("");
   txtemail.setText("");
   txtphn.setText("");
   txtadd.setText("");

   
   try
   {
   Connection con1 = DriverManager.getConnection("jdbc:odbc:eventdsn");
   Statement st = con1.createStatement();
   String str1 = "insert into teachertbl(STAFFID,sNAME,GENDER,DATEOFJOINING,DEPARTMENT,BATCH,EMAILID,PHNNO,ADDRESS)values(?,?,?,?,?,?,?,?,?)";
   ResultSet res1 = st.executeQuery("select * from keytable");
   while(res1.next())
   {
    txtrg.setText("T/" + res1.getString(5));
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
   if(txtname.getText().length()!=0 && txtrg.getText().length()!=0 && txtdoj.getText().length()!=0 && txtemail.getText().length()!=0 && txtphn.getText().length()!=0 && txtadd.getText().length()!=0)
{
try
{
   Connection con = DriverManager.getConnection("jdbc:odbc:eventdsn");
   String str = "insert into teachertbl(STAFFID,SNAME,GENDER,DATEOFJOINING,DEPARTMENT,BATCH,EMAILID,PHNNO,ADDRESS)values(?,?,?,?,?,?,?,?,?)";
   PreparedStatement ps = con.prepareStatement(str);

   ps.setString(1,txtrg.getText());
   ps.setString(2,txtname.getText());
   ps.setString(3,""+comgn.getSelectedItem());
   ps.setString(4,txtdoj.getText());
   ps.setString(5,""+comdpart.getSelectedItem());
   ps.setString(6,txtbch.getText());
   ps.setString(7,txtemail.getText());
   ps.setString(8,txtphn.getText());
   ps.setString(9,txtadd.getText());
   ps.executeUpdate();
   Statement st = con.createStatement();
   str = "update keytable set STAFFID=STAFFID+1";
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
    ResultSet res = st.executeQuery("select * from teachertbl where staffid='"+s+"'");
    while(res.next())
    {
		
		
     txtrg.setText(res.getString(1));
     txtname.setText(res.getString(2));
     comgn.setSelectedItem(res.getString(3));
     txtdoj.setText(res.getString(4));
     comdpart.setSelectedItem(res.getString(5));
     txtbch.setText(res.getString(6));
     txtemail.setText(res.getString(7)); 
     txtphn.setText(res.getString(8));
     txtadd.setText(res.getString(9));
    // txt.setText(res.getString(10));
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
      if(txtname.getText().length()!=0 && txtrg.getText().length()!=0 && txtdoj.getText().length()!=0 && txtemail.getText().length()!=0 && txtphn.getText().length()!=0 && txtadd.getText().length()!=0)
{
  try
  {
    Connection con = DriverManager.getConnection("jdbc:odbc:eventdsn");
    Statement st = con.createStatement();
    String Str="update teachertbl set sName='"+txtname.getText()+"',gender='"+comgn.getSelectedItem()+"',dateofjoining='"+txtdoj.getText()+"',department='"+comdpart.getSelectedItem()+"',batch='"+txtbch.getText()+"',emailid='"+txtemail.getText()+"',phnno='"+txtphn.getText()+"',address='"+txtadd.getText()+"' where staffid='"+txtrg.getText()+"'";
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
 Teacher tp = new Teacher();
 }
}