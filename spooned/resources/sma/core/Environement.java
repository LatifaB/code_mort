

package resources.sma.core;


public abstract class Environement {
    protected resources.sma.core.Agent[][] map;

    public Environement() {
        resources.sma.core.Environement.this.map = new resources.sma.core.Agent[resources.sma.utils.Utils.grideSizeX][resources.sma.utils.Utils.grideSizeY];
        for (int i = 0; i < (resources.sma.utils.Utils.grideSizeX); i++) {
            for (int j = 0; j < (resources.sma.utils.Utils.grideSizeY); j++) {
                map[i][j] = null;
            }
        }
    }

    public resources.sma.core.Agent getAgent(int x, int y) {
        return map[x][y];
    }

    public void setAgent(int x, int y, resources.sma.core.Agent agent) {
        map[x][y] = agent;
    }

    public void decideAll() {
        for (int i = 0; i < (resources.sma.utils.Utils.grideSizeX); i++) {
            for (int j = 0; j < (resources.sma.utils.Utils.grideSizeY); j++) {
                if (((map[i][j]) != null) && (!(map[i][j].isMoved()))) {
                    map[i][j].decide();
                }
            }
        }
        resetAll();
        if (resources.sma.utils.Utils.showTrace()) {
            java.lang.System.out.println("Tick;");
        }
    }

    private void resetAll() {
        for (int i = 0; i < (resources.sma.utils.Utils.grideSizeX); i++) {
            for (int j = 0; j < (resources.sma.utils.Utils.grideSizeY); j++) {
                if ((map[i][j]) != null) {
                    map[i][j].resetMoved();
                }
            }
        }
    }

    public java.lang.String toString() {
        java.lang.String res = "";
        for (int i = 0; i < (resources.sma.utils.Utils.grideSizeX); i++) {
            for (int j = 0; j < (resources.sma.utils.Utils.grideSizeY); j++) {
                if ((map[i][j]) != null) {
                    res = res + "*|";
                }else {
                    res = res + " |";
                }
            }
            res = res + "\n";
        }
        return res;
    }

    public abstract java.awt.Color[][] getColor();

    public boolean isEmpty(int x, int y) {
        return (resources.sma.core.Environement.this.map[x][y]) == null;
    }
}

