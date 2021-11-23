import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Database.PollutionDB;

public class MoreInfoPanel extends JPanel {
	private JTextField textField;
	private JComboBox riskBoxArea;
	//private GraphRiskPollution GraphRiskpanel;
	private RiskPollutuin_image Imagepanel;
	private JTextField textField_location;
	private JTextField textField_press;
	private JTextField textField_language;
	private JTextField textField_area;
	private JTextField textField_m_g;


	public MoreInfoPanel(JFrame frame) {
		super();
		panelInit(frame);
//		graphInit();
//		imageInit();
	}

	private void panelInit(JFrame frame) {
		this.setBackground(new Color(225, 240, 255));
		this.setBounds(0, 0, 750, 500);
		frame.getContentPane().add(this);
		this.setLayout(null);

		JLabel PollutionLabel = new JLabel("More Information");

		PollutionLabel.setFont(new Font("Arial", Font.BOLD, 35));
		PollutionLabel.setForeground(new Color(0, 35, 110));
		PollutionLabel.setHorizontalAlignment(JLabel.CENTER);
		PollutionLabel.setBounds(120, 5, 500, 40);
		this.add(PollutionLabel);
		
		JLabel locationLabel = new JLabel("위치");
		locationLabel.setBackground(Color.WHITE);
		locationLabel.setBounds(49, 75, 57, 28);
	      add(locationLabel);
	      
	      textField_location = new JTextField();
	      textField_location.setBounds(118, 75, 476, 28);
	      add(textField_location);
	      textField_location.setColumns(10);
	      
	      JLabel pressLabel = new JLabel("언론");
	      pressLabel.setBackground(Color.WHITE);
	      pressLabel.setBounds(49, 135, 57, 28);
	      add(pressLabel);
	      
	      textField_press = new JTextField();
	      textField_press.setColumns(10);
	      textField_press.setBounds(118, 135, 476, 28);
	      add(textField_press);
	      
	      JLabel langLabel = new JLabel("언어");
	      langLabel.setBackground(Color.WHITE);
	      langLabel.setBounds(49, 195, 57, 28);
	      add(langLabel);
	      
	      textField_language = new JTextField();
	      textField_language.setColumns(10);
	      textField_language.setBounds(118, 195, 476, 28);
	      add(textField_language);
	      
	      JLabel areaLabel = new JLabel("면적");
	      areaLabel.setBackground(Color.WHITE);
	      areaLabel.setBounds(49, 255, 57, 28);
	      add(areaLabel);
	      
	      textField_area = new JTextField();
	      textField_area.setColumns(10);
	      textField_area.setBounds(118, 255, 476, 28);
	      add(textField_area);
	      
	      JLabel m_gLabel = new JLabel("주요 민족");
	      m_gLabel.setBackground(Color.WHITE);
	      m_gLabel.setBounds(49, 315, 57, 28);
	      add(m_gLabel);
	      
	      textField_m_g = new JTextField();
	      textField_m_g.setColumns(10);
	      textField_m_g.setBounds(118, 315, 476, 28);
	      add(textField_m_g);

	}


}