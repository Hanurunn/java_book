import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

class Confirm extends JFrame implements ActionListener{
	JLabel la1,la2,la3; 
	JButton b1,b2;
	String name, j, t, d;
 
 
 	Confirm(String name, String j,String t,String d){
 		super(name+" 님"); //new JFrame 제목
 		this.name=name; this.j=j; this.t=t; this.d=d;

 		String p=new DB_Conn().call(t);
  
 		la1=new JLabel("책이름 :"+t,0);
 		la2=new JLabel("대여기간 :"+d,0); //0은 가운데정렬
 		la3=new JLabel("금액 :"+p ,0);
 		b1=new JButton("확인");
 		b2=new JButton("수정하기");
 		b1.addActionListener(this);
 		b2.addActionListener(this);  
  
 		JPanel p1=new JPanel(); //확인 수정하기
 		p1.setLayout(new FlowLayout());
 		p1.add(b1); p1.add(b2);
  
 		JPanel p2=new JPanel(); //la1 la2 la3 합치기
	 p2.setLayout(new BorderLayout());
	 p2.add("North",la1); p2.add("Center",la2);
	 p2.add("South",la3);
  
	 this.setLayout(new BorderLayout());
	 this.add("North",p2); this.add("Center",p1);
  
  
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 this.setBounds(100,300,250,300);
	 this.setVisible(true);
 }
 	
 public static void main(String[] args) {
  //new Book6();
 }
 public void actionPerformed(ActionEvent e) {
	 JButton jb=(JButton)e.getSource();
	 if(jb.equals(b1)){//확인
		 new Bye(name);
		 this.setVisible(false);   
	 }
	 else{//수정
		 new Rent(name,j,t,d);
		 this.setVisible(false);
	 }
   }//close action
}//close Book