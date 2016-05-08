import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
class Manage extends JFrame{
	JLabel la1,la2,la3,la4; 
	JButton b1,b2;
	JTextField tf1, tf2, tf3;
	JComboBox c;
 
 Manage(){
	 super("책 추가"); //new JFrame 제목
	 la1=new JLabel("장르");
	 la2=new JLabel("이름"); //0은 가운데정렬
	 la3=new JLabel("금액");
	 la4=new JLabel("회사"); //0은 가운데정렬
  
	 b1=new JButton("추가");
	 b1.addActionListener(new in());
  
	 b2=new JButton("수정");
  
	 c=new JComboBox();
	 c.addItem("액션");
	 c.addItem("멜로");
	 c.addItem("만화");
  
	 tf1= new JTextField(10);
	 tf2= new JTextField(10);
	 tf3= new JTextField(10);
  
	 JPanel p1=new JPanel(); //책장르
	 p1.setLayout(new FlowLayout());
	 p1.add(la1); p1.add(c);
	 
	 JPanel p2=new JPanel(); //책이름
	 p2.setLayout(new FlowLayout());
	 p2.add(la2); p2.add(tf1);
  
	 JPanel p3=new JPanel(); //금액
	 p3.setLayout(new FlowLayout());
	 p3.add(la3); p3.add(tf2);
  
	 JPanel p4=new JPanel(); //출판사 
	 p4.setLayout(new FlowLayout());
	 p4.add(la4); p4.add(tf3);
  
	 JPanel p5=new JPanel(); //추가 수정 
	 p5.setLayout(new FlowLayout());
	 p5.add(b1); p5.add(b2);
  
	 JPanel p6=new JPanel(); //p1 p2 p3 합치기
	 p6.setLayout(new BorderLayout());
	 p6.add("North",p1); p6.add("Center",p2);
	 p6.add("South",p3);
  
	 this.setLayout(new BorderLayout());
	 this.add("North",p6); this.add("Center",p4);
	 this.add("South",p5);
  
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 this.setBounds(300,200,260,220);
	 this.setVisible(true);
 	}
 
 	class in implements ActionListener{
 		public void actionPerformed(ActionEvent e) {
 			String j=(String)c.getSelectedItem();
 			String t=tf1.getText();
 			String p=tf2.getText();
 			String cp=tf3.getText();
 			new DB_Conn().setin(j,t,p,cp);
 			c.setSelectedIndex(0);
 			tf1.setText("");tf2.setText("");tf3.setText("");  
 		}
 	}//close in
 
 
 	public static void main(String[] args) {
 		new Manage();
 	}
}
