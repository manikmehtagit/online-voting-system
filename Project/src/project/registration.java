package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class registration implements ActionListener , MouseListener{

	private JFrame frame ;
	private JPanel panel;
	private JButton register;
	private JLabel heading,first,last,aadhar,number,pass,confirm,sex;
	private JPasswordField passtext,confirmtext;
	private JTextField firsttext,lasttext,aadhartext,numbertext;
	private JRadioButton radio1,radio2;
	private ButtonGroup bg;
	private Font font;
	
	registration() {
		font = new Font("Arial",Font.BOLD , 11);
		frame = new JFrame();
		heading = new JLabel("Create an account");
		heading.setFont(font);
		first = new JLabel("First name");
		first.setFont(font);
		last = new JLabel("Last name");
		last.setFont(font);
		aadhar = new JLabel("Aadhar ID");
		aadhar.setFont(font);
		number = new JLabel("Contact Number");
		number.setFont(font);
		pass = new JLabel("Password");
		pass.setFont(font);
		confirm = new JLabel("Confirm Password");
		confirm.setFont(font);
		sex =  new JLabel("Gender");
		sex.setFont(font);
		
		bg = new ButtonGroup();
		
		
		firsttext = new JTextField(20);
		lasttext = new JTextField(20);
		aadhartext = new JTextField(20);
		numbertext = new JTextField(20);
		passtext = new JPasswordField(20);
		confirmtext = new JPasswordField(20);
		
		radio1 = new JRadioButton();
		radio1.setText("Male");
		radio1.setFont(font);
		radio2 = new JRadioButton();
		radio2.setText("Female");
		radio2.setFont(font);
		
		register = new JButton("Register");
		panel = new JPanel();
		register.addActionListener(this);
		register.addMouseListener(this);
		
		panel.setLayout(null);
		
		frame.add(panel);
		
		heading.setBounds(240, 10, 120, 20);
		panel.add(heading);
		first.setBounds(30, 50, 100, 20);
		panel.add(first);
		firsttext.setBounds(150, 40, 300, 40);
		panel.add(firsttext);
		last.setBounds(30, 100, 100, 20);
		panel.add(last);
		lasttext.setBounds(150, 90, 300, 40);
		panel.add(lasttext);
		aadhar.setBounds(30, 150, 100, 20);
		panel.add(aadhar);
		aadhartext.setBounds(150, 140, 300, 40);
		panel.add(aadhartext);
		number.setBounds(30, 200, 100, 20);
		panel.add(number);
		numbertext.setBounds(150, 190, 300, 40);
		panel.add(numbertext);
		pass.setBounds(30, 250, 100, 20);
		panel.add(pass);
		passtext.setBounds(150, 240, 300, 40);
		panel.add(passtext);
		confirm.setBounds(30, 300, 110, 20);
		panel.add(confirm);
		confirmtext.setBounds(150, 290, 300, 40);
		panel.add(confirmtext);
		sex.setBounds(30, 350, 100, 20);
		panel.add(sex);
		
		
		radio1.setBounds(150, 340, 150, 40);
		panel.add(radio1);
		radio2.setBounds(310, 340, 140, 40);
		panel.add(radio2);
		register.setBounds(150, 390, 300, 40);
		panel.add(register);
		
		bg.add(radio1);
		bg.add(radio2);
		
		heading.setForeground(Color.black);
		/*heading.setForeground(Color.red);
		first.setForeground(Color.white);
		last.setForeground(Color.white);
		email.setForeground(Color.white);
		number.setForeground(Color.white);
		pass.setForeground(Color.white);
		confirm.setForeground(Color.white);
		sex.setForeground(Color.white);
		radio1.setForeground(Color.white);
		radio2.setForeground(Color.white);
		radio1.setForeground(Color.white);
		radio2.setForeground(Color.white);
		panel.setBackground(Color.black);
		radio1.setBackground(Color.black);
		radio2.setBackground(Color.black);
		register.setBackground(Color.lightGray);*/
		register.setBackground(Color.black);
		register.setForeground(Color.white);
		frame.setSize(600,500);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String first_name = firsttext.getText();
		String last_name = lasttext.getText();
		String aadhar = aadhartext.getText();
		String contact = numbertext.getText();
		String password = passtext.getText().toString();
		String gender;
		if(radio1.isSelected()) {
			gender = "male";
		}
		else {
			gender = "female";
		}
		connector db=new connector();
		int res=db.setRegistrationDetails(first_name, last_name, aadhar, contact, password,gender);
		if(res==1)
		{
			  JOptionPane.showMessageDialog(frame, "Account created successfully");
		}
		else
		{
			  JOptionPane.showMessageDialog(frame, "Something went wrong");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		frame.dispose();
		new login();
		
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
