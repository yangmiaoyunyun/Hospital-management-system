package department;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Wininsertdepartment {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wininsertdepartment window = new Wininsertdepartment();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Wininsertdepartment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u90E8\u95E8\u7BA1\u7406");
		frame.setBounds(100, 100, 800, 520);

		
		int windowWidth = frame.getWidth(); //获得窗口宽
		int windowHeight = frame.getHeight(); //获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
		Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
		int screenWidth = screenSize.width; //获取屏幕的宽
		int screenHeight = screenSize.height; //获取屏幕的高
		frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示
		
		JLabel label = new JLabel("\u4F60\u9700\u8981\u589E\u52A0\u7684\u90E8\u95E8\u4FE1\u606F\uFF1A");
		label.setBounds(31, 17, 364, 107);
		label.setFont(new Font("宋体", Font.PLAIN, 30));
		
		JLabel lblNewLabel = new JLabel("\u90E8\u95E8\u4EE3\u53F7\uFF1A");
		lblNewLabel.setBounds(30, 132, 168, 47);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		
		JLabel label_1 = new JLabel("\u90E8\u95E8\u540D\u79F0\uFF1A");
		label_1.setBounds(30, 204, 168, 47);
		label_1.setFont(new Font("宋体", Font.PLAIN, 25));
		
		JLabel label_2 = new JLabel("\u90E8\u95E8\u4E3B\u4EFB\u4EE3\u53F7\uFF1A");
		label_2.setBounds(30, 279, 190, 47);
		label_2.setFont(new Font("宋体", Font.PLAIN, 25));
		
		JLabel label_3 = new JLabel("\u90E8\u95E8\u526F\u4E3B\u4EFB\u4EE3\u53F7\uFF1A");
		label_3.setBounds(30, 345, 207, 47);
		label_3.setFont(new Font("宋体", Font.PLAIN, 25));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(label);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(label_1);
		frame.getContentPane().add(label_2);
		frame.getContentPane().add(label_3);
		
		textField = new JTextField();
		textField.setBounds(225, 142, 157, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(225, 206, 157, 27);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(225, 284, 157, 27);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(225, 355, 157, 27);
		frame.getContentPane().add(textField_3);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Num = textField.getText();
				String Name = textField_1.getText();
				String a = textField_2.getText();
				String b = textField_3.getText();
				Insertdepartment.insert(Num, Name, a, b);
				JOptionPane.showMessageDialog(frame, "增加成功!");
				frame.dispose();
			}
		});
		button.setBounds(519, 385, 112, 69);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		button_1.setBounds(647, 385, 112, 69);
		frame.getContentPane().add(button_1);
	}

}
