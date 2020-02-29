package tool;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import ui.Ui_JP;
/**
 * 
 * @author Dogrong
 *键盘监控器
 *主要控制
 *	敌机、子弹生产速度
 *	敌机护甲和无敌模式
 */

public class KeyRun implements KeyListener{
	private Ui_JP uJP;
	public KeyRun(Ui_JP uJP) {
		super();
		this.uJP = uJP;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//控制主线程中的superman,使无敌
		if(e.getKeyCode()==KeyEvent.VK_L) {
			System.out.println("super");
			uJP.getRun().superman=uJP.getRun().superman?false:true;
		}
		//W增加子弹生产 x<15
		if(e.getKeyCode()==KeyEvent.VK_W&&uJP.getbSpeed()<15) {
			uJP.setbSpeed(uJP.getbSpeed()+0.1);
		}
		//S减速子弹生产 x>1
		if(e.getKeyCode()==KeyEvent.VK_S&&uJP.getbSpeed()>1) {
			uJP.setbSpeed(uJP.getbSpeed()-0.1);
		}
		//Q增加战机生产 x<15
		if(e.getKeyCode()==KeyEvent.VK_Q&&uJP.getfSpeed()<15) {
			uJP.setfSpeed(uJP.getfSpeed()+0.1);
		}
		//A减少战机生产 x>1
		if(e.getKeyCode()==KeyEvent.VK_A&&uJP.getfSpeed()>1) {
			uJP.setfSpeed(uJP.getfSpeed()-0.1);
		}
		//E增加战机护甲 x<=25
		if(e.getKeyCode()==KeyEvent.VK_E&&uJP.getArmor()<=24) {
			uJP.setArmor(uJP.getArmor()+1);
		}
		//D减少战机护甲x>=1
		if(e.getKeyCode()==KeyEvent.VK_D&&uJP.getArmor()>1) {
			uJP.setArmor(uJP.getArmor()-1);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
