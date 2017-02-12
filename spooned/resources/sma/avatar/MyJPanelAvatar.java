

package resources.sma.avatar;


public class MyJPanelAvatar extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    protected java.awt.Color[][] map;

    private int boxSizeX = ((int) (resources.sma.utils.Utils.canvasSizeX)) / (resources.sma.utils.Utils.grideSizeX);

    private int boxSizeY = ((int) (resources.sma.utils.Utils.canvasSizeY)) / (resources.sma.utils.Utils.grideSizeY);

    public MyJPanelAvatar() {
        setPreferredSize(new java.awt.Dimension(resources.sma.utils.Utils.canvasSizeX, resources.sma.utils.Utils.canvasSizeY));
    }

    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        if ((resources.sma.avatar.MyJPanelAvatar.this.map) != null) {
            for (int i = 0; i < (resources.sma.utils.Utils.grideSizeX); i++) {
                for (int j = 0; j < (resources.sma.utils.Utils.grideSizeY); j++) {
                    if ((resources.sma.avatar.MyJPanelAvatar.this.map[i][j]) != null) {
                        g.setColor(resources.sma.avatar.MyJPanelAvatar.this.map[i][j]);
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
        resources.sma.avatar.MyJPanelAvatar.this.map = map;
    }
}

