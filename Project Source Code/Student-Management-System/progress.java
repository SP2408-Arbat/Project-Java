import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.plaf.ProgressBarUI;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

//import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class progress {

	static Timer timer;
	private JFrame frame;
	private int x=0;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	
	public progress() 
	{
		initialize();
		timer.start();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(28, 198, 396, 41);
		frame.getContentPane().add(progressBar);
		
		timer=new Timer(100,new ActionListener() 
	    {
	         private int x=0;
			
	         
	         @Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
	        	 progressBar.setValue(x++);
				if(x==100) 
				{
					timer.stop();
					frmAdminMDI frm=new frmAdminMDI();
					frm.setVisible(true);
					frame.dispose();
				}
			}


			
	    });
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(progress.class.getResource("/images/images.png")));
		lblNewLabel.setBounds(130, 105, 188, 86);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome Student");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_1.setBounds(118, 11, 211, 41);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Management System");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblNewLabel_2.setBounds(118, 63, 200, 31);
		frame.getContentPane().add(lblNewLabel_2);
		frame.setVisible(true);
		
	}
	/*public static void main(String[] args) 
	{

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					progress window = new progress();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
}
