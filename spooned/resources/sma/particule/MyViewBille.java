

package resources.sma.particule;


public class MyViewBille extends javax.swing.JFrame implements java.util.Observer {
    private static final long serialVersionUID = 1L;

    private resources.sma.particule.MyJPanelBille myJPanel = new resources.sma.particule.MyJPanelBille();

    private int tick;

    public MyViewBille() {
        resources.sma.particule.MyViewBille.this.setTitle("Particule");
        javax.swing.JScrollPane jScrollPane = new javax.swing.JScrollPane(myJPanel, javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setViewportBorder(new javax.swing.border.LineBorder(java.awt.Color.BLACK));
        resources.sma.particule.MyViewBille.this.add(jScrollPane, java.awt.BorderLayout.CENTER);
        resources.sma.particule.MyViewBille.this.setSize(resources.sma.utils.Utils.canvasSizeX, resources.sma.utils.Utils.canvasSizeY);
        resources.sma.particule.MyViewBille.this.revalidate();
        resources.sma.particule.MyViewBille.this.setLocationRelativeTo(null);
        resources.sma.particule.MyViewBille.this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        resources.sma.particule.MyViewBille.this.setVisible(true);
        tick = 0;
    }

    public void update(java.util.Observable arg0, java.lang.Object arg1) {
        if (arg0 instanceof resources.sma.particule.SchedulerBille) {
            resources.sma.particule.SchedulerBille sma = ((resources.sma.particule.SchedulerBille) (arg0));
            myJPanel.setMap(sma.getMap());
            if (((tick) % (resources.sma.utils.Utils.refresh)) == 0) {
                myJPanel.repaint();
            }
            (tick)++;
        }
    }
}

