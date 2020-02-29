package plain;

import java.util.List;

import ui.Ui_JP;
/**
 * 
 * @author Dogrong
 *�ӵ���
 *�����ӵ����ƶ��ӵ�
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
	
	//�����ӵ���
	//����uJP���ӵ������ٶȶ����ʱ�������������ٶ�
	int index=10;
	void enter() {
		//��ʱ��
		int addTime=(int)(14/uJP.getbSpeed());
		//�������Ҹ��ӵ�
		if(index++>=addTime) {
			list.add(new Bullet(j20.getX()+50,j20.getY()));
			list.add(new Bullet(j20.getX()+15,j20.getY()));
		index=0;
		}
	}
	
	//�ӵ��ƶ�
	void move() {
		//�����ӵ��⣬ʹ�ӵ������Լ����ƶ�����
		for(int i=0;i<list.size();i++) {
			Bullet b =list.get(i);
			b.move();
		}
		//�����ӵ��⣬ʹԽ���ӵ����ӵ������Ƴ�
		for(int i=0;i<list.size()-1;i++) {
			if(list.get(i).getY()<-100) {
				list.remove(i);
			}else
				break;
		}
	}
}
