package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class adminLogin extends JPanel implements ActionListener{
	
	private JFrame frame;
	private JLabel admin,pass;
	private JTextField admintext;
	private JPasswordField passtext;
	private JButton login;
	private Font font,font1;
	private ImageIcon background;
	private Image img;
	adminLogin() {
		
		background = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\WeGems\\src\\GuI\\main2.png");
		img = background.getImage();
		font = new Font("Arial",Font.BOLD , 11);
		font1 = new Font("Tahoma",Font.PLAIN, 16);
		frame = new JFrame();
		admin = new JLabel("aadhar Id");
		admin.setFont(font);
		pass = new JLabel("Password");
		pass.setFont(font);
		
		admintext = new JTextField(20);
		passtext = new JPasswordField(20);
		
		login = new JButton("Login");
		login.setFont(font);
		login.addActionListener(this);
		
		admin.setBounds(40, 100, 80, 20);
		add(admin);
		admintext.setBounds(130, 90, 220, 40);
		add(admintext);
		pass.setBounds(40, 170, 80, 20);
		add(pass);
		passtext.setBounds(130, 160, 220, 40);
		add(passtext);
		login.setBounds(130, 230, 220, 40);
		add(login);
		
		login.setBackground(Color.BLUE);
		login.setForeground(Color.white);
		login.setFont(font1);
		
		frame.setSize(410,440);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.add(this);
		setLayout(null);
		
	}
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, 410, 440, null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				String admin = admintext.getText().toString();
				String password = passtext.getText().toString();
				connector db=new connector();
				ResultSet rs=db.getAdminDetails(admin,password);
				try {
					if(rs.next())
					{
						  JOptionPane.showMessageDialog(frame, "Login Success");
						  frame.dispose();
						  
						new adminFrame();
					}
					else
					{
						  JOptionPane.showMessageDialog(frame, "Something went wrong !!!!");		
					}
					
//					if(e.getSource() == login) {
//						frame.dispose();
//						new adminFrame();
//					}
					
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
	}


}
