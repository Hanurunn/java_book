
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

	JRadioButton rb1,rb2;
	JLabel l1,l2;
	JTextField tf1,tf2;
	JButton b1,b2, b3;
	
	Login(){
		super("들어가기");
		rb1=new JRadioButton("회원", true);
		rb2=new JRadioButton("관리자");
		rb1.addActionListener(new R());
		rb2.addActionListener(new R());
		
		ButtonGroup bt=new ButtonGroup();
		bt.add(rb1); bt.add(rb2);
		
		l1=new JLabel("ID");
		l2=new JLabel("PW");
		
		tf1=new JTextField(10); 
		tf2=new JTextField(10);
		tf2.setEditable(false);
		
		b1=new JButton("들어가기"); 
		b1.addActionListener(this);
		b2=new JButton("수정"); 
		b2.addActionListener(this);
		b3=new JButton("가입");
		b3.addActionListener(this);
		
		JPanel p1=new JPanel(); p1.setLayout(new FlowLayout());
		p1.add(rb1); p1.add(rb2);
		JPanel p2=new JPanel(); p2.setLayout(new FlowLayout());
		p2.add(l1); p2.add(tf1);
		JPanel p3=new JPanel(); p3.setLayout(new FlowLayout());
		p3.add(l2); p3.add(tf2);
		JPanel p4=new JPanel(); p4.setLayout(new FlowLayout());
		p4.add(b1); p4.add(b2); p4.add(b3);
		
		JPanel p5=new JPanel(); p5.setLayout(new BorderLayout());
		p5.add("North",p1);p5.add("Center",p2);p5.add("South",p3);
		this.setLayout(new BorderLayout());
		this.add("North",p5);this.add("Center",p4);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 200, 260, 200);
		this.setVisible(true);
	}
	
	class R implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(rb1.isSelected()){
				tf1.setText(""); tf2.setText("");
				tf2.setEditable(false);
			}
			
			else {
				tf1.setText(""); tf2.setText("");
				tf2.setEditable(true);
			}
		}
	}
	
	public static void main(String[] args) {
		new Login();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton jb = (JButton)e.getSource();
		if(jb.equals(b2)){	 //수정하기
			tf1.setText("");
			tf2.setText("");
			rb1.setSelected(true);
			tf2.setEditable(false);
		}
		
		else if(jb.equals(b3)){ //가입
			new Join();
			this.setVisible(false);
		}
		
		else { 						//들어가기 ==> 회원(5)인지 관리자(2)인지 구분
			String flag = tf1.getText();
			if(!flag.equals("")){
				if(rb1.isSelected()) { //회원
					String name = tf1.getText();
					new Rent(name);
					this.setVisible(false);
				}
				
				else {	//관리자
					String id = tf1.getText();
					String pw = tf2.getText();
					if(id.equals("admin")&&pw.equals("1111")){
						new Manage();
						this.setVisible(false);
					}
				}//flag if
			}//else
		}//else
	}//actionPerformed
}//class
