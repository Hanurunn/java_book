import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Join extends JFrame implements ActionListener {
	JLabel la1, la2;
	JTextField tf1, tf2;
	JButton b1, b2;
	
	Join(){
		super("회원가입");
		la1 = new JLabel("계정");
		la2 = new JLabel("이름");
		
		b1 = new JButton("추가");
		b1.addActionListener(this);
		b2 = new JButton("돌아가기");
		b2.addActionListener(this);
		
		tf1 = new JTextField(10);
		tf2 = new JTextField(10);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.add(la1); p1.add(tf1);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.add(la2); p2.add(tf2);
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		p3.add(b1); p3.add(b2);
		
		this.setLayout(new BorderLayout());
		this.add("North", p1);
		this.add("Center", p2);
		this.add("South", p3);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(300, 200, 260, 160);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton jb = (JButton)e.getSource();
		if(jb.equals(b1)){
			String a = tf1.getText();
			String n = tf2.getText();
			new DB_Conn().mjoin(a, n);
			new Login();
			this.setVisible(false);
		}
		
		else{
			new Login();
			this.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Join();
	}
}
