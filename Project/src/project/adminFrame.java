package project;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class adminFrame extends JFrame {
	
	JLabel label1 , label2;
	JLabel pn[]=new JLabel[100];
	JLabel tv[]=new JLabel[100];
	public adminFrame() {
		
		label1 = new JLabel("Party name");
		add(label1);
		label1.setBounds(50, 20, 80,20 );
		label2 = new JLabel("Total Vote");
		add(label2);
		label2.setBounds(270, 20, 80,20 );
		connector db=new connector();
		try
		{
				int i=0;
				int j = 0;
				ResultSet rs=db.getResultDetails();
				while(rs.next())
				{

				
					
						pn[i]=new JLabel(rs.getString("party"));
						pn[i].setBounds(50,(i+1)*40,80,20);
						add(pn[i]);
						tv[j]=new JLabel(rs.getString("total_vote"));
						tv[j].setBounds(270,(j+1)*40,80,20);
						add(tv[j]);
					i++;
					j++;
				}
		}
		catch(Exception ee)
		{
			
		}
		setLayout(null);
		setSize(400,480);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new adminFrame();
	}
}
