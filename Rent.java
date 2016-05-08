import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class Rent extends JFrame implements ActionListener{
	JLabel la1,la2,la3,la4;
	JButton b1; JList li;
	JComboBox c; 
	JRadioButton cb1, cb2, cb3;
	String name;
	
	Rent(String name, String j,String t,String d){
	    this(name);
	    c.setSelectedItem(j);
	    li.setSelectedValue(t,true);
	    if(d.equals("3일"))
	      cb1.setSelected(true);
	    else if(d.equals("5일"))
	   cb2.setSelected(true);
	    else
	   cb3.setSelected(true);
	 }
 
	Rent (String name){
		super(name+" 님"); //new JFrame 제목
		this.name=name;
		la1=new JLabel("대여하기");
		la2=new JLabel("책장르"); //0은 가운데정렬
		la3=new JLabel("책선택");
		la4=new JLabel("대여기간");
  
		b1=new JButton("확인");
		b1.addActionListener(this);
  
		c=new JComboBox();
		c.addItem("한국");
		c.addItem("일본");
		c.addItem("미국");
		c.addItemListener(new ac());
  
		cb1=new JRadioButton("3일",true); //true는 기본 설정
		cb2=new JRadioButton("5일"); 
		cb3=new JRadioButton("7일"); 
  
		ButtonGroup b=new ButtonGroup();
		b.add(cb1); b.add(cb2); b.add(cb3);  
  
		String[] data={"      ","      ","      "};
		li=new JList(data);
		String sr[]={"어벤져스","왕좌의 게임","킹스맨"};  
		li.setListData(sr);
		JScrollPane jsp=new JScrollPane(li);
  
		JPanel p1=new JPanel(); //책장르
		p1.setLayout(new FlowLayout());
		p1.add(la2); p1.add(c);
		
		JPanel p2=new JPanel(); //책선택
		p2.setLayout(new FlowLayout());
		p2.add(la3); p2.add(jsp);
  
		JPanel p3=new JPanel(); //대여기간
		p3.setLayout(new FlowLayout());
		p3.add(cb1); p3.add(cb2); p3.add(cb3);
		
		JPanel p4=new JPanel(); //la1 p1 p2 합치기
		p4.setLayout(new BorderLayout());
		p4.add("North",la1); p4.add("Center",p1);
		p4.add("South",p2);
  
		JPanel p5=new JPanel(); //la4 p3 b1 합치기
		p5.setLayout(new BorderLayout());
		p5.add("North",la4); p5.add("Center",p3);
		p5.add("South",b1);
  
		this.setLayout(new BorderLayout());
		this.add("North",p4); this.add("Center",p5);
  
  
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(200,300,250,360);
		this.setVisible(true);
 }
 
	class ac implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			String s=(String)c.getSelectedItem();
			Vector<String> v=new Vector<String>();
			v=new DB_Conn().sel(s);
			li.setListData(v);   
		}  
	}//close ac

	public static void main(String[] args) {
		new Rent("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String jang=(String)c.getSelectedItem();
		String book=(String)li.getSelectedValue();
		String day="";
		if(cb1.isSelected())
			day=cb1.getText();
		else if(cb2.isSelected())
			day=cb2.getText();
		else
			day=cb3.getText();
		new Confirm(name,jang,book,day);
		this.setVisible(false);
	}//close actionPerformed 
}//close Book5