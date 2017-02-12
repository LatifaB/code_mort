package resources.sma.wator;


import resources.sma.particule.MyJPanelBille;
import resources.sma.particule.SchedulerBille;
import resources.sma.utils.Utils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class MyViewWator extends JFrame implements Observer {
    private static final long serialVersionUID = 1L;
    private MyJPanelWator myJPanel = new MyJPanelWator();
    private int tick;

    public MyViewWator(){
        this.setTitle("Wator");

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
        if(arg0 instanceof SchedulerWator){
            SchedulerWator sma = (SchedulerWator) arg0;
            myJPanel.setMap(sma.getMap());
            if((tick % Utils.refresh) == 0){
                myJPanel.repaint();
            }
            tick++;
        }
    }
}
