package jobs;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Hospital.index;

public class Winjobs {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Winjobs window = new Winjobs();
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
	public Winjobs() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5C97\u4F4D\u7BA1\u7406");
		frame.setBounds(100, 100, 800, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int windowWidth = frame.getWidth(); //获得窗口宽
		int windowHeight = frame.getHeight(); //获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
		Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
		int screenWidth = screenSize.width; //获取屏幕的宽
		int screenHeight = screenSize.height; //获取屏幕的高
		frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 69, 784, 424);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		scrollPane.setViewportView(textArea);
		textArea.append("进入岗位信息管理系统\n");
		
		JButton btnNewButton = new JButton("\u589E\u52A0\u5C97\u4F4D");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wininsertjobs.start();
				textArea.append("增加岗位信息成功\n");
			}
		});
		btnNewButton.setBounds(0, 0, 131, 70);
		
		JButton button = new JButton("\u5220\u9664\u5C97\u4F4D");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Windeletejobs.start();
				textArea.append("删除岗位信息成功\n");
			}
		});
		button.setBounds(129, 0, 131, 70);
		
		JButton button_1 = new JButton("\u4FEE\u6539\u5C97\u4F4D");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Winchangejobs.start();
				textArea.append("岗位信息修改成功\n");
			}
		});
		button_1.setBounds(259, 0, 131, 70);
		
		JButton button_2 = new JButton("\u67E5\u8BE2\u5C97\u4F4D");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Winselectjobs.start();
				textArea.append("查询岗位信息成功\n");
			}
		});
		button_2.setBounds(389, 0, 131, 70);
		
		JButton button_3 = new JButton("\u663E\u793A\u6240\u6709\u5C97\u4F4D");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Winshowjobs.start();
				textArea.append("显示岗位信息成功\n");
			}
		});
		button_3.setBounds(519, 0, 131, 70);
		
		JButton button_4 = new JButton("\u8FD4\u56DE\u4E3B\u83DC\u5355");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				index.start();
			}
		});
		button_4.setBounds(649, 0, 131, 70);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(button);
		frame.getContentPane().add(button_1);
		frame.getContentPane().add(button_2);
		frame.getContentPane().add(button_3);
		frame.getContentPane().add(button_4);
	}

}
