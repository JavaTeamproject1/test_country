import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Database.PollutionDB;

public class MainPanel extends JPanel {
	private JButton btnNewButton;
	private JButton btnGraphType;
	private MainText Text1;
	private MainGraph_Polygonal Graphpanel_2;
	private JComboBox main_month, main_date, AreaBox;

	public MainPanel(JFrame frame) {
		super();
		panelInit(frame);
//      graphInit();
//      graphInit_2();
	}

	private void panelInit(JFrame frame) {
		// 메인 화면 패널
		this.setBackground(new Color(225, 240, 255));
		this.setBounds(0, 0, 636, 360);
		frame.getContentPane().add(this);
		this.setLayout(null);

		// 메인 화면 라벨
		JLabel tilteLabel = new JLabel("Country Imformation");
		tilteLabel.setFont(new Font("Arial", Font.BOLD, 35));
		tilteLabel.setForeground(new Color(0, 35, 110));
		tilteLabel.setHorizontalAlignment(JLabel.CENTER);
		tilteLabel.setBounds(70, 4, 500, 40);
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
		lblSerch.setBounds(180, 290, 57, 15);
		this.add(lblSerch);

		// sample list
		String Arealist[] = { "가나", "가봉", "가이아나", "감비아", "건지", "과들루프", "과테말라", "괌", "교황청", "그레나다", "그리스", "그린란드", "기니",
				"기니비사우", "나미비아", "나우루", "나이지리아", "남수단", "남아프리카공화국", "네덜란드", "네덜란드령 안틸레스", "네팔", "노르웨이", "뉴 칼레도니아",
				"뉴질랜드", "니우에", "니제르", "니카라과", "덴마크", "도미니카공화국", "도미니카연방", "독일", "동티모르", "라오스", "라이베리아", "라트비아", "러시아",
				"레바논", "레소토", "레위니옹", "루마니아", "룩셈부르크", "르완다", "리비아", "리투아니아", "리히텐슈타인", "마다가스카르", "마르티니크", "마셜제도",
				"마요트", "마이크로네시아연방", "말라위", "말레이시아", "말리", "맨 섬", "멕시코", "모나코", "모로코", "모리셔스", "모리타니아", "모잠비크", "몬테네그로",
				"몬트세랫", "몰도바", "몰디브", "몰타", "몽골", "미국", "미얀마", "바누아투", "바레인", "바베이도스", "바하마", "방글라데시", "버뮤다", "베냉",
				"베네수엘라", "베트남", "벨기에", "벨라루스", "벨리즈", "보스니아헤르체고비나", "보츠와나", "볼리비아", "부룬디", "부르키나파소", "부탄", "북마리아나 군도",
				"북마케도니아", "불가리아", "브라질", "브루나이", "사모아", "사우디아라비아", "사이프러스", "사하라 아랍민주공화국(서부사하라)", "산마리노", "상투메프린시페",
				"생피에르·미클롱", "세네갈", "세르비아", "세이셸", "세인트 루시아", "세인트 빈센트 그레나딘", "세인트 키츠 네비스", "세인트 헬레나 섬", "소말리아", "솔로몬제도",
				"수단", "수리남", "스리랑카", "스웨덴", "스위스", "스페인", "슬로바키아", "슬로베니아", "시리아", "시에라리온", "싱가포르", "아랍에미리트", "아루바",
				"아르메니아", "아르헨티나", "아이슬란드", "아이티", "아일랜드", "아제르바이잔", "아프가니스탄", "안도라", "알바니아", "알제리", "앙골라", "앤티가바부다",
				"앵귈라", "에리트레아", "에스와티니", "에스토니아", "에콰도르", "에티오피아", "엘살바도르", "영국", "영국령 남극지역", "영국령 버진 아일랜드",
				"영국령 인도양 제도", "예멘", "오만", "오스트리아", "온두라스", "왈리스·퓌튀나", "요르단", "우간다", "우루과이", "우즈베키스탄", "우크라이나", "이라크",
				"이란", "이스라엘", "이집트", "이탈리아", "인도", "인도네시아", "일본", "자메이카", "잠비아", "저지", "적도기니", "조지아", "중국", "중앙아프리카공화국",
				"지부티", "지브롤터", "짐바브웨", "차드", "체코", "칠레", "카메룬", "카보베르데", "카자흐스탄", "카타르", "캄보디아", "캐나다", "케냐", "케이맨제도",
				"코모로", "코소보", "코스타리카", "코트디부아르", "콜롬비아", "콩고공화국", "콩고민주공화국(DR콩고)", "쿠바", "쿠웨이트", "쿡제도", "크로아티아", "키르기즈",
				"키리바시", "타이완", "타지키스탄", "탄자니아", "태국", "터크스·케이커스 제도", "터키", "토고", "통가", "투르크메니스탄", "투발루", "튀니지",
				"트리니다드토바고", "파나마", "파라과이", "파키스탄", "파푸아뉴기니", "팔라우", "팔레스타인", "페루", "포르투갈", "폴란드", "프랑스", "프랑스령 기아나",
				"프랑스령 폴리네시아", "피지", "핀란드", "필리핀", "핏케언 섬", "헝가리", "호주", "홍콩" };

		AreaBox = new JComboBox(Arealist);
		AreaBox.setBounds(240, 290, 116, 19);
		this.add(AreaBox);

		JLabel codeLabel = new JLabel("국가 코드");
		codeLabel.setBackground(Color.WHITE);
		codeLabel.setBounds(49, 73, 57, 28);
		add(codeLabel);

		JTextArea textArea_code = new JTextArea();
		textArea_code.setBounds(118, 73, 476, 28);
		add(textArea_code);

		JLabel capitalLabel = new JLabel("수도");
		capitalLabel.setBackground(Color.WHITE);
		capitalLabel.setBounds(49, 111, 57, 28);
		add(capitalLabel);

		JTextArea textArea_cap = new JTextArea();
		textArea_cap.setBounds(118, 111, 476, 28);
		add(textArea_cap);

		JLabel cliLabel = new JLabel("기후");
		cliLabel.setBackground(Color.WHITE);
		cliLabel.setBounds(49, 149, 57, 28);
		add(cliLabel);

		JTextArea textArea_cli = new JTextArea();
		textArea_cli.setBounds(118, 153, 476, 28);
		add(textArea_cli);

		JLabel m_cLabel = new JLabel("주요 도시");
		m_cLabel.setBackground(Color.WHITE);
		m_cLabel.setBounds(49, 187, 57, 28);
		add(m_cLabel);

		JTextArea textArea_m_c = new JTextArea();
		textArea_m_c.setBounds(118, 191, 476, 28);
		add(textArea_m_c);

		JButton btnApply = new JButton("국가 적용");
		btnApply.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String Area;// 지역

				ResultSet rs, rs1;

				// 지역값 받아오기
				Area = (String) AreaBox.getSelectedItem();

				// 데이터 불러오기
				PollutionDB pollution = new PollutionDB();
				rs = pollution.getPollutionDataWith_St(Area);
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

		btnApply.setBounds(498, 239, 126, 23);
		this.add(btnApply);

		// 종료 버튼
		JButton btnExit = new JButton("종료");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(498, 271, 126, 23);
		this.add(btnExit);

	}

}