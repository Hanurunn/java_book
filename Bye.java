import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bye extends JFrame implements ActionListener {

	JLabel la;
	JButton b1,b2;
	String name;
	
	Bye(String name){
		super(name + " 님");
		this.name = name;
		la=new JLabel("감사합니다.");
		b1=new JButton("추가");
		b2=new JButton("처음으로");
		
		JPanel p1=new JPanel(); p1.setLayout(new FlowLayout());
		p1.add(b1); p1.add(b2);
		
		this.setLayout(new BorderLayout());
		this.add("North",la); this.add("Center",p1);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jb = (JButton)e.getSource();
		if(jb.equals(b1)){
			new Rent(name);
			this.setVisible(false);
		}
		
		else{
			new Login();
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new Bye("");
	}
}