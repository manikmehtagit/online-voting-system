package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class login extends JPanel implements ActionListener , MouseListener{
	
	private JFrame frame;
	private JLabel adhar,pass,heading;
	private JTextField adhartext;
	private JPasswordField passtext;
	private JButton login;
	private Font font,font1;
	private ImageIcon background;
	private Image img;
	login() {
		
		background = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\WeGems\\src\\GuI\\main2.png");
		img = background.getImage();
		font = new Font("Arial",Font.BOLD , 11);
		font1 = new Font("Tahoma",Font.PLAIN, 16);
		frame = new JFrame();
		adhar = new JLabel("aadhar Id");
		adhar.setFont(font);
		pass = new JLabel("Password");
		pass.setFont(font);
		heading = new JLabel("create an account?");
		heading.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		heading.setFont(font);
		heading.addMouseListener(this);
		
		adhartext = new JTextField(20);
		passtext = new JPasswordField(20);
		
		login = new JButton("Login");
		login.setFont(font);
		login.addActionListener(this);
		
		adhar.setBounds(40, 100, 80, 20);
		add(adhar);
		adhartext.setBounds(130, 90, 220, 40);
		add(adhartext);
		pass.setBounds(40, 170, 80, 20);
		add(pass);
		passtext.setBounds(130, 160, 220, 40);
		add(passtext);
		login.setBounds(130, 230, 220, 40);
		add(login);
		heading.setBounds(160, 280, 200, 20);
		add(heading);
		
		heading.setForeground(Color.blue);
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
				String aadharId = adhartext.getText();
				String password = passtext.getText().toString();
				connector db=new connector();
				ResultSet rs=db.getLoginDetails(aadharId,password);
				try {
					if(rs.next())
					{
						  JOptionPane.showMessageDialog(frame, "Login Success");
						  frame.dispose();
							new party(aadharId);
					}
					else
					{
						  JOptionPane.showMessageDialog(frame, "Something went wrong !!!!");		
					}
					
					if(e.getSource() == heading) {
						new registration();
					}
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		new registration();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
