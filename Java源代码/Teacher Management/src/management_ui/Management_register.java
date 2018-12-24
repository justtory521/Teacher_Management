package management_ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import main.Admin;
import management_db.Demo;

import javax.swing.JPasswordField;

public class Management_register {
	
	//�õ���ǰ������ʾ���Ŀ�͸�
	public int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	public int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public int windowsWidth = 800;
	public int windowsHeight = 500;

	JFrame frame_re;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	
	/**
	 * Create the application.
	 */
	public Management_register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//����һ�����ڣ������ñ���ʹ�С�����ҿ��Թر�
		frame_re = new JFrame();
		frame_re.setTitle("��ʦ����ϵͳ-ע�����");
		frame_re.setBounds((width - windowsWidth) / 2,
				(height - windowsHeight) / 2, windowsWidth, windowsHeight);
		frame_re.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_re.getContentPane().setLayout(null);
		
		//����һ����ǩ�������Լ�׼���õ�ͼƬ��Ҳ����ɽ������ѧ�������ҹ����ͼƬ
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\Java\u5B9E\u8BAD\\Teacher Management\\image\\image1.png"));
		lblNewLabel.setBounds(45, 79, 250, 261);
		frame_re.getContentPane().add(lblNewLabel);
		
		//����һ����ǩ��������ʾ�û���������������ʾ������Ĵ�С�ͱ�ǩ�ı߿�
		JLabel lblNewLabel_1 = new JLabel("�û�����");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 30));
		lblNewLabel_1.setBounds(352, 50, 180, 75);
		frame_re.getContentPane().add(lblNewLabel_1);
		
		//����һ���ı��ռ��������ռ���������ݣ����������ı���Ĵ�С
		JTextField textField = new JTextField();
		textField.setBounds(520, 50, 244, 52);
		frame_re.getContentPane().add(textField);
		textField.setColumns(10);
		
		//����һ����ǩ��������ʾ���룬����������ʾ������Ĵ�С�ͱ�ǩ�ı߿�
		JLabel label = new JLabel("��  �룺");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("����", Font.BOLD, 30));
		label.setBounds(352, 150, 180, 75);
		frame_re.getContentPane().add(label);
		
		//����һ�������ռ������������һ���ı��ռ��򣬲����ǰ��ı����е��������أ�ͬ�������ı���Ĵ�С��λ��
		passwordField = new JPasswordField();
		passwordField.setBounds(520, 150, 244, 52);
		frame_re.getContentPane().add(passwordField);
		
		//����һ����ǩ��������ʾȷ�����룬����������ʾ������Ĵ�С�ͱ�ǩ�ı߿�
		JLabel label_1 = new JLabel("ȷ�����룺");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("����", Font.BOLD, 30));
		label_1.setBounds(352, 250, 180, 75);
		frame_re.getContentPane().add(label_1);
		
		//����һ�������ռ������������һ���ı��ռ��򣬲����ǰ��ı����е��������أ�ͬ�������ı���Ĵ�С��λ��
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(520, 250, 244, 52);
		frame_re.getContentPane().add(passwordField_1);

		//����һ��ȷ����ť�������ť������˵����Ӧ�¼���������Ӧ�������������ҳ�����ת��ͬ�����ð�ť��С�Լ���������Ĵ�С
		JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("����", Font.BOLD, 30));
		btnNewButton.setBackground(new Color(30, 144, 255));
		//���������¼�
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
		        if(e.getSource()==btnNewButton)
		        {
			        	String user_name = textField.getText();
			        	String show_name = user_name + "\r\n";
			        	
			        	char[] pass1 = passwordField.getPassword();
			        	String user_password1 = new String(pass1);
			        	String show_password1 = user_password1 + "\r\n";
			        	
			        	char[] pass2 = passwordField_1.getPassword();
			        	String user_password2 = new String(pass2);
			        	
			        	
			        	
			        	Admin admin = new Admin();
			        	admin.setName(user_name);
			        	if(user_password1.equals(user_password2)){
				        	admin.setPassword(user_password1);
				        	Demo demo = new Demo();
				            try {		            	
				            	demo.admin_insert(admin);
				            } catch (SQLException e1) {
				                e1.printStackTrace();
				            } catch (ClassNotFoundException e1) {
				                e1.printStackTrace();
				            }
				            JOptionPane.showMessageDialog(frame_re, "ע���˺ųɹ���\r\n" + "������" + show_name + "���룺" + show_password1, "ȷ��", JOptionPane.CANCEL_OPTION);
			        		
			        	}
			        	else{
			        		 JOptionPane.showMessageDialog(frame_re, "�������벻ͬ��ע��ʧ�ܣ�\r\n" , "ȷ��", JOptionPane.CANCEL_OPTION);
			        	}

		        }
			}
		});

		btnNewButton.setBounds(377, 368, 133, 52);
		frame_re.getContentPane().add(btnNewButton);
		
		//����һ����½��ť�������ť������˵����Ӧ�¼���������Ӧ�������������ҳ�����ת��ͬ�����ð�ť��С�Լ���������Ĵ�С
		JButton button = new JButton("��¼");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("����", Font.BOLD, 30));
		button.setBackground(new Color(30, 144, 255));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
		        if(e.getSource()==button)
		        {
		        	//�رյ�ǰ�Ľ���
		        	frame_re.dispose();
		        	//����һ���µĵ�½����
		        	Management_start management_start = new Management_start();
		        	management_start.frame.setVisible(true);
		        }
				
			}
		});
		button.setBounds(575, 368, 133, 52);
		frame_re.getContentPane().add(button);
		

	}
}
