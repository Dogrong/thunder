package plain;

import java.util.List;

import ui.Ui_JP;
/**
 * 
 * @author Dogrong
 *�л���
 *����Ϊ���ӵл����ƶ��л�
 */
public class F_22_Run {
	private List<F_22> list;
	private Ui_JP uJP;
	public F_22_Run(Ui_JP uJP) {
		super();
		this.list = uJP.getListf();
		this.uJP=uJP;
	}
	//�л��ƶ������������л��⣬����л�Խ��
	//�ڵл�����ɾ��
	void move() {
		for(int i=0;i<list.size();i++) {
			F_22 f = list.get(i);
			f.move();
			if(f.getY()>800) list.remove(i);
		}
	}
	
	/*
	 * ��ⷽ����
	 * ����uJP�������л��ٶȶ����ʱ��������ÿ����������
	 * ����uJP�Ļ���ֵ���廤����
	 */
	int index=0;
	void enter() {
		 //��ʱ��
		 int addTime =(int)(14/uJP.getfSpeed());
		 //������
		 int armor =uJP.getArmor();
		 System.out.println(addTime);
		 if(index++>=addTime) {
			 index=0;
			 F_22 f = new F_22(armor);
				list.add(f);
		 }
	}
}
