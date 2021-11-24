
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Main {
	static JMenuBar mb;
	static JMenu x;
	static JMenuItem m1, m2, m3;
	
	private JFrame frame;

	public MainPanel Mainpanel;
	public ReligionComparePanel ReligionComparePanel;
	public CountryAddPanel CountryAddPanel;
	
	private void menuInit() { // 메뉴바 구현
		
		mb = new JMenuBar();
		mb.setBackground(new Color(0, 35, 110));
		x = new JMenu("Menu");
		x.setForeground(Color.WHITE);
		x.setFont(new Font("돋움", Font.BOLD, 15));

		m1 = new JMenuItem("Main Pannel");
		m2 = new JMenuItem("Religion Pannel");
		m3 = new JMenuItem("Add Country");

		x.add(m1);
		x.add(m2);
		x.add(m3);

		mb.add(x);
		frame.setJMenuBar(mb);
		frame.setSize(750, 500);
		frame.setVisible(true);

		m1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Mainpanel.setVisible(true);
				ReligionComparePanel.setVisible(false);
				CountryAddPanel.setVisible(false);
				Mainpanel.setMoreVisible(false);
				//MoreInfoPanel.setVisible(false);
			}
		});

		m2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Mainpanel.setVisible(false);
				ReligionComparePanel.setVisible(true);
				CountryAddPanel.setVisible(false);
				Mainpanel.setMoreVisible(false);
				//MoreInfoPanel.setVisible(false);
			}
		});

		m3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Mainpanel.setVisible(false);
				ReligionComparePanel.setVisible(false);
				CountryAddPanel.setVisible(true);
				Mainpanel.setMoreVisible(false);
				//MoreInfoPanel.setVisible(true);
			}
		});

	}

	private void frameInit() {
		frame.setTitle("Country Project");
		frame.setBounds(100, 100, 650, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}

	private void Initialize() {
		frameInit();
		menuInit();
		Mainpanel = new MainPanel(frame);
		ReligionComparePanel = new ReligionComparePanel(frame);
		ReligionComparePanel.setVisible(false);
		CountryAddPanel = new CountryAddPanel(frame);
		CountryAddPanel.setVisible(false);
	}

	public Main() {
		frame = new JFrame();
		Initialize();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
