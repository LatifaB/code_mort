

package resources.sma.wator;


public class Wator extends resources.sma.core.Environement {
    public Wator() {
        java.util.Random rdm = new java.util.Random();
        if ((resources.sma.utils.Utils.seed) != 0) {
            rdm.setSeed(resources.sma.utils.Utils.seed);
        }
        int x;
        int y;
        for (int i = 0; i < (resources.sma.utils.Utils.nbFishes); i++) {
            x = rdm.nextInt(resources.sma.utils.Utils.grideSizeX);
            y = rdm.nextInt(resources.sma.utils.Utils.grideSizeY);
            while ((resources.sma.wator.Wator.this.map[x][y]) != null) {
                x = rdm.nextInt(resources.sma.utils.Utils.grideSizeX);
                y = rdm.nextInt(resources.sma.utils.Utils.grideSizeY);
            } 
            map[x][y] = new resources.sma.wator.Fish(x, y, resources.sma.wator.Wator.this);
        }
        for (int i = 0; i < (resources.sma.utils.Utils.nbSharks); i++) {
            x = rdm.nextInt(resources.sma.utils.Utils.grideSizeX);
            y = rdm.nextInt(resources.sma.utils.Utils.grideSizeY);
            while ((resources.sma.wator.Wator.this.map[x][y]) != null) {
                x = rdm.nextInt(resources.sma.utils.Utils.grideSizeX);
                y = rdm.nextInt(resources.sma.utils.Utils.grideSizeY);
            } 
            map[x][y] = new resources.sma.wator.SharkUn(x, y, resources.sma.wator.Wator.this);
        }
    }

    public java.awt.Color[][] getColor() {
        java.awt.Color[][] res = new java.awt.Color[resources.sma.utils.Utils.grideSizeX][resources.sma.utils.Utils.grideSizeY];
        for (int i = 0; i < (resources.sma.utils.Utils.grideSizeX); i++) {
            for (int j = 0; j < (resources.sma.utils.Utils.grideSizeY); j++) {
                if ((map[i][j]) != null) {
                    res[i][j] = ((resources.sma.wator.MarinCreature) (map[i][j])).getColor();
                }else {
                    res[i][j] = java.awt.Color.cyan;
                }
            }
        }
        return res;
    }

    @java.lang.Override
    public void decideAll() {
        super.decideAll();
        resources.sma.utils.Utils.nbFishes = 0;
        resources.sma.utils.Utils.nbSharks = 0;
        for (int i = 0; i < (resources.sma.utils.Utils.grideSizeX); i++) {
            for (int j = 0; j < (resources.sma.utils.Utils.grideSizeY); j++) {
                if (((map[i][j]) != null) && (!(map[i][j].isMoved()))) {
                    ((resources.sma.wator.MarinCreature) (map[i][j])).count();
                }
            }
        }
        if (resources.sma.utils.Utils.showTrace()) {
            java.lang.System.out.print(((((resources.sma.utils.Utils.nbFishes) + ";") + (resources.sma.utils.Utils.nbSharks)) + ";"));
        }
    }
}

