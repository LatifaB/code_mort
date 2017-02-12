

package resources.sma.avatar;


public class MyViewAvatar extends javax.swing.JFrame implements java.util.Observer {
    private static final long serialVersionUID = 1L;

    private resources.sma.avatar.MyJPanelAvatar myJPanel = new resources.sma.avatar.MyJPanelAvatar();

    private int tick;

    public MyViewAvatar(java.util.LinkedList<resources.sma.avatar.Prey> preys) {
        resources.sma.avatar.MyViewAvatar.this.setTitle("Avatar");
        javax.swing.JScrollPane jScrollPane = new javax.swing.JScrollPane(myJPanel, javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setViewportBorder(new javax.swing.border.LineBorder(java.awt.Color.BLACK));
        for (resources.sma.avatar.Prey prey : preys) {
            resources.sma.avatar.MyViewAvatar.this.addKeyListener(prey);
        }
        resources.sma.avatar.MyViewAvatar.this.add(jScrollPane, java.awt.BorderLayout.CENTER);
        resources.sma.avatar.MyViewAvatar.this.setSize(resources.sma.utils.Utils.canvasSizeX, resources.sma.utils.Utils.canvasSizeY);
        resources.sma.avatar.MyViewAvatar.this.revalidate();
        resources.sma.avatar.MyViewAvatar.this.setLocationRelativeTo(null);
        resources.sma.avatar.MyViewAvatar.this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        resources.sma.avatar.MyViewAvatar.this.setVisible(true);
        tick = 0;
    }

    public void update(java.util.Observable arg0, java.lang.Object arg1) {
        if (arg0 instanceof resources.sma.avatar.SchedulerAvatar) {
            resources.sma.avatar.SchedulerAvatar sma = ((resources.sma.avatar.SchedulerAvatar) (arg0));
            myJPanel.setMap(sma.getMap());
            if (((tick) % (resources.sma.utils.Utils.refresh)) == 0) {
                myJPanel.repaint();
            }
            (tick)++;
        }
    }
}

