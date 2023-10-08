package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Main extends JPanel implements ActionListener, MouseListener{
	private JFrame frame ;
	private JButton user,admin;
	private Font font;
	private ImageIcon background;
	private Image img;
	
	public Main() {
		try
		{
			UIManager.setLookAndFeel("UIManager.getCrossPlatformLookAndFeelClassName()");
			} 
		catch (Exception ex) 
		{
				
		}
		background = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\WeGems\\src\\GuI\\main2.png");
		img = background.getImage();
		font = new Font("Arial",Font.BOLD , 12);
		frame = new JFrame();
		user = new JButton("User");
		user.setFont(font);
		user.addActionListener(this);
		user.setFocusable(false);
		//frame.dispose();
		admin = new JButton("Admin");
		admin.setFont(font);
		admin.addMouseListener(this);
		admin.setFocusable(false);
		
		user.setBounds(50, 150, 300, 40);
		add(user);
		admin.setBounds(50,230,300,40);
		add(admin);
		
		frame.setSize(400,480);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.add(this);
		setLayout(null);
		
		user.setBackground(Color.cyan);
		admin.setBackground(Color.cyan);
		
		
		
	}
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0,400,500, null);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new login();
		frame.dispose();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		new adminLogin();
		frame.dispose();
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
