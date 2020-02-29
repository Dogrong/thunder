package plain;

import java.util.Random;

import tool.Image;
/**
 * 
 * @author Dogrong
 *敌机
 *x坐标为随机值
 *hp等于0到护甲值得随机数
 *每次走mo的值
 */
public class F_22 extends Father{
	private final int mo=7;
	
	public F_22(int armor) {
		super();
		// TODO Auto-generated constructor stub
		img=Image.getImg("/image/F-22.png");
		Random ran = new Random();
		this.widht=img.getWidth();
		this.height=img.getHeight();
		this.y=0-this.height;
		this.x=ran.nextInt(500-this.widht);
		this.hp=ran.nextInt(armor);
	}
	public void move() {
		this.y+=mo;
	}
}
