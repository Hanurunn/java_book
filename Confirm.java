import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

class Confirm extends JFrame implements ActionListener{
	JLabel la1,la2,la3; 
	JButton b1,b2;
	String name, j, t, d;
 
 
 	Confirm(String name, String j,String t,String d){
 		super(name+" ��"); //new JFrame ����
 		this.name=name; this.j=j; this.t=t; this.d=d;

 		String p=new DB_Conn().call(t);
  
 		la1=new JLabel("å�̸� :"+t,0);
 		la2=new JLabel("�뿩�Ⱓ :"+d,0); //0�� �������
 		la3=new JLabel("�ݾ� :"+p ,0);
 		b1=new JButton("Ȯ��");
 		b2=new JButton("�����ϱ�");
 		b1.addActionListener(this);
 		b2.addActionListener(this);  
  
 		JPanel p1=new JPanel(); //Ȯ�� �����ϱ�
 		p1.setLayout(new FlowLayout());
 		p1.add(b1); p1.add(b2);
  
 		JPanel p2=new JPanel(); //la1 la2 la3 ��ġ��
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
	 if(jb.equals(b1)){//Ȯ��
		 new Bye(name);
		 this.setVisible(false);   
	 }
	 else{//����
		 new Rent(name,j,t,d);
		 this.setVisible(false);
	 }
   }//close action
}//close Book