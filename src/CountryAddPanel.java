import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Database.CountryDB;
import Database.Create_CSV;

public class CountryAddPanel extends JPanel {
	private JTextField textField;
	private JComboBox riskBoxArea;
	private JTextField textField_location;
	private JTextField textField_press;
	private JTextField textField_language;
	private JTextField textField_area;
	private JTextField textField_m_g;
	private MainPanel mainPanel;
	private CountryDB db = new CountryDB();
	private Create_CSV csv = new Create_CSV(); 

	public CountryAddPanel(JFrame frame) {
		super();
		panelInit(frame);
	}

	private void panelInit(JFrame frame) {
		this.setBackground(new Color(225, 240, 255));
		this.setBounds(0, 0, 750, 500);
		frame.getContentPane().add(this);
		this.setLayout(null);

		JLabel Title = new JLabel("Add Country");

		Title.setFont(new Font("Arial", Font.BOLD, 35));
		Title.setForeground(new Color(0, 35, 110));
		Title.setHorizontalAlignment(JLabel.CENTER);
		Title.setBounds(120, 5, 500, 40);
		this.add(Title);
		
		JLabel CountryLabel = new JLabel("국가이름");
        CountryLabel.setBackground(Color.white);
        CountryLabel.setBounds(49,80,57,28);
        add(CountryLabel);
        
        JTextField textArea_Country = new JTextField();
        textArea_Country.setBounds(118, 80, 250, 28);
        add(textArea_Country);
        
		JLabel locationLabel = new JLabel("위치");
	    locationLabel.setBackground(Color.WHITE);
	    locationLabel.setBounds(49, 110, 57, 28);
	    add(locationLabel);

	    JTextField textArea_location = new JTextField();
	    textArea_location.setBounds(118, 110, 250, 28);
	    add(textArea_location);

	         
	    JLabel pressLabel = new JLabel("언론");
	    pressLabel.setBackground(Color.WHITE);
	    pressLabel.setBounds(49, 140, 57, 28);
	    add(pressLabel);
	         
	    JTextField textArea_press = new JTextField();
	    textArea_press.setBounds(118, 140, 250, 28);
	    add(textArea_press);
	         
	    JLabel langLabel = new JLabel("언어");
        langLabel.setBackground(Color.WHITE);
	    langLabel.setBounds(49, 170, 57, 28);
	    add(langLabel);
	         
	    JTextField textArea_language = new JTextField();

	    textArea_language.setBounds(118, 170, 250, 28);
	    add(textArea_language);
	         
	    JLabel areaLabel = new JLabel("면적");
	    areaLabel.setBackground(Color.WHITE);
	    areaLabel.setBounds(49, 200, 57, 28);
	    add(areaLabel);
	         
	    JTextField textArea_area = new JTextField();

	    textArea_area.setBounds(118, 200, 250, 28);
	    add(textArea_area);
	         
	    JLabel m_gLabel = new JLabel("주요 민족");
	    m_gLabel.setBackground(Color.WHITE);
	    m_gLabel.setBounds(49, 230, 57, 28);
	    add(m_gLabel);
	         
	    JTextField textArea_m_g = new JTextField();
	    textArea_m_g.setBounds(118, 230, 250, 28);
	    add(textArea_m_g);
	         
	    JLabel codeLabel = new JLabel("국가 코드");
	    codeLabel.setBackground(Color.WHITE);
	    codeLabel.setBounds(49, 260, 57, 28);
	    add(codeLabel);
	         
	    JTextField textArea_code = new JTextField();
	    textArea_code.setBounds(118, 260, 250, 28);
	    add(textArea_code);
	         
	    JLabel capitalLabel = new JLabel("수도");
	    capitalLabel.setBackground(Color.WHITE);
	    capitalLabel.setBounds(49, 290, 57, 28); 
	    add(capitalLabel);
	         
	    JTextField textArea_capital = new JTextField();
	    textArea_capital.setBounds(118, 290, 250, 28);
        add(textArea_capital);
	         
	    JLabel climateLabel = new JLabel("기후");
	    climateLabel.setBackground(Color.WHITE);
	    climateLabel.setBounds(49, 320, 57, 28);
	    add(climateLabel);
	         
	    JTextField textArea_climate = new JTextField();
	    textArea_climate.setBounds(118, 320, 250, 28);
	    add(textArea_climate);
	         
	    JLabel m_cLabel = new JLabel("주요 도시");
	    m_cLabel.setBackground(Color.WHITE);
	    m_cLabel.setBounds(49, 350, 57, 28);
	    add(m_cLabel);
	         
	    JTextField textArea_m_c = new JTextField();
	    textArea_m_c.setBounds(118, 350, 250, 28);
	    add(textArea_m_c);
	         
	    JLabel religionLabel = new JLabel("종교(숫자 입력)");
	    religionLabel.setBackground(Color.WHITE);
	    religionLabel.setBounds(550, 50, 100, 28);
	    add(religionLabel);
	         
	    JLabel christianLabel = new JLabel("Christian");
	    christianLabel.setBackground(Color.WHITE);
	    christianLabel.setBounds(400, 80, 57, 28);
	    add(christianLabel);
	         
	    JTextField textArea_christian = new JTextField();
	    textArea_christian.setBounds(460, 80, 250, 28);
	    add(textArea_christian);
	         
	    JLabel catholicLabel = new JLabel("Catholic");
	    catholicLabel.setBackground(Color.WHITE);
	    catholicLabel.setBounds(400, 110, 57, 28);
	    add(catholicLabel);
	         
	    JTextField textArea_catholic = new JTextField();
	    textArea_catholic.setBounds(460, 110, 250, 28);
	    add(textArea_catholic);
	         
	    JLabel islamLabel = new JLabel("Islam");
	    islamLabel.setBackground(Color.WHITE);
	    islamLabel.setBounds(400, 140, 57, 28);
	    add(islamLabel);
	         
	    JTextField textArea_islam = new JTextField();
	    textArea_islam.setBounds(460, 140, 250, 28);
	    add(textArea_islam);
	         
	    JLabel buddhismLabel = new JLabel("Buddhism");
	    buddhismLabel.setBackground(Color.WHITE);
	    buddhismLabel.setBounds(400, 170, 57, 28);
	    add(buddhismLabel);
	         
	    JTextField textArea_buddhism = new JTextField();
	    textArea_buddhism.setBounds(460, 170, 250, 28);
	    add(textArea_buddhism);
	         
	    JLabel hinduismLabel = new JLabel("Hinduism");
	    hinduismLabel.setBackground(Color.WHITE);
	    hinduismLabel.setBounds(400, 200, 57, 28);
	    add(hinduismLabel);
	         
	    JTextField textArea_hinduism = new JTextField();
	    textArea_hinduism.setBounds(460, 200, 250, 28);
	    add(textArea_hinduism);
	         
	    JLabel ETCLabel = new JLabel("ETC");
	    ETCLabel.setBackground(Color.WHITE);
	    ETCLabel.setBounds(400, 230, 57, 28);
	    add(ETCLabel);
	         
	    JTextField textArea_ETC = new JTextField();
	    textArea_ETC.setBounds(460, 230, 250, 28);
	    add(textArea_ETC);
	    
	    JButton btnApply = new JButton("추가");
	    btnApply.addActionListener(new ActionListener() {
	        	 
	         
	         @Override
	         public void actionPerformed(ActionEvent e) {
	
	        	 String[] world = new String[16];
	        	 world[0] = textArea_Country.getText();
	        	 world[1] = textArea_code.getText();
	        	 world[2] = textArea_capital.getText();
	        	 world[3] = textArea_climate.getText();
	        	 world[4] = textArea_location.getText();
	        	 world[5] = textArea_m_c.getText();
	        	 world[6] = textArea_m_g.getText();
	        	 world[7] = textArea_press.getText();
	        	 world[8] = textArea_area.getText();
	        	 world[9] = textArea_language.getText();
	        	 world[10] = textArea_christian.getText();
	        	 world[11] = textArea_catholic.getText();
	        	 world[12] = textArea_islam.getText();
	        	 world[13] = textArea_buddhism.getText();
	        	 world[14] = textArea_hinduism.getText();
	        	 world[15] = textArea_ETC.getText();
	        	 
	        	 db.SaveDb(world);
	        	 JOptionPane.showMessageDialog(null, "추가 되었습니다.");
	         } 
	     });
	         btnApply.setBounds(498, 370, 126, 23);
	         this.add(btnApply);
	         
	         JButton btnCreateF = new JButton("Create File");
	         btnApply.addActionListener(new ActionListener() {
	        	 
	         
	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	 csv.SaveCSV();
	         }

	     });
	         btnCreateF.setBounds(498, 400, 126, 23);
	         this.add(btnCreateF);

	}
}
