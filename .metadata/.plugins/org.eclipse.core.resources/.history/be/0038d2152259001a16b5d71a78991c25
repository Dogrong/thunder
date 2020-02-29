package ui;

import javax.swing.JFrame;

import tool.KeyRun;
/**
 * 
 * @author Dogrong
 *
 *一、界面主体
 *创建窗口，大小为500*800；
 * 添加JP类、添加键盘监控器；
 */
public class Ui_JF  extends JFrame{
	private static final long serialVersionUID = 1L;

	public Ui_JF() {
		 this.setTitle("雷霆战机之2019新型冠状病毒版");
		 this.setSize(500,800);
		 this.setLocationRelativeTo(null);
		 this.setResizable(false);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 }
	 
	 public static void main(String[] args) {
	 Ui_JF uiJ = new Ui_JF ();
	 Ui_JP uiP=new Ui_JP();
	 //添加键盘监视器
	 KeyRun key = new KeyRun(uiP);
	 uiJ.addKeyListener(key);
	 uiJ.add(uiP);
	 uiJ.setVisible(true); 
	}
}
