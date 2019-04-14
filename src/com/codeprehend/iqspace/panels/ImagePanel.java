package com.codeprehend.iqspace.panels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.codeprehend.iqspace.util.ImageSettings;


public class ImagePanel extends JPanel{

	/**
	 * default serial number
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image;

	public ImagePanel(String testName, Long numberOfQuestion) {
		try {                
			//          image = ImageIO.read(new File("C:\\Mihaela\\Other projects\\StartupActivator\\Jocuri\\IQSpaceTest\\Square Aria and Perimeter.png"));
			//          image = ImageIO.read(new File("C:\\Mihaela\\Other projects\\StartupActivator\\Jocuri\\umbre\\de umbre.jpg"));
			image = ImageIO.read(new File(
					ImageSettings.IMAGES_LOCATION + "\\" + testName + "Q" + numberOfQuestion + ".png"));
		} catch (IOException ex) {
			// handle exception...
		}
	}

	public ImagePanel(byte[] imageByte) {
		try {                
			if (imageByte != null)
				image = ImageIO.read(new ByteArrayInputStream(imageByte));
		} catch (IOException ex) {
			// handle exception...
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
	}

}