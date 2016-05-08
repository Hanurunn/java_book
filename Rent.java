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
	    if(d.equals("3��"))
	      cb1.setSelected(true);
	    else if(d.equals("5��"))
	   cb2.setSelected(true);
	    else
	   cb3.setSelected(true);
	 }
 
	Rent (String name){
		super(name+" ��"); //new JFrame ����
		this.name=name;
		la1=new JLabel("�뿩�ϱ�");
		la2=new JLabel("å�帣"); //0�� �������
		la3=new JLabel("å����");
		la4=new JLabel("�뿩�Ⱓ");
  
		b1=new JButton("Ȯ��");
		b1.addActionListener(this);
  
		c=new JComboBox();
		c.addItem("�ѱ�");
		c.addItem("�Ϻ�");
		c.addItem("�̱�");
		c.addItemListener(new ac());
  
		cb1=new JRadioButton("3��",true); //true�� �⺻ ����
		cb2=new JRadioButton("5��"); 
		cb3=new JRadioButton("7��"); 
  
		ButtonGroup b=new ButtonGroup();
		b.add(cb1); b.add(cb2); b.add(cb3);  
  
		String[] data={"      ","      ","      "};
		li=new JList(data);
		String sr[]={"�����","������ ����","ŷ����"};  
		li.setListData(sr);
		JScrollPane jsp=new JScrollPane(li);
  
		JPanel p1=new JPanel(); //å�帣
		p1.setLayout(new FlowLayout());
		p1.add(la2); p1.add(c);
		
		JPanel p2=new JPanel(); //å����
		p2.setLayout(new FlowLayout());
		p2.add(la3); p2.add(jsp);
  
		JPanel p3=new JPanel(); //�뿩�Ⱓ
		p3.setLayout(new FlowLayout());
		p3.add(cb1); p3.add(cb2); p3.add(cb3);
		
		JPanel p4=new JPanel(); //la1 p1 p2 ��ġ��
		p4.setLayout(new BorderLayout());
		p4.add("North",la1); p4.add("Center",p1);
		p4.add("South",p2);
  
		JPanel p5=new JPanel(); //la4 p3 b1 ��ġ��
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