package plain;

import java.util.List;

import ui.Ui_JP;
/**
 * 
 * @author Dogrong
 *子弹库
 *增加子弹、移动子弹
 */
public class Bullet_Run {
	private List<Bullet> list;
	private Ui_JP uJP;
	private J_20 j20;
	public Bullet_Run(Ui_JP Ujp) {
		super();
		this.list = Ujp.getListb();
		this.uJP = Ujp;
		this.j20 = Ujp.getJ20();
	}
	
	//增加子弹。
	//根据uJP的子弹生产速度定义计时器，控制生产速度
	int index=10;
	void enter() {
		//计时器
		int addTime=(int)(14/uJP.getbSpeed());
		//生产左右各子弹
		if(index++>=addTime) {
			list.add(new Bullet(j20.getX()+50,j20.getY()));
			list.add(new Bullet(j20.getX()+15,j20.getY()));
		index=0;
		}
	}
	
	//子弹移动
	void move() {
		//遍历子弹库，使子弹调用自己的移动方法
		for(int i=0;i<list.size();i++) {
			Bullet b =list.get(i);
			b.move();
		}
		//遍历子弹库，使越界子弹在子弹库中移除
		for(int i=0;i<list.size()-1;i++) {
			if(list.get(i).getY()<-100) {
				list.remove(i);
			}else
				break;
		}
	}
}
