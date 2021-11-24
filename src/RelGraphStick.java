
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class RelGraphStick extends JPanel {

	private int Christian = 0;
	private int Catholic = 0;
	private int Islam = 0;
	private int Buddhism = 0;
	private int Hinduism = 0;
	private int ETC = 0;

	public void setChristian(int x) {
		this.Christian = x;
	}

	public void setCatholic(int x) {
		this.Catholic = x;
	}

	public void setIslam(int x) {
		this.Islam = x;
	}

	public void setBuddhism(int x) {
		this.Buddhism = x;
	}

	public void setHinduism(int x) {
		this.Hinduism = x;
	}

	public void setETC(int x) {
		this.ETC = x;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.BLACK);// 글자
		g.drawString("Christian", 5, 20);
		g.setColor(Color.PINK);
		g.fillRect(80, 7, Christian, 20);

		g.setColor(Color.BLACK);
		g.drawString("Catholic", 5, 50);
		g.setColor(new Color(255, 150, 150));
		g.fillRect(80, 37, Catholic, 20);

		g.setColor(Color.BLACK);
		g.drawString("Islam", 5, 80);
		g.setColor(Color.ORANGE);
		g.fillRect(80, 67, Islam, 20);

		g.setColor(Color.BLACK);
		g.drawString("Buddhism", 5, 110);
		g.setColor(new Color(100, 255, 100));
		g.fillRect(80, 97, Buddhism, 20);

		g.setColor(Color.BLACK);
		g.drawString("Hinduism", 5, 140);
		g.setColor(new Color(140, 155, 255));
		g.fillRect(80, 127, Hinduism, 20);

		g.setColor(Color.BLACK);
		g.drawString("ETC", 5, 170);
		g.setColor(new Color(210, 150, 255));
		g.fillRect(80, 157, ETC, 20);

		g.setColor(Color.BLACK);
		g.drawString("0", 80, 210);
		g.setColor(Color.BLACK);
		g.drawString("10", 105, 210);
		g.setColor(Color.BLACK);
		g.drawString("20", 138, 210);
		g.setColor(Color.BLACK);
		g.drawString("30", 170, 210);
		g.setColor(Color.BLACK);
		g.drawString("40", 200, 210);
		g.setColor(Color.BLACK);
		g.drawString("50", 233, 210);
		g.setColor(Color.BLACK);
		g.drawString("60", 266, 210);
		g.setColor(Color.BLACK);
		g.drawString("70", 300, 210);
		g.setColor(Color.BLACK);
		g.drawString("80", 330, 210);
		g.setColor(Color.BLACK);
		g.drawString("90", 360, 210);
		g.setColor(Color.BLACK);
		g.drawString("100", 390, 210);

		g.drawLine(80, 195, 400, 195);

		int xx = 80;
		for (int i = 0; i <= 10; i++) {
			g.drawLine(xx, 190, xx, 195);
			xx = xx + 32;
		}
	}
}
