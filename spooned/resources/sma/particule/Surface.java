

package resources.sma.particule;


public class Surface extends resources.sma.core.Environement {
    public Surface() {
        super();
        java.util.Random rdm = new java.util.Random();
        if ((resources.sma.utils.Utils.seed) != 0) {
            rdm.setSeed(resources.sma.utils.Utils.seed);
        }
        int x;
        int y;
        for (int i = 0; i < (resources.sma.utils.Utils.nbParticules); i++) {
            x = rdm.nextInt(resources.sma.utils.Utils.grideSizeX);
            y = rdm.nextInt(resources.sma.utils.Utils.grideSizeY);
            while ((resources.sma.particule.Surface.this.map[x][y]) != null) {
                x = rdm.nextInt(resources.sma.utils.Utils.grideSizeX);
                y = rdm.nextInt(resources.sma.utils.Utils.grideSizeY);
            } 
            map[x][y] = new resources.sma.particule.Bille(x, y, resources.sma.particule.Surface.this);
        }
    }

    public java.awt.Color[][] getColor() {
        java.awt.Color[][] res = new java.awt.Color[resources.sma.utils.Utils.grideSizeX][resources.sma.utils.Utils.grideSizeY];
        for (int i = 0; i < (resources.sma.utils.Utils.grideSizeX); i++) {
            for (int j = 0; j < (resources.sma.utils.Utils.grideSizeY); j++) {
                if ((map[i][j]) != null) {
                    res[i][j] = ((resources.sma.particule.Bille) (map[i][j])).getColor();
                }else {
                    res[i][j] = null;
                }
            }
        }
        return res;
    }
}

