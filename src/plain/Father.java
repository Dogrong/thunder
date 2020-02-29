package plain;

import java.awt.image.BufferedImage;
/**
 * 
 * @author Dogrong
 *飞机类的总父类。
 *节省代码量
 */
public class Father {
	protected BufferedImage img;
	protected int x,y,widht,height,hp;
	public BufferedImage getImg() {
		return img;
	}
	public void setImg(BufferedImage img) {
		this.img = img;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidht() {
		return widht;
	}
	public void setWidht(int widht) {
		this.widht = widht;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
}
