import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
class Manage extends JFrame{
	JLabel la1,la2,la3,la4; 
	JButton b1,b2;
	JTextField tf1, tf2, tf3;
	JComboBox c;
 
 Manage(){
	 super("å �߰�"); //new JFrame ����
	 la1=new JLabel("�帣");
	 la2=new JLabel("�̸�"); //0�� �������
	 la3=new JLabel("�ݾ�");
	 la4=new JLabel("ȸ��"); //0�� �������
  
	 b1=new JButton("�߰�");
	 b1.addActionListener(new in());
  
	 b2=new JButton("����");
  
	 c=new JComboBox();
	 c.addItem("�׼�");
	 c.addItem("���");
	 c.addItem("��ȭ");
  
	 tf1= new JTextField(10);
	 tf2= new JTextField(10);
	 tf3= new JTextField(10);
  
	 JPanel p1=new JPanel(); //å�帣
	 p1.setLayout(new FlowLayout());
	 p1.add(la1); p1.add(c);
	 
	 JPanel p2=new JPanel(); //å�̸�
	 p2.setLayout(new FlowLayout());
	 p2.add(la2); p2.add(tf1);
  
	 JPanel p3=new JPanel(); //�ݾ�
	 p3.setLayout(new FlowLayout());
	 p3.add(la3); p3.add(tf2);
  
	 JPanel p4=new JPanel(); //���ǻ� 
	 p4.setLayout(new FlowLayout());
	 p4.add(la4); p4.add(tf3);
  
	 JPanel p5=new JPanel(); //�߰� ���� 
	 p5.setLayout(new FlowLayout());
	 p5.add(b1); p5.add(b2);
  
	 JPanel p6=new JPanel(); //p1 p2 p3 ��ġ��
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
