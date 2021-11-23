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

		// 지역별 오염도 화면 타이틀
		JLabel CompareNewLabel = new JLabel("Religion Compare");
		CompareNewLabel.setFont(new Font("Arial", Font.BOLD, 35));
		CompareNewLabel.setForeground(new Color(0, 35, 110));
		CompareNewLabel.setHorizontalAlignment(JLabel.CENTER);
		CompareNewLabel.setBounds(120, 5, 500, 40);
		this.add(CompareNewLabel);
		
		String Arealist[] = new String[226];
		CountryDB country = new CountryDB();
		Arealist = country.getCountryDataWith_Name();
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

	}

	private void graphInit() {
		Graphstick = new RelGraphStick();
		Graphstick.setBorder(BorderFactory.createLineBorder(new Color(0, 35, 110)));
		Graphstick.setBackground(Color.white);
		Graphstick.setBounds(140, 80, 447, 214);
		this.add(Graphstick);
	}
}
