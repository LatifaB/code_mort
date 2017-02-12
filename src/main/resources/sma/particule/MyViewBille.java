package resources.sma.particule;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import resources.sma.particule.MyJPanelBille;
import resources.sma.utils.Utils;

public class MyViewBille extends JFrame implements Observer {
	private static final long serialVersionUID = 1L;
	private MyJPanelBille myJPanel = new MyJPanelBille();
	private int tick;
	
	public MyViewBille(){
		this.setTitle("Particule");
		
	    JScrollPane jScrollPane = new JScrollPane(myJPanel, 
	    		JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	    		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	    jScrollPane.setViewportBorder(new LineBorder(Color.BLACK));
	    
	    this.add(jScrollPane, BorderLayout.CENTER);
		
		this.setSize(Utils.canvasSizeX, Utils.canvasSizeY);
		this.revalidate();
		
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
		this.setVisible(true);
		tick = 0;
	}
	
	public void update(Observable arg0, Object arg1) {
		if(arg0 instanceof SchedulerBille){
			SchedulerBille sma = (SchedulerBille) arg0;
			myJPanel.setMap(sma.getMap());
			if((tick % Utils.refresh) == 0){
				myJPanel.repaint(); 
			}
			tick++;
		}
	}
}
