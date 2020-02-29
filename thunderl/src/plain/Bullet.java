package plain;

import tool.Image;

public class Bullet extends Father{
	private final int mo=30;
	public Bullet(int x,int y) {
		super();
		// TODO Auto-generated constructor stub
		this.img=Image.getImg("/image/J_bullet.png");
		this.x=x;
		this.y=y;
		this.widht=img.getWidth();
		this.height=img.getHeight();
	}
	public void move() {
		this.y-=mo;
	}
}
