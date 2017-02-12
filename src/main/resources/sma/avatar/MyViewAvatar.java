package resources.sma.avatar;


import resources.sma.utils.Utils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class MyViewAvatar  extends JFrame implements Observer {
    private static final long serialVersionUID = 1L;
    private MyJPanelAvatar myJPanel = new MyJPanelAvatar();
    private int tick;

    public MyViewAvatar(LinkedList<Prey> preys){
        this.setTitle("Avatar");

        JScrollPane jScrollPane = new JScrollPane(myJPanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        jScrollPane.setViewportBorder(new LineBorder(Color.BLACK));

        for(Prey prey : preys){
            this.addKeyListener(prey);
        }

        this.add(jScrollPane, BorderLayout.CENTER);

        this.setSize(Utils.canvasSizeX, Utils.canvasSizeY);
        this.revalidate();

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        tick = 0;
    }

    public void update(Observable arg0, Object arg1) {
        if(arg0 instanceof SchedulerAvatar){
            SchedulerAvatar sma = (SchedulerAvatar) arg0;
            myJPanel.setMap(sma.getMap());
            if((tick % Utils.refresh) == 0){
                myJPanel.repaint();
            }
            tick++;
        }
    }
}
