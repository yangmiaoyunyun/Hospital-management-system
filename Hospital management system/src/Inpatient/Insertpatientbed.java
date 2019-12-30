package Inpatient;

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

public class Insertpatientbed {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insertpatientbed window = new Insertpatientbed();
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
	public Insertpatientbed() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5E8A\u4F4D\u7BA1\u7406");
		frame.setBounds(100, 100, 800, 520);
		
		int windowWidth = frame.getWidth(); //获得窗口宽
		int windowHeight = frame.getHeight(); //获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
		Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
		int screenWidth = screenSize.width; //获取屏幕的宽
		int screenHeight = screenSize.height; //获取屏幕的高
		frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
		
		JLabel label = new JLabel("\u4F60\u9700\u8981\u589E\u52A0\u7684\u5E8A\u4F4D\u4FE1\u606F\uFF1A");
		label.setBounds(26, 29, 422, 104);
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		
		JLabel label_1 = new JLabel("\u5E8A\u4F4D\u53F7\uFF1A");
		label_1.setBounds(34, 170, 119, 29);
		label_1.setFont(new Font("宋体", Font.PLAIN, 25));
		
		JLabel label_2 = new JLabel("\u5E8A\u4F4D\u72B6\u6001\uFF1A");
		label_2.setBounds(34, 294, 151, 29);
		label_2.setFont(new Font("宋体", Font.PLAIN, 25));
		
		textField = new JTextField();
		textField.setBounds(165, 170, 168, 29);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(165, 294, 168, 29);
		textField_1.setColumns(10);
		frame.getContentPane().setLayout(null);
		
		JLabel label_3 = new JLabel("\u7A7A\u95F2/\u6709\u4EBA");
		label_3.setBounds(337, 294, 151, 29);
		label_3.setFont(new Font("宋体", Font.PLAIN, 25));
		frame.getContentPane().add(label_3);
		frame.getContentPane().add(label);
		frame.getContentPane().add(label_2);
		frame.getContentPane().add(textField_1);
		frame.getContentPane().add(label_1);
		frame.getContentPane().add(textField);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				String Num = textField.getText();
				@SuppressWarnings("unused")
				String State = textField_1.getText();
				Insert3.insert(Num, State);
				JOptionPane.showMessageDialog(frame, "增加成功!");
				frame.dispose();
			}
		});
		button.setBounds(445, 384, 134, 65);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		button_1.setBounds(606, 384, 134, 65);
		frame.getContentPane().add(button_1);
	}
}
