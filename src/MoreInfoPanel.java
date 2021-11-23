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

import Database.CountryDB;

public class MoreInfoPanel extends JPanel {
	private JTextField textField;
	private JComboBox riskBoxArea;
	private JTextField textField_location;
	private JTextField textField_press;
	private JTextField textField_language;
	private JTextField textField_area;
	private JTextField textField_m_g;
	private MainPanel mainPanel;


	public MoreInfoPanel(JFrame frame, MainPanel mainPanel) {
		super();
		panelInit(frame);
		mainPanel.setVisible(false);
		this.mainPanel = mainPanel;
	}

	private void panelInit(JFrame frame) {
		this.setBackground(new Color(225, 240, 255));
		this.setBounds(0, 0, 750, 500);
		frame.getContentPane().add(this);
		this.setLayout(null);

		JLabel CountryLabel = new JLabel("More Information");

		CountryLabel.setFont(new Font("Arial", Font.BOLD, 35));
		CountryLabel.setForeground(new Color(0, 35, 110));
		CountryLabel.setHorizontalAlignment(JLabel.CENTER);
		CountryLabel.setBounds(120, 5, 500, 40);
		this.add(CountryLabel);
		
		JLabel locationLabel = new JLabel("위치");
	      locationLabel.setBackground(Color.WHITE);
	      locationLabel.setBounds(49, 75, 57, 28);
	         add(locationLabel);

	         JTextArea textArea_location = new JTextArea();
	         textArea_location.setBounds(118, 75, 476, 28);
	         add(textArea_location);

	         
	         JLabel pressLabel = new JLabel("언론");
	         pressLabel.setBackground(Color.WHITE);
	         pressLabel.setBounds(49, 135, 57, 28);
	         add(pressLabel);
	         
	         JTextArea textArea_press = new JTextArea();

	         textArea_press.setBounds(118, 135, 476, 28);
	         add(textArea_press);
	         
	         JLabel langLabel = new JLabel("언어");
	         langLabel.setBackground(Color.WHITE);
	         langLabel.setBounds(49, 195, 57, 28);
	         add(langLabel);
	         
	         JTextArea textArea_language = new JTextArea();

	         textArea_language.setBounds(118, 195, 476, 28);
	         add(textArea_language);
	         
	         JLabel areaLabel = new JLabel("면적");
	         areaLabel.setBackground(Color.WHITE);
	         areaLabel.setBounds(49, 255, 57, 28);
	         add(areaLabel);
	         
	         JTextArea textArea_area = new JTextArea();

	         textArea_area.setBounds(118, 255, 476, 28);
	         add(textArea_area);
	         
	         JLabel m_gLabel = new JLabel("주요 민족");
	         m_gLabel.setBackground(Color.WHITE);
	         m_gLabel.setBounds(49, 315, 57, 28);
	         add(m_gLabel);
	         
	         JTextArea textArea_m_g = new JTextArea();
	         textArea_m_g.setBounds(118, 315, 476, 28);
	         add(textArea_m_g);
	      
	      JButton btnApply = new JButton("적용");
	         btnApply.addActionListener(new ActionListener() {

	          
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            // TODO Auto-generated method stub
	            String Area;
	          
	          ResultSet rs;
	          
	          Area = MainPanel.Area;
	          CountryDB pollution = new CountryDB();
	         rs = pollution.getCountryDataWith_St(Area);
	         try {
	            rs.next();
	            if (rs.getString("Press") == null)
	               textArea_press.setText("");
	            else
	               textArea_press.setText((String) (rs.getString("Code")));

	            if (rs.getString("Language") == null)
	               textArea_language.setText("");
	            else
	               textArea_language.setText((String) (rs.getString("Language")));

	            if (rs.getString("Area") == null)
	               textArea_area.setText("");
	            else
	               textArea_area.setText((String) (rs.getString("Area")));

	            if (rs.getString("Major Ethnic Group") == null)
	               textArea_m_g.setText("");
	            else
	               textArea_m_g.setText((String) (rs.getString("Major Ethnic Group")));
	            
	            if (rs.getString("Location") == null)
	               textArea_location.setText("");
	            else
	               textArea_location.setText((String) (rs.getString("Location")));
	            

	         } catch (SQLException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	         }

	      }

	      private String String(JComboBox areaBox) {
	         return null;
	      }

	         
	            
	         });
	         btnApply.setBounds(498, 370, 126, 23);
	         this.add(btnApply);
	      
	      JButton btnBack = new JButton("뒤 로");
			btnBack.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					mainPanel.setVisible(true);
				}
			});
			
			btnBack.setBounds(498, 400, 126, 23);
			this.add(btnBack);
	}


}