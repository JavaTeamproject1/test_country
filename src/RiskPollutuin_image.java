import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class RiskPollutuin_image extends JPanel{
	BufferedImage img;

	public RiskPollutuin_image() {
		try {
			img = ImageIO.read(new File("image/image1.png"));
		}catch(IOException e) {
		}
	}
	public void paint(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img,0,0,null);
	}
}
