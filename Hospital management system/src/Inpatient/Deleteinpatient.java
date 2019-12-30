package Inpatient;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Deleteinpatient {

	private JFrame frame;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deleteinpatient window = new Deleteinpatient();
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
	public Deleteinpatient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u75C5\u4EBA\u7BA1\u7406");
		frame.setBounds(100, 100, 800, 520);
		
		int windowWidth = frame.getWidth(); //获得窗口宽
		int windowHeight = frame.getHeight(); //获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
		Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
		int screenWidth = screenSize.width; //获取屏幕的宽
		int screenHeight = screenSize.height; //获取屏幕的高
		frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
		
		JLabel label = new JLabel("\u4F60\u9700\u8981\u5220\u9664\u7684\u75C5\u4EBA\u59D3\u540D\u4E3A\uFF1A");
		label.setBounds(10, 29, 307, 79);
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 92, 786, 391);
		frame.getContentPane().add(scrollPane);
		
		textField = new JTextField();
		textField.setBounds(304, 52, 249, 29);
		textField.setColumns(10);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(label);
		frame.getContentPane().add(textField);
		
		String[][] data=Show2.getRows();
		String[] dataTitle =Show2.getHead();
		table = new JTable(data,dataTitle);
		table.setFont(new Font("宋体", Font.PLAIN, 18));
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name = textField.getText();
				Delete2.delete(Name);
				JOptionPane.showMessageDialog(frame, "出院成功!");
				String[][] data=Show2.getRows();
				String[] dataTitle =Show2.getHead();
				table = new JTable(data,dataTitle);
				table.setFont(new Font("宋体", Font.PLAIN, 18));
				table.setRowHeight(25);
				scrollPane.setViewportView(table);
				table.setEnabled(false);
			}
		});
		btnNewButton.setBounds(579, 46, 88, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("\u91CD\u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		button.setBounds(677, 46, 88, 40);
		frame.getContentPane().add(button);
	}

}
