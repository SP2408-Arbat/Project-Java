import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;

public class smslog extends JFrame {

    public static void main(String[] args) 
    {
    	
         new smslog();

    }

    
    private JPanel p1;
    private JLabel l1, l2;
    private JTextField t1;
    private JPasswordField pass;
    private JButton b1, b2;
    private ImageIcon img;

    smslog() {

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(255, 255, 102));
        
        img = new ImageIcon(getClass().getResource("/StudentMgmtSys/User-icon.png"));
        l1 = new JLabel(img);
        l1.setBounds(0, 0, 215, 360);
        this.add(l1);

       
        l1 = new JLabel("Username");
        l1.setBounds(230, 30, 90, 40);
        l1.setFont(new Font("Serif", Font.PLAIN, 20));

        l2 = new JLabel("Password");
        l2.setBounds(230, 120, 100, 40);
        l2.setFont(new Font("Serif", Font.PLAIN, 20));

        t1 = new JTextField(30);
        t1.setBounds(320, 30, 230, 35);

        pass = new JPasswordField(10);
        pass.setBounds(320, 120, 230, 35);

        b1 = new JButton("User-Login");
        b1.setBounds(230, 250, 100, 50);
        b1.setBackground(new Color(204, 229, 255));
        b1.setMnemonic('u');

        b2 = new JButton("Administrator-Login");
        b2.setBounds(400, 250, 150, 50);
        b2.setBackground(new Color(204, 229, 255));
        b2.setMnemonic('a');

        p1.add(l1);
        p1.add(l2);
        p1.add(t1);
        p1.add(pass);
        p1.add(b1);
        p1.add(b2);

        add(p1);
        setSize(580, 390);
        setVisible(true);
        setResizable(false);
        setLocation(370, 50);
        setTitle("Student Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userlogin();
        adminlogin();

    }

    public void userlogin() {
        b1.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {
                String puname = t1.getText();
                String ppaswd = pass.getText();
                String user="Student";
                String s1,s2,s3;
                try
                {
                	//Class.forName("oracle.jdbc.driver.OracleDriver");
       		 //Connection	 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2", "SYSTEM", "root");
                	Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/student","postgres","root");
                	System.out.println("Connected");
       		        Statement st=con.createStatement();
                	String sql="SELECT * FROM UAD WHERE Username='" + t1.getText()+"'and Password='"+pass.getText()+"'";
                	st.execute(sql);
                	ResultSet res=st.executeQuery(sql);
                	if(res.next())
                	{ 
                       
                		if (puname.equals(res.getString(1)) && ppaswd.equals(res.getString(2)) && user.equals(res.getString(3)) ) 
                		{
                            // user side view
                			System.out.println("Executed"+res.getString(1)+"--"+res.getString(2)+"--"+res.getString(3));
                            
                			userMDI us = new userMDI();
                            	us.setVisible(true);
                                dispose();
                            } 
                		else {
                			

                                JOptionPane.showMessageDialog(null, "Wrong Password or Username");
                                t1.setText("");
                                pass.setText("");
                                t1.requestFocus();
                            }
                		
                	}
                	else
                	{
                		JOptionPane.showMessageDialog(null, "Wrong Password or Username");
                        t1.setText("");
                        pass.setText("");
                        t1.requestFocus();
                	}
                }catch(Exception ex)
                {
                	ex.printStackTrace();
                }
                            }
        });
    }

    public void adminlogin() 
    {
        b2.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	String puname = t1.getText();
                String ppaswd = pass.getText();
                String user="Admin";
                String s1,s2,s3;
                try
                {
                	//Class.forName("oracle.jdbc.driver.OracleDriver");
       		 //Connection	 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2", "SYSTEM", "root");
                	Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/student","postgres","root");
                	System.out.println("Connected");
       		        Statement st=con.createStatement();
                	String sql="SELECT * FROM UAD WHERE Username='" + t1.getText()+"'and Password='"+pass.getText()+"'";
                	st.execute(sql);
                	ResultSet res=st.executeQuery(sql);
                	if(res.next())
                	{ 
                       
                		if (puname.equals(res.getString(1)) && ppaswd.equals(res.getString(2)) && user.equals(res.getString(3)) ) 
                		{
                            // user side view
                			System.out.println("Executed"+res.getString(1)+"--"+res.getString(2)+"--"+res.getString(3));
                            
                			//userMDI us = new userMDI();
                			progress window = new progress();	
                			//us.setVisible(true);
                                dispose();
                            } 
                		else {
                			

                                JOptionPane.showMessageDialog(null, "Wrong Password or Username");
                                t1.setText("");
                                pass.setText("");
                                t1.requestFocus();
                            }
                		
                		
                	}
                	else
                	{
                		JOptionPane.showMessageDialog(null, "Wrong Password or Username");
                        t1.setText("");
                        pass.setText("");
                        t1.requestFocus();
                	}
                }catch(Exception ex)
                {
                	ex.printStackTrace();
                }
            }
        });
    }

}
