package plain;

import java.util.List;
import ui.Ui_JP;
/**
 * 三、主线程
 * @author Dogrong
 *
 */
public class Thread_Run extends Thread{
	private F_22_Run f22;
	private Bullet_Run bullet;
	private Ui_JP uJP;
	//敌机库
	private List<F_22> listf ;
	//子弹库
	private List<Bullet> listb ;
	private J_20 j;
	//超级模式开关
	public boolean superman = false;
	public Thread_Run(F_22_Run f22, Bullet_Run bullet, Ui_JP uJP) {
		super();
		this.f22 = f22;
		this.bullet = bullet;
		this.uJP = uJP;
		this.listb=uJP.getListb();
		this.listf=uJP.getListf();
		this.j=uJP.getJ20();
	}
	//主程序
	public void run() {
		while(true) {
			//如果状态不为结束，则绘制游戏界面
			if(!uJP.isGameOver()) {
				//增加
				f22.enter();
				bullet.enter();
				//检测是否射中敌机
				shootB();
				//如果不为无敌模式，则检测战机是否碰撞
				if(!superman)
					jHit();
				//移动
				f22.move();
				bullet.move();
				//移动后需重绘制
				uJP.repaint();
			}
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	//是否战机与敌机碰撞
	void jHit() {
		//遍历所所有敌机，检测是否与战机碰撞
		for(int i=0;i<listf.size();i++) {
			F_22 f = listf.get(i);
			//如果碰撞移除敌机，战机生命减一
			if(isJHit(f)) {
				listf.remove(f);
				j.setHp(j.getHp()-1);
				//如果生命值为0，则置为结束状态，清空战机库与子弹库
				if(j.getHp()<0) {
					uJP.setGameOver(true);
					listb.clear();
					listf.clear();
				}
			}
		}
	}
	//战机与敌机检测方法
	boolean isJHit(F_22 f) {
	return  	f.getX()<=j.getX()+j.getWidht()-10&&
				f.getX()>=j.getX()-f.getWidht()+10&&
				f.getY()<=j.getY()+j.getHeight()-30&&
				f.getY ()>=j.getY()-f.getHeight()+30;
	}
	
	
	//shootB -> shootF -> isHit
	void shootB() {
		//遍历子弹库
		for(int i=0;i<listb.size();i++) {
			shootF(listb.get(i));
		}
	}
	void shootF(Bullet b) {
		//根据子弹，遍历所有敌机是否触碰
		for(int i=0;i<listf.size();i++) {
			F_22 f = listf.get(i);
			//如果触碰则移除子弹，并减少敌机护甲
			if(isHit(f,b)) {
				//敌机生命值为0则移除敌机，分数+10
				if(--f.hp<0) {
					listf.remove(f);
					uJP.setScore(uJP.getScore()+10);
				}
				listb.remove(b);
			}
		}
	}
	//敌机与子弹检测方法
	boolean isHit(F_22 f,Bullet b){
		return  f.getX()<=b.getX()+b.getWidht()&&
				f.getX()>=b.getX()-f.getWidht()&&
				f.getY()<=b.getY()+b.getHeight()&&
				f.getY()>=b.getY()-f.getHeight();
	}
	
}
