package tool;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * 
 * @author Dogrong
 * ªÊ÷∆Õº∆¨
 */
public class Image {
	public static  BufferedImage getImg(String path) {
		try {
			BufferedImage img = ImageIO.read(Image.class.getResource(path));
			return img;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
