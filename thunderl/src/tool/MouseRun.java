package tool;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import plain.J_20;
import ui.Ui_JP;
/**
 * 
 * @author Dogrong
 *鼠标监视器
 *控制战机跟着鼠标走
 *在结束时，使点击屏幕重新开始
 *战机坐标与生命值重置
 */
public class MouseRun extends MouseAdapter{
	private J_20 j20;
	private Ui_JP uJP;
	
	public MouseRun(J_20 j20,Ui_JP uip) {
		super();
		this.j20 = j20;
		this.uJP=uip;
	}

	public void mouseClicked(MouseEvent e) {
		if(uJP.isGameOver()) {
			uJP.getJ20().setHp(3);
			uJP.getJ20().setX(200);
			uJP.getJ20().setY(600);
			uJP.setScore(0);
			uJP.setGameOver(false);
		}
	}

    /**
     * {@inheritDoc}
     */
    public void mousePressed(MouseEvent e) {}

    /**
     * {@inheritDoc}
     */
    public void mouseReleased(MouseEvent e) {}

    /**
     * {@inheritDoc}
     */
    public void mouseEntered(MouseEvent e) {}

    /**
     * {@inheritDoc}
     */
    public void mouseExited(MouseEvent e) {}

    /**
     * {@inheritDoc}
     * @since 1.6
     */
    public void mouseWheelMoved(MouseWheelEvent e){}

    /**
     * {@inheritDoc}
     * @since 1.6
     */
    public void mouseDragged(MouseEvent e){}

    /**
     * {@inheritDoc}
     * @since 1.6
     */
    public void mouseMoved(MouseEvent e){
    	if(!uJP.isGameOver()&&e.getX()>25&&e.getX()<455&&e.getY()>45&&e.getY()<735) {
    		j20.setX(e.getX()-j20.getWidht()/2);
        	j20.setY(e.getY()-j20.getHeight()/2);
        	uJP.repaint();
    	}
    }
}
