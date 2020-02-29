package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;
import plain.Bullet;
import plain.Bullet_Run;
import plain.F_22;
import plain.F_22_Run;
import plain.J_20;
import plain.Thread_Run;
import tool.Image;
import tool.MouseRun;
/**
 * 
 * @author Dogrong
 *
 *二、主要界面 
 *变量名为uJP
 */

public class Ui_JP extends JPanel{
	private static final long serialVersionUID = 1L;
	//主线程对象
	private Thread_Run run;
	//背景对象
	private BufferedImage back;
	//战机对象
	private J_20 j20;
	//敌机库
	private List<F_22> listf = new LinkedList<F_22>();
	//子弹库
	private List<Bullet> listb = new LinkedList<Bullet>();
	//分数和敌机护甲
	private int score = 0,armor=10;
	//格式化对象
	private DecimalFormat df = new DecimalFormat("0.0");
	//敌机生产速度和子弹生产速度
	private double fSpeed=1,bSpeed=1;
	//开始与结束标记
	private boolean isGameOver = true,isStart=true;
	//鼠标监控器
	private MouseRun mouse;
	//构造方法
	public Ui_JP() {
		super();
		back=Image.getImg("/image/back.jpg");
		j20 = new J_20();
		//子弹活动对象
		Bullet_Run bullet = new Bullet_Run(this);
		//战机活动对象
		F_22_Run f22 = new F_22_Run(this);
		//主线程
		run = new Thread_Run(f22, bullet, this);
		run.start();
		//添加鼠标监视器
		mouse=new MouseRun(j20,this);
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);
	}
	//绘图方法
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(back, 0, 0,null);
		//遍历敌机库，绘制敌机
		for(int i=0;i<listf.size();i++) {
			F_22 f = listf.get(i);
			g.drawImage(f.getImg(), f.getX(), f.getY(),null);
		}
		//遍历子弹库，绘制两边子弹
		for(int i=0;i<listb.size()-1;i++) {
			Bullet b=listb.get(i);
			Bullet b2=listb.get(i+1);
			g.drawImage(b.getImg(), b.getX(), b.getY(),null);
			g.drawImage(b2.getImg(), b2.getX(), b2.getY(),null);
		}
		g.drawImage(j20.getImg(),j20.getX(),j20.getY(), null);
		g.setColor(Color.white);
		g.setFont(new Font("楷体",Font.BOLD,30));
		g.drawString("分数:"+score, 10, 30);
		g.setFont(new Font("楷体",Font.BOLD,15));
		g.drawString("敌机生产速度:"+df.format(fSpeed), 10, 60);
		g.drawString("子弹生产速度:"+df.format(bSpeed), 10, 80);
		g.drawString("敌机护甲等级:"+armor, 10, 100);
		g.setFont(new Font("楷体",Font.BOLD,20));
		g.drawString("生命:", 10, 140);
		for(int i=0;i<j20.getHp();i++) {
			g.drawImage(j20.getImg(), i*30+70, 115, j20.getWidht()/2,j20.getHeight()/2,null);
		}
		//是否为结束（开始也代表结束）
		if(isGameOver) {
			g.setFont(new Font("楷体",Font.BOLD,30));
			g.setColor(Color.red);
			g.drawString("点击开始！", 170, 700);
			g.setFont(new Font("楷体",Font.BOLD,15));
			g.drawString("按Q增加敌机生产速度，按A降低敌机生产速度", 160, 60);
			g.drawString("按W增加子弹生产速度，按S降低子弹生产速度", 160, 80);
			g.drawString("按E增加敌机护甲等级，按D降低敌机护甲等级", 160, 100);
			g.setFont(new Font("楷体",Font.BOLD,20));
			g.drawString("按L开始||关闭无敌模式", 180, 140);
			//若为开始，则不绘制结束标语，并把开始标记变非
			if(isStart) {
				isStart=false;
			}
			else {
				g.drawString("彩得一笔，兄弟！", 200, 350);
				g.setFont(new Font("楷体",Font.BOLD,50));
				g.drawString("分数："+score, 150, 400);
			}
		}
	}
	
	public Thread_Run getRun() {
		return run;
	}
	public List<Bullet> getListb() {
		return listb;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public List<F_22> getListf() {
		return listf;
	}
	public double getfSpeed() {
		return fSpeed;
	}
	public void setfSpeed(double fSpeed) {
		this.fSpeed = fSpeed;
	}
	public double getbSpeed() {
		return bSpeed;
	}
	public void setbSpeed(double bSpeed) {
		this.bSpeed = bSpeed;
	}
	public int  getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}
	public J_20 getJ20() {
		return j20;
	}
	public void setJ20(J_20 j20) {
		this.j20 = j20;
	}
	public boolean isGameOver() {
		return isGameOver;
	}
	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}
	public MouseRun getMouse() {
		return mouse;
	}
	public void setMouse(MouseRun mouse) {
		this.mouse = mouse;
	}
}
