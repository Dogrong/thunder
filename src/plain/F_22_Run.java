package plain;

import java.util.List;

import ui.Ui_JP;
/**
 * 
 * @author Dogrong
 *敌机库
 *作用为增加敌机，移动敌机
 */
public class F_22_Run {
	private List<F_22> list;
	private Ui_JP uJP;
	public F_22_Run(Ui_JP uJP) {
		super();
		this.list = uJP.getListf();
		this.uJP=uJP;
	}
	//敌机移动方法，遍历敌机库，如果敌机越界
	//在敌机库中删除
	void move() {
		for(int i=0;i<list.size();i++) {
			F_22 f = list.get(i);
			f.move();
			if(f.getY()>800) list.remove(i);
		}
	}
	
	/*
	 * 入库方法。
	 * 根据uJP的生产敌机速度定义计时器，控制每次增加数量
	 * 根据uJP的护甲值定义护甲数
	 */
	int index=0;
	void enter() {
		 //计时器
		 int addTime =(int)(14/uJP.getfSpeed());
		 //护甲数
		 int armor =uJP.getArmor();
		 System.out.println(addTime);
		 if(index++>=addTime) {
			 index=0;
			 F_22 f = new F_22(armor);
				list.add(f);
		 }
	}
}
