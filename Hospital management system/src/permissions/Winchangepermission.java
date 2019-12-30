package permissions;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Winchangepermission {

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
					Winchangepermission window = new Winchangepermission();
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
	public Winchangepermission() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u6743\u9650\u7BA1\u7406");
		frame.setBounds(100, 100, 800, 520);

		
		int windowWidth = frame.getWidth(); //获得窗口宽
		int windowHeight = frame.getHeight(); //获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
		Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
		int screenWidth = screenSize.width; //获取屏幕的宽
		int screenHeight = screenSize.height; //获取屏幕的高
		frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示
		
		JLabel label = new JLabel("\u4F60\u9700\u8981\u4FEE\u6539\u7684\u6743\u9650\u7528\u6237\u540D\uFF1A");
		label.setBounds(31, 17, 341, 107);
		label.setFont(new Font("宋体", Font.PLAIN, 28));
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setBounds(31, 132, 112, 47);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		
		JLabel label_1 = new JLabel("\u53E3\u4EE4\uFF1A");
		label_1.setBounds(31, 226, 113, 47);
		label_1.setFont(new Font("宋体", Font.PLAIN, 25));
		
		JLabel label_2 = new JLabel("\u6743\u9650\uFF1A");
		label_2.setBounds(31, 321, 102, 47);
		label_2.setFont(new Font("宋体", Font.PLAIN, 25));
		
		textField = new JTextField();
		textField.setBounds(147, 142, 157, 27);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(147, 235, 157, 27);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(147, 330, 157, 27);
		textField_2.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setBounds(519, 385, 112, 69);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name = textField.getText();
				String Num = textField_1.getText();
				String root = textField_2.getText();
				String S = textField_3.getText();
				Changepermission.change(S, Name, Num, root);
				JOptionPane.showMessageDialog(frame, "修改成功!");
				frame.dispose();
			}
		});
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.setBounds(647, 385, 112, 69);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(label);
		frame.getContentPane().add(button);
		frame.getContentPane().add(button_1);
		frame.getContentPane().add(label_1);
		frame.getContentPane().add(label_2);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(textField_1);
		frame.getContentPane().add(textField_2);
		frame.getContentPane().add(textField);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(363, 54, 199, 27);
		frame.getContentPane().add(textField_3);
	}

}
