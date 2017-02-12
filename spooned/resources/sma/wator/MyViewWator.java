

package resources.sma.wator;


public class MyViewWator extends javax.swing.JFrame implements java.util.Observer {
    private static final long serialVersionUID = 1L;

    private resources.sma.wator.MyJPanelWator myJPanel = new resources.sma.wator.MyJPanelWator();

    private int tick;

    public MyViewWator() {
        resources.sma.wator.MyViewWator.this.setTitle("Wator");
        javax.swing.JScrollPane jScrollPane = new javax.swing.JScrollPane(myJPanel, javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setViewportBorder(new javax.swing.border.LineBorder(java.awt.Color.BLACK));
        resources.sma.wator.MyViewWator.this.add(jScrollPane, java.awt.BorderLayout.CENTER);
        resources.sma.wator.MyViewWator.this.setSize(resources.sma.utils.Utils.canvasSizeX, resources.sma.utils.Utils.canvasSizeY);
        resources.sma.wator.MyViewWator.this.revalidate();
        resources.sma.wator.MyViewWator.this.setLocationRelativeTo(null);
        resources.sma.wator.MyViewWator.this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        resources.sma.wator.MyViewWator.this.setVisible(true);
        tick = 0;
    }

    public void update(java.util.Observable arg0, java.lang.Object arg1) {
        if (arg0 instanceof resources.sma.wator.SchedulerWator) {
            resources.sma.wator.SchedulerWator sma = ((resources.sma.wator.SchedulerWator) (arg0));
            myJPanel.setMap(sma.getMap());
            if (((tick) % (resources.sma.utils.Utils.refresh)) == 0) {
                myJPanel.repaint();
            }
            (tick)++;
        }
    }
}

