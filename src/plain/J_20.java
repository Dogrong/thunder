package plain;


import tool.Image;
/**
 * 
 * @author Dogrong
 *Õ½»ú
 */
public class J_20 extends Father{
	public J_20() {
		super();
		// TODO Auto-generated constructor stub
		this.img=Image.getImg("/image/J-20.png");
		this.x=200;
		this.y=650;
		this.widht=img.getWidth();
		this.height=img.getHeight();
		this.hp=3;
	}
}
