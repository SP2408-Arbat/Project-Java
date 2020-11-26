
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import net.proteanit.sql.DbUtils;

//import com.sun.tools.javac.launcher.Main;

public class List extends JInternalFrame implements ActionListener {

    private JTextField T1;
	private JPanel buttonPanel;
    private JButton btnCancel,  btnRefresh;
    private JPanel rptPanel;
    private JTabbedPane listsTabs;
    private JTextArea listPane;
    private JTable tb;
    public List() {
        super("User Details List", false, true, false, true);
        setLayout(new BorderLayout());
        setSize(1500,1000);
        T1=new JTextField(30);
        T1.setBounds(100, 50, 150, 25);
        buttonPanel = new JPanel(new FlowLayout());
        //btnRefresh = new JButton("Refresh", new ImageIcon(ClassLoader.getSystemResource("Images/update.png")));
        btnCancel = new JButton("Search");

        buttonPanel.add(T1);
        buttonPanel.add(btnCancel);
        btnCancel.addActionListener(this);
       tb=new JTable();
       int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
       int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
       		JScrollPane jp = new JScrollPane(tb, v,h);


        listsTabs = new JTabbedPane();
        rptPanel = new JPanel(new GridLayout(1, 1));
        rptPanel.setBackground(Color.white);
        listsTabs.add(rptPanel);

        listPane = new JTextArea();
        listPane.setEditable(false);
        listPane.setFont(new Font("monospaced", Font.BOLD, 14));
        listPane.setForeground(Color.black);
        listPane.setLineWrap(true);
        listPane.setWrapStyleWord(true);
        rptPanel.add(tb);

        add(buttonPanel, BorderLayout.PAGE_START);
        add(listsTabs, BorderLayout.CENTER);

        printUsersList();
    }//constructor closed
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnCancel) {
        	printUsersList();
        }
     
    }

    private void printUsersList() {
        listPane.setText("");
        listPane.append("\n\t\t\tUSERS DETAIL LIST");
        try {
            Statement st = Settings.getDBConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Student WHERE Qualification='" + T1.getText()+"'");			
            tb.setModel(DbUtils.resultSetToTableModel(rs));

        	
            //listPane.append("\n\n");
            //listPane.append("RollNo \t SName \t Phno \t Sex \t FName \t Occupation \t MName \t DOB \t Age \t Caste \t Religion \t Hname \t City \t District \t State \t Pin \t Year \t Qualification");
            //listPane.append("\n\t\t---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------/");
            //while (rs.next()) {
              //  listPane.append("\n\t\t" + rs.getString(1) + "\t\t" + rs.getString(3));
                //System.out.println(rs.getString(1)+"-----"+rs.getString(3));
            //}
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
       
    }
    public static void main(String[] args) 
    {
    	
		
	}
}//class closed

