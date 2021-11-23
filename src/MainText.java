
import javax.swing.JPanel;
import javax.swing.JTextArea;

class MainText extends JPanel {

	private String Code = "";
	private String Capital = "";
	private String Climate = "";
	private String Major_city = "";
	JTextArea txtResult = new JTextArea();

	public void setCode(String str) {
		this.Code = str;
	}

	public void setCapital(String str) {
		this.Capital = str;
	}

	public void setClimate(String str) {
		this.Climate = str;
	}

	public void setMajor_city(String str) {
		this.Major_city = str;
	}


}
