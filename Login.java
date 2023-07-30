import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.sql.*;
import javax.swing.*;
public class Login extends JFrame implements ActionListener, FocusListener
{
 JButton btnok = new JButton(new ImageIcon("images/login.jpg"));
 JButton btnlog = new JButton(new ImageIcon("Images/logbtn.jpg"));
 JButton btncancel = new JButton (new ImageIcon("images/cancel.png"));
 JLabel lbusr = new JLabel ("USER");                                          
 JLabel lbpass = new JLabel ("PASSWORD");
 JTextField txtusr = new JTextField ();
 JTextField txtpass = new JTextField();
 JPasswordField txtpassd = new JPasswordField();
 JLabel img=new JLabel(new ImageIcon("images/login.jpg"));
 Dimension d1 = Toolkit.getDefaultToolkit().getScreenSize();
 public Login ()
 {
   setTitle("Login");
   img.setBounds(0,0,700,600);
   add(btnlog);
   txtusr.setText("Enter User Name");
   txtpass.setText("Enter Password");
   setLayout(null);
  setVisible(true);
  setSize(700,600);
  int x=(int)d1.getWidth()/2-300;
  int y=(int)d1.getHeight()/2-300;
  setResizable(false);
  this.setLocation(x,y);
  lbusr.setBounds(80,50,100,40);
  txtusr.setBounds(145,200,380,52);
  lbpass.setBounds(145,250,100,40);
  txtpass.setBounds(145,305,380,52);
  txtpass.setBackground(new Color(255,0,0));
  txtpassd.setBounds(145,305,380,52);
  btnlog.setBounds(170,440,340,40);
  btnok.setBounds(170,357,150,40);
  btncancel.setBounds(335,357,156,40);
  Font f2 = new Font("Lucida Bright",Font.BOLD,25);
  lbusr.setFont(f2);
  lbpass.setFont(f2);
  btnok.setFont(f2);
  btncancel.setFont(f2);
  lbusr.setForeground(new Color(100,0,60));
  lbpass.setForeground(new Color(100,0,60));
  btnok.setBackground(new Color(100,0,50));
  btncancel.setBackground(new Color(100,0,50));
  btnok.setForeground(new Color(200,250,150));
  btncancel.setForeground(new Color(200,250,150));
 // add (lbusr);
  add (txtusr);
 // add (lbpass);
  add (txtpass);
  //add (btnok);
  add(img);
  add(txtpassd);
  btnlog.addActionListener(this);
  btncancel.addActionListener(this);
  txtusr.addFocusListener(this);
  txtpass.addFocusListener(this);  
}
public void focusGained(FocusEvent fe)
{
   if(fe.getSource()==txtusr)
{
     txtusr.setText("");
	 //txtpassd.setVisible(false);
	 //txtpass.setVisible(false);
}
  if(fe.getSource()==txtpass)
{
//	txtusr.setText("");
     txtpass.setVisible(false);
	 txtpassd.setVisible(true);
}
}
public void focusLost(FocusEvent fe)
{
}
 public void actionPerformed (ActionEvent e)
 {
  if(e.getSource() == btnlog)
  {
   int flg=0;
   try
   {
    Connection con = DriverManager.getConnection("jdbc:odbc:eventdsn");
    Statement st = con.createStatement();
    ResultSet res = st.executeQuery("select * from logintbl");
    while(res.next())
    {
     if(res.getString(1).equals(txtusr.getText()) && res.getString(2).equals(txtpassd.getText()))
      {
       //	   mainform mb = new mainform();
	     flg=1;
        dash obj = new dash();
		this.dispose();
       }
    }
	
    if(flg == 0)
       JOptionPane.showMessageDialog(null,"Incorrect password or user");
     }
     catch(Exception ee)
     {
      System.out.println(ee);
     }
   }
  if(e.getSource() == btncancel)
  { 
    this.dispose();
  }
 }
 public static void main (String args[])
 {
  Login ob = new Login();
 }
}

