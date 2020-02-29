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
 *������Ҫ���� 
 *������ΪuJP
 */

public class Ui_JP extends JPanel{
	private static final long serialVersionUID = 1L;
	//���̶߳���
	private Thread_Run run;
	//��������
	private BufferedImage back;
	//ս������
	private J_20 j20;
	//�л���
	private List<F_22> listf = new LinkedList<F_22>();
	//�ӵ���
	private List<Bullet> listb = new LinkedList<Bullet>();
	//�����͵л�����
	private int score = 0,armor=10;
	//��ʽ������
	private DecimalFormat df = new DecimalFormat("0.0");
	//�л������ٶȺ��ӵ������ٶ�
	private double fSpeed=1,bSpeed=1;
	//��ʼ��������
	private boolean isGameOver = true,isStart=true;
	//�������
	private MouseRun mouse;
	//���췽��
	public Ui_JP() {
		super();
		back=Image.getImg("/image/back.jpg");
		j20 = new J_20();
		//�ӵ������
		Bullet_Run bullet = new Bullet_Run(this);
		//ս�������
		F_22_Run f22 = new F_22_Run(this);
		//���߳�
		run = new Thread_Run(f22, bullet, this);
		run.start();
		//�����������
		mouse=new MouseRun(j20,this);
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);
	}
	//��ͼ����
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(back, 0, 0,null);
		//�����л��⣬���Ƶл�
		for(int i=0;i<listf.size();i++) {
			F_22 f = listf.get(i);
			g.drawImage(f.getImg(), f.getX(), f.getY(),null);
		}
		//�����ӵ��⣬���������ӵ�
		for(int i=0;i<listb.size()-1;i++) {
			Bullet b=listb.get(i);
			Bullet b2=listb.get(i+1);
			g.drawImage(b.getImg(), b.getX(), b.getY(),null);
			g.drawImage(b2.getImg(), b2.getX(), b2.getY(),null);
		}
		g.drawImage(j20.getImg(),j20.getX(),j20.getY(), null);
		g.setColor(Color.white);
		g.setFont(new Font("����",Font.BOLD,30));
		g.drawString("����:"+score, 10, 30);
		g.setFont(new Font("����",Font.BOLD,15));
		g.drawString("�л������ٶ�:"+df.format(fSpeed), 10, 60);
		g.drawString("�ӵ������ٶ�:"+df.format(bSpeed), 10, 80);
		g.drawString("�л����׵ȼ�:"+armor, 10, 100);
		g.setFont(new Font("����",Font.BOLD,20));
		g.drawString("����:", 10, 140);
		for(int i=0;i<j20.getHp();i++) {
			g.drawImage(j20.getImg(), i*30+70, 115, j20.getWidht()/2,j20.getHeight()/2,null);
		}
		//�Ƿ�Ϊ��������ʼҲ���������
		if(isGameOver) {
			g.setFont(new Font("����",Font.BOLD,30));
			g.setColor(Color.red);
			g.drawString("�����ʼ��", 170, 700);
			g.setFont(new Font("����",Font.BOLD,15));
			g.drawString("��Q���ӵл������ٶȣ���A���͵л������ٶ�", 160, 60);
			g.drawString("��W�����ӵ������ٶȣ���S�����ӵ������ٶ�", 160, 80);
			g.drawString("��E���ӵл����׵ȼ�����D���͵л����׵ȼ�", 160, 100);
			g.setFont(new Font("����",Font.BOLD,20));
			g.drawString("��L��ʼ||�ر��޵�ģʽ", 180, 140);
			//��Ϊ��ʼ���򲻻��ƽ���������ѿ�ʼ��Ǳ��
			if(isStart) {
				isStart=false;
			}
			else {
				g.drawString("�ʵ�һ�ʣ��ֵܣ�", 200, 350);
				g.setFont(new Font("����",Font.BOLD,50));
				g.drawString("������"+score, 150, 400);
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
