package project;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class party extends JPanel implements ActionListener{
	
	private JFrame frame;
	private JButton b1, b2, b3, b4, b5, b6;
	
	private ImageIcon ic1, ic2, ic3, ic4, ic5, ic6;
	private Image img,newimg;
	private String aid;
	public party(String aid){
		this.aid=aid;
		frame = new JFrame();
		ic1 = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\WeGems\\src\\GuI\\bjp.png");
		ic2 = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\WeGems\\src\\GuI\\congress.png");
		ic3 = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\WeGems\\src\\GuI\\aap.png");
		ic4 = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\WeGems\\src\\GuI\\inld.jpg");
		ic5 = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\WeGems\\src\\GuI\\jjp.png");
		ic6 = new ImageIcon("C:\\Users\\Lenovo\\eclipse-workspace\\WeGems\\src\\GuI\\bsp.jpg");
		
		
		
		img = ic3.getImage();
		newimg = img.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH);
		
		img = ic4.getImage();
		newimg = img.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH);
		
		img = ic5.getImage();
		
		
		newimg = img.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH);
		
		img = ic6.getImage();
		newimg = img.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH);
		
		b1 = new JButton();
		b2 = new JButton();
		b3 = new JButton();
		b4 = new JButton();
		b5 = new JButton();
		b6 = new JButton();
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		
		add(b1);
		b1.setBounds(0, 0, 300, 200);
		img = ic1.getImage();  
		newimg = img.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH);
		b1.setIcon(new ImageIcon(newimg));
		b1.setBorderPainted(false);

		add(b2);
		b2.setBounds(300, 0, 300, 200);
		img = ic2.getImage();
		newimg = img.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH);
		b2.setIcon(new ImageIcon(newimg));
		b2.setBorderPainted(false);
		
		add(b3);
		b3.setBounds(0, 200, 300, 200);
		img = ic3.getImage();
		newimg = img.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH);
		b3.setIcon(new ImageIcon(newimg));
		b3.setBorderPainted(false);
		
		add(b4);
		b4.setBounds(300, 200, 300, 200);
		img = ic4.getImage();
		newimg = img.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH);
		b4.setIcon(new ImageIcon(newimg));
		b4.setBorderPainted(false);
		
		add(b5);
		b5.setBounds(0, 400, 300, 200);
		img = ic5.getImage();
		newimg = img.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH);
		b5.setIcon(new ImageIcon(newimg));
		b5.setBorderPainted(false);
		
		
		add(b6);
		b6.setBounds(300, 400, 300, 200);
		img = ic6.getImage();
		newimg = img.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH);
		b6.setIcon(new ImageIcon(newimg));
		b6.setBorderPainted(false);
		
		frame.setSize(615,635);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.add(this);
		setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String party="";
		if(e.getSource() == b1) {
			party = "BJP";
		}
		if(e.getSource() == b2) {
			party = "Congress";
		}
		if(e.getSource() == b3) {
			party = "AAP";
		}
		if(e.getSource() == b4) {
			party = "INLD";
		}
		if(e.getSource() == b5) {
			party = "JJP";
		}
		if(e.getSource() == b6) {
			party = "BSP";
		}
		connector db=new connector();
		int i=db.updateRegDetail(aid, party);
		if(i==1)
		{
			  JOptionPane.showMessageDialog(frame, "Vote Submited Successfully!!!");
		}
		else
		{
			  JOptionPane.showMessageDialog(frame, "Something went wrong");		
		}
	}

}