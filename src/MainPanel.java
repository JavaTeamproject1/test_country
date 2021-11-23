import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Database.CountryDB;



public class MainPanel extends JPanel {
	private JButton btnNewButton;
	private JButton btnGraphType;
	private MainText Text1;
	private JComboBox main_month, main_date, AreaBox;
	private MainPanel MainPanel;
	private ReligionComparePanel ReligionComparePanel;
	private MoreInfoPanel MoreInfoPanel;
	protected static String Area = null;
	
	public MainPanel(JFrame frame) {
		super();
		panelInit(frame);
//      graphInit();
//      graphInit_2();
	}

	private void panelInit(JFrame frame) {
		// 메인 화면 패널
		this.setBackground(new Color(225, 240, 255));
		this.setBounds(0, 0, 750, 500);
		frame.getContentPane().add(this);
		this.setLayout(null);

		// 메인 화면 라벨
		JLabel tilteLabel = new JLabel("Country Imformation");
		tilteLabel.setFont(new Font("Arial", Font.BOLD, 35));
		tilteLabel.setForeground(new Color(0, 35, 110));
		tilteLabel.setHorizontalAlignment(JLabel.CENTER);
		tilteLabel.setBounds(120, 4, 500, 40);
		this.add(tilteLabel);

//      JLabel lblDay = new JLabel("날짜 입력");
//      lblDay.setBounds(27, 288, 57, 15);
//      this.add(lblDay);

		// 월
//      String MonthList[] = new String[12];
//      for (int m = 1; m < 13; m++) {
//         MonthList[m - 1] = Integer.toString(m) + "월";
//      }

//      main_month = new JComboBox(MonthList);
//      main_month.setBounds(96, 285, 116, 21);
//      main_month.setSize(new Dimension(55, 20));
//      this.add(main_month);

		// 날짜 리스트
//      String DateList[] = new String[31];
//      for (int d = 1; d < 32; d++) {
//         DateList[d - 1] = Integer.toString(d) + "일";
//      }

		// 일
//      main_date = new JComboBox(DateList);
//      main_date.setBounds(155, 285, 116, 21);
//      main_date.setSize(new Dimension(55, 20));
//      this.add(main_date);

		JLabel lblSerch = new JLabel("나라 검색");
		lblSerch.setBounds(180, 380, 57, 15);
		this.add(lblSerch);

		String Arealist[] = new String[226];
		CountryDB country = new CountryDB();
		Arealist = country.getCountryDataWith_Name();
		
		AreaBox = new JComboBox(Arealist);
		AreaBox.setBounds(240, 380, 116, 19);
		this.add(AreaBox);

		JLabel codeLabel = new JLabel("국가 코드");
		codeLabel.setBackground(Color.WHITE);
		codeLabel.setBounds(25, 40, 57, 28);
		add(codeLabel);

		JTextArea textArea_code = new JTextArea();
		textArea_code.setBounds(25, 70, 690, 28);
		add(textArea_code);

		JLabel capitalLabel = new JLabel("수도");
		capitalLabel.setBackground(Color.WHITE);
		capitalLabel.setBounds(25, 100, 57, 28);
		add(capitalLabel);

		JTextArea textArea_cap = new JTextArea();
		textArea_cap.setBounds(25, 130, 690, 28);
		add(textArea_cap);

		JLabel cliLabel = new JLabel("기후");
		cliLabel.setBackground(Color.WHITE);
		cliLabel.setBounds(25, 160, 57, 28);
		add(cliLabel);

		JTextArea textArea_cli = new JTextArea();
		textArea_cli.setBounds(25, 190, 690, 28);
		add(textArea_cli);

		JLabel m_cLabel = new JLabel("주요 도시");
		m_cLabel.setBackground(Color.WHITE);
		m_cLabel.setBounds(25, 220, 57, 28);
		add(m_cLabel);

		JTextArea textArea_m_c = new JTextArea();
		textArea_m_c.setBounds(25, 250, 690, 28);
		add(textArea_m_c);

		JButton btnApply = new JButton("국가 적용");
		btnApply.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

//				String Area;// 지역

				ResultSet rs, rs1;

				// 지역값 받아오기
				Area = (String) AreaBox.getSelectedItem();

				// 데이터 불러오기
				CountryDB country = new CountryDB();
				rs = country.getCountryDataWith_St(Area);
//            rs1 = pollution.getPollutionDataWith_Pg(main_check.getDate(), Area);

				try {
					rs.next();
					if (rs.getString("Code") == null)
						textArea_code.setText("");
					else
						textArea_code.setText((String) (rs.getString("Code")));

					if (rs.getString("Capital") == null)
						textArea_cap.setText("");
					else
						textArea_cap.setText((String) (rs.getString("Capital")));

					if (rs.getString("Climate") == null)
						textArea_cli.setText("");
					else
						textArea_cli.setText((String) (rs.getString("Climate")));

					if (rs.getString("Major city") == null)
						textArea_m_c.setText("");
					else
						textArea_m_c.setText((String) (rs.getString("Major city")));

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			private String String(JComboBox areaBox) {
				return null;
			}
		});

		btnApply.setBounds(498, 310, 126, 23);
		this.add(btnApply);

		// 종료 버튼
		JButton btnExit = new JButton("종료");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(498, 340, 126, 23);
		this.add(btnExit);
		
		JButton btnMore = new JButton("더 보기");
		btnMore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MoreInfoPanel = new MoreInfoPanel(frame, MainPanel.this);
				MoreInfoPanel.setVisible(true);
			}
		});
		
		btnMore.setBounds(498, 370, 126, 23);
		this.add(btnMore);

	}

}