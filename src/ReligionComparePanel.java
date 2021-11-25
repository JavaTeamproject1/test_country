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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Database.CountryDB;

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

		JLabel CompareNewLabel = new JLabel("Religion Compare");
		CompareNewLabel.setFont(new Font("Arial", Font.BOLD, 35));
		CompareNewLabel.setForeground(new Color(0, 35, 110));
		CompareNewLabel.setHorizontalAlignment(JLabel.CENTER);
		CompareNewLabel.setBounds(120, 5, 500, 40);
		this.add(CompareNewLabel);
		
		String Arealist[] = new String[226];
		CountryDB country = new CountryDB();
		Arealist = country.getCountryDataWith_Name();
		
		comboBoxArea = new JComboBox(Arealist);
		comboBoxArea.setBounds(220, 340, 116, 19);
		this.add(comboBoxArea);

		JLabel A_compareLabel = new JLabel("Country");
		A_compareLabel.setBounds(170, 340, 57, 15);
		this.add(A_compareLabel);

		JButton btnApply = new JButton("국가 적용");
		btnApply.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String Area;

				ResultSet rs;

				Area = (String) comboBoxArea.getSelectedItem();

				CountryDB pollution = new CountryDB();
				rs = pollution.getCountryDataWith_St(Area);

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
		
		JLabel langLabel = new JLabel("종교 정보");
        langLabel.setBackground(Color.WHITE);
        langLabel.setBounds(595, 80, 57, 28);
        add(langLabel);
		
		JButton btnChriCa = new JButton("Christian,Catholic");
		btnChriCa.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "1)\r\n"
						+ "성당에 들어가실 때에는 몸과 마음을 정화한다는 의미로 성당 문 입구에 놓여있는 성수를 찍으며 성수 기도를 바치고,"
						+ "\r\n성당 안에 들어오셔서 성호경을 외우며 십자성호를 긋고는 성당의 중심이고 예수 그리스도를 상징하는 제대를 향해 두 손을 모아 허리를 굽혀 깊은 절을 합니다.\r\n"
						+ "2)\r\n"
						+ "성당 안에서 이동시 제대 앞을 지나가실 때에는 제대랑 가까운 위치든 먼 위치든 반드시 제대 중앙에 서서 기도손 하고 제대를 향해 허리를 굽혀 깊은 절을 하고 지나가시고,"
						+ "\r\n감실과 가까운 위치에서는 감실 앞에 서서 기도손 하고 감실을 향해 허리를 굽혀 깊은 절을 하시면 됩니다.\r\n"
						+ "3)\r\n"
						+ "성당 안에서는 들어오고 나가실 때 중앙 통로를 이용하시면 안됩니다. 중앙 통로는 전례 중에만 이용하는 것이 원칙입니다.\r\n"
						+ "4)\r\n"
						+ "성당 안에서는 팔짱을 끼거나 뒷짐을 지거나 주머니에 손을 넣으시면 안되며, 다리를 꼬고 앉으셔도 안됩니다."
						+ "\r\n 또한 모자를 쓰신 경우에는 성당에 들어가실 때 탈모하셔야 합니다.","Christian,Catholic",JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnChriCa.setBounds(550, 120, 140, 23);
		this.add(btnChriCa);

		JButton btnIslam = new JButton("Islam");
		btnIslam.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "1) 인사\r\n"
						+ "무슬림들은 상대방보다 인사를 길게 하는 것을 미덕으로 생각하므로 다소 짜증나더라도 계속 인사를 받아서 해주는 것이 훨씬 친밀감을 높일 수 있습니다.\r\n"
						+ "\r\n"
						+ "무슬림들은 알라 외에는 고개를 숙여 인사를 하지 않고 악수로 대신하며, 보통 무슬림들은 친밀한 사이에는 서로 볼키스로 인사하기도 합니다."
						+ "\r\n인사 시 오른손을 왼쪽 가슴에 얹기도 하는데 이는 자신의 진실함과 친밀감을 표시하는 행위입니다.\r\n"
						+ "\r\n"
						+ "이슬람권 특히 사우디에서 여성에게 악수를 위해 손을 내미는 것은 금기시되며, 인사할 때 부인 또는 여성가족의 안부는 묻지 않는 것이 좋습니다.\r\n"
						+ "2) \r\n"
						+ "무슬림들은 오른손을 악수를 하거나 음식을 먹을 때, 선물을 주고 받을 때 등 좋은 일을 할 때 사용하고,"
						+ "\r\n왼손은 화장실에서 용변 후 씻을 때, 신발을 닦을 때, 코를 풀 때 등 궂은 일에 사용합니다. "
						+ "\r\n따라서, 물건을 주고 받을 때나 악수를 할 때 왼손을 사용하는 것은 매우 큰 실례인데, 왼손은 사탄과 관련된 부정한 것으로 인식하기 때문입니다..\r\n"
						+ "3) \r\n"
						+ "손으로 상대방을 가리키는 것은 무슬림 사회에서도 좋지 않은 예절로 평가됩니다."
						+ "\r\n기분 좋을 때나 의견이 똑같을 때 무슬림들은 간혹 오른손 바닥을 내미는데 이럴 경우에는 손바닥을 쳐주면 됩니다.\r\n"
						+ "4) \r\n"
						+ "여성을 똑바로 바라보는 것은 금기이며, 어른 앞에서 다리를 꼬고 있거나 발바닥을 상대방에게 보이는 행위,"
						+ "\r\n침을 뱉는 행위 등은 모두 예의 바르지 못한 행위로 간주됩니다.","Islam",JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnIslam.setBounds(550, 160, 140, 23);
		this.add(btnIslam);
		
		JButton btnBuddhism = new JButton("Buddhism");
		btnBuddhism.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "1)\r\n"
						+ "사찰에 갈 때는 화려한 치장을 피하고 검소한 옷차림으로 부처님에게 참배하는 경건한 마음을 지녀야 합니다.\r\n"
						+ "2)\r\n"
						+ "공양 시간을 잘 지키고 음식을 남기지 말아야 합니다.\r\n"
						+ "3)\r\n"
						+ "예배를 드릴 때는 법당 중앙을 피하고 측면에서 합니다.\r\n"
						+ "4)\r\n"
						+ "향이 이미 타고 있을 때는 사르지 말고 없을 때만 향을 사르되 한 개만 사르도록 합니다.\r\n"
						+ "5)\r\n"
						+ "경내에서 스님을 만나게 되면 반 배 하는 것이 상례입니다.\r\n"
						+ "6)\r\n"
						+ "법당 내에서 절대 소리 나게 걸어서는 안 됩니다.","Buddhism",JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnBuddhism.setBounds(550, 200, 140, 23);
		this.add(btnBuddhism);
		
		JButton btnHindusim = new JButton("Hindusim");
		btnHindusim.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "1)\r\n"
						+ "언쟁시 절대 먼저 폭력을 사용하지는 말아야 합니다.\r\n"
						+ "2)\r\n"
						+ "힌두신들이나 알라신등 인도인들이 섬기는 신들을 모독하는 언행을 삼가야 합니다."
						+ "\r\n(힌두교도들이 신으로 여기는 소를 가지고 농담을 삼거나 장난을 치는 경우 등 자제).\r\n"
						+ "또한, 힌두사원이나 회교사원 등을 방문시 반드시 경건한 자세로 관람해야 합니다.\r\n"
						+ "3)\r\n"
						+ "상대방에게 카스트(신분)를 직접적으로 묻는 행위는 자제해야 합니다.\r\n"
						+ "4)\r\n"
						+ "가슴이 파인 옷 또는 다리가 드러나는 옷을 입을 경우, 남성을 성적으로 유혹하는 행위로 오해받을 수 있습니다.\r\n"
						+ "5)\r\n"
						+ "집에 초대를 받았을 때는 선물을 준비하는 것이 예의이며, 주로 가벼운 제과제품 선물하며, 포장은 검정,흰색은 피하는게 좋습니다."
						+ "\r\n손님이 음식을 완전히 깨끗하게 먹는 것 보다는 조금 남기는 것을 좋아합니다."
						+ "\r\n음식을 남기는 것은 충분히 배가 부르다는 의미이고, 주인의 대접이 훌륭했다고 받아들이기도 합니다.\r\n"
						+ "6)\r\n"
						+ "손짓을 사용하여 사람을 부르는 것을 무례하다 생각하고, 1 ~ 1.2m의 적당한 거리를 두고\r\n"
						+ "대화하는 것을 편안하게 생각합니다. 또한 발에 대한 더러운 이미지를 갖고 있습니다."
						+ "\r\n발을 사용해서 사람을 가리키면 안되고, 실수로 다른 사람의 신체에 발이 닿았을 때에는 사과하는 것이 좋습니다.","Hindusim",JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnHindusim.setBounds(550, 240, 140, 23);
		this.add(btnHindusim);
	}

	private void graphInit() {
		Graphstick = new RelGraphStick();
		Graphstick.setBorder(BorderFactory.createLineBorder(new Color(0, 35, 110)));
		Graphstick.setBackground(Color.white);
		Graphstick.setBounds(70, 80, 447, 214);
		this.add(Graphstick);
	}
}
