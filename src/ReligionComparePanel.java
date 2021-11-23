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

import Database.PollutionDB;

public class ReligionComparePanel extends JPanel {
	private JComboBox comboBoxArea;
	private RelGraphStick Graphstick;

	public ReligionComparePanel(JFrame frame) {
		super();
		panelInit(frame);
		graphInit();

	}

	private void panelInit(JFrame frame) {
		this.setBackground(new Color(140, 240, 200));
		this.setBounds(0, 0, 750, 500);
		frame.getContentPane().add(this);
		this.setLayout(null);

		// 지역별 오염도 화면 타이틀
		JLabel CompareNewLabel = new JLabel("Religion Compare");
		CompareNewLabel.setFont(new Font("Arial", Font.BOLD, 35));
		CompareNewLabel.setForeground(new Color(0, 35, 110));
		CompareNewLabel.setHorizontalAlignment(JLabel.CENTER);
		CompareNewLabel.setBounds(120, 5, 500, 40);
		this.add(CompareNewLabel);

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

		//// 지역선택1
		comboBoxArea = new JComboBox(Arealist);
		comboBoxArea.setBounds(220, 340, 116, 19);
		this.add(comboBoxArea);

		JLabel A_compareLabel = new JLabel("Country");
		A_compareLabel.setBounds(170, 340, 57, 15);
		this.add(A_compareLabel);

		JButton btnApply = new JButton("국가 적용");
		btnApply.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String Area;// 지역

				ResultSet rs;

				// 지역값 받아오기
				Area = (String) comboBoxArea.getSelectedItem();

				// 데이터 불러오기
				PollutionDB pollution = new PollutionDB();
				rs = pollution.getPollutionDataWith_St(Area);

				try {
					rs.next();
					if (rs.getString("Christian") == null)
						Graphstick.setChristian(0);
					else
						Graphstick.setChristian((int) (Double.parseDouble(rs.getString("Christian"))*3.2));

					if (rs.getString("Catholic") == null)
						Graphstick.setCatholic(0);
					else
						Graphstick.setCatholic((int) (Double.parseDouble(rs.getString("Catholic"))*3.2));

					if (rs.getString("Islam") == null)
						Graphstick.setIslam(0);
					else
						Graphstick.setIslam((int) (Double.parseDouble(rs.getString("Islam"))*3.2));

					if (rs.getString("Buddhism") == null)
						Graphstick.setBuddhism(0);
					else
						Graphstick.setBuddhism((int) (Double.parseDouble(rs.getString("Buddhism"))*3.2));

					if (rs.getString("Hinduism") == null)
						Graphstick.setHinduism(0);
					else
						Graphstick.setHinduism((int) (Double.parseDouble(rs.getString("Hinduism"))*3.2));

					if (rs.getString("ETC") == null)
						Graphstick.setETC(0);
					else
						Graphstick.setETC((int) (Double.parseDouble(rs.getString("ETC"))*3.2));

					Graphstick.setVisible(true);

					Graphstick.repaint();

					

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			private String String(JComboBox areaBox) {
				return null;
			}
		});
		btnApply.setBounds(420, 340, 126, 23);
		this.add(btnApply);

	}

	private void graphInit() {
		Graphstick = new RelGraphStick();
		Graphstick.setBorder(BorderFactory.createLineBorder(new Color(0, 35, 110)));
		Graphstick.setBackground(Color.white);
		Graphstick.setBounds(140, 80, 447, 214);
		this.add(Graphstick);
	}
}
