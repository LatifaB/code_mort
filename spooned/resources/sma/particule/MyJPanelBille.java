

package resources.sma.particule;


public class MyJPanelBille extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    protected java.awt.Color[][] map;

    private int boxSizeX = ((int) (resources.sma.utils.Utils.canvasSizeX)) / (resources.sma.utils.Utils.grideSizeX);

    private int boxSizeY = ((int) (resources.sma.utils.Utils.canvasSizeY)) / (resources.sma.utils.Utils.grideSizeY);

    public MyJPanelBille() {
        setPreferredSize(new java.awt.Dimension(((boxSizeX) * (resources.sma.utils.Utils.grideSizeX)), ((boxSizeY) * (resources.sma.utils.Utils.grideSizeY))));
    }

    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        if ((resources.sma.particule.MyJPanelBille.this.map) != null) {
            for (int i = 0; i < (resources.sma.utils.Utils.grideSizeX); i++) {
                for (int j = 0; j < (resources.sma.utils.Utils.grideSizeY); j++) {
                    if ((resources.sma.particule.MyJPanelBille.this.map[i][j]) != null) {
                        g.setColor(resources.sma.particule.MyJPanelBille.this.map[i][j]);
                        g.fillOval((i * (boxSizeX)), (j * (boxSizeY)), boxSizeX, boxSizeY);
                    }
                }
            }
        }
        if (resources.sma.utils.Utils.showGrid()) {
            g.setColor(java.awt.Color.black);
            g.drawLine(((resources.sma.utils.Utils.grideSizeX) * (boxSizeX)), 0, ((resources.sma.utils.Utils.grideSizeX) * (boxSizeX)), ((resources.sma.utils.Utils.grideSizeY) * (boxSizeY)));
            g.drawLine(0, ((resources.sma.utils.Utils.grideSizeY) * (boxSizeY)), ((resources.sma.utils.Utils.grideSizeX) * (boxSizeX)), ((resources.sma.utils.Utils.grideSizeY) * (boxSizeY)));
            for (int i = 0; i < (resources.sma.utils.Utils.grideSizeX); i++) {
                g.drawLine((i * (boxSizeX)), 0, (i * (boxSizeX)), ((resources.sma.utils.Utils.grideSizeY) * (boxSizeY)));
                g.drawLine(0, (i * (boxSizeY)), ((resources.sma.utils.Utils.grideSizeX) * (boxSizeX)), (i * (boxSizeY)));
            }
        }
    }

    public void setMap(java.awt.Color[][] map) {
        resources.sma.particule.MyJPanelBille.this.map = map;
    }
}

