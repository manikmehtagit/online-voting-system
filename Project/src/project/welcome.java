package project;

import java.awt.*;

import javax.swing.*;
public class welcome extends JPanel{
		
	private JFrame frame;
	private ImageIcon background;
	private Image img;
	public welcome() 
	{
	    	
		frame = new JFrame();
		background = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\WeGems\\src\\GuI\\welcome.png");
		img = background.getImage();
//		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		
		frame.add(this);
		frame.setSize(600,500);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.setVisible(true);
		
//		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.dispose();
		new Main();
	}
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0,600,500, null);
	}
	
	public static void main(String[] args) {
		new welcome();
	}

}

