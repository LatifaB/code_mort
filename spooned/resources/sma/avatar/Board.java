

package resources.sma.avatar;


public class Board extends resources.sma.core.Environement {
    private resources.sma.avatar.Winner winner = new resources.sma.avatar.Winner((-1), (-1), resources.sma.avatar.Board.this);

    private java.util.LinkedList<resources.sma.avatar.Defender> defenders = new java.util.LinkedList<resources.sma.avatar.Defender>();

    private java.util.LinkedList<resources.sma.avatar.Defender> defendersAte = new java.util.LinkedList<resources.sma.avatar.Defender>();

    public void defenderDelete(resources.sma.avatar.Defender defender) {
        resources.sma.avatar.Board.this.defenders.remove(defender);
        resources.sma.avatar.Board.this.defendersAte.add(defender);
    }

    public void defenderReborn(resources.sma.avatar.Defender defender) {
        resources.sma.avatar.Board.this.defendersAte.remove(defender);
        resources.sma.avatar.Board.this.defenders.add(defender);
    }

    public boolean defenderAteContain(resources.sma.avatar.Defender defender) {
        return resources.sma.avatar.Board.this.defendersAte.contains(defender);
    }

    public boolean defendersAte() {
        return (resources.sma.avatar.Board.this.defendersAte.size()) != 0;
    }

    public int defendersNb() {
        return resources.sma.avatar.Board.this.nbDefendersAte;
    }

    public void setNbDefendersAte() {
        (resources.sma.avatar.Board.this.nbDefendersAte)++;
    }

    private int nbDefendersAte = 0;

    private int[][] dijkstra;

    public boolean isLoose() {
        return loose;
    }

    public void loose() {
        resources.sma.avatar.Board.this.loose = true;
    }

    private boolean loose = false;

    public boolean isWin() {
        return win;
    }

    public void win() {
        resources.sma.avatar.Board.this.win = true;
    }

    private boolean win = false;

    public void setCaseDijkstra(int x, int y, int e) {
        resources.sma.avatar.Board.this.dijkstra[x][y] = e;
    }

    public int getCaseDijkstra(int x, int y) {
        return dijkstra[x][y];
    }

    public Board() {
        resources.sma.avatar.Board.this.dijkstra = new int[resources.sma.utils.Utils.grideSizeX][resources.sma.utils.Utils.grideSizeY];
        java.util.Random rdm = new java.util.Random();
        if ((resources.sma.utils.Utils.seed) != 0) {
            rdm.setSeed(resources.sma.utils.Utils.seed);
        }
        int x;
        int y;
        x = rdm.nextInt(resources.sma.utils.Utils.grideSizeX);
        y = rdm.nextInt(resources.sma.utils.Utils.grideSizeY);
        int nbWalls = (((resources.sma.utils.Utils.grideSizeX) * (resources.sma.utils.Utils.grideSizeY)) / 100) * (resources.sma.utils.Utils.wallsPercent);
        for (int i = 0; i < nbWalls; i++) {
            x = rdm.nextInt(resources.sma.utils.Utils.grideSizeX);
            y = rdm.nextInt(resources.sma.utils.Utils.grideSizeY);
            while ((resources.sma.avatar.Board.this.map[x][y]) != null) {
                x = rdm.nextInt(resources.sma.utils.Utils.grideSizeX);
                y = rdm.nextInt(resources.sma.utils.Utils.grideSizeY);
            } 
            map[x][y] = new resources.sma.avatar.Wall(x, y, resources.sma.avatar.Board.this);
        }
        x = rdm.nextInt(resources.sma.utils.Utils.grideSizeX);
        y = rdm.nextInt(resources.sma.utils.Utils.grideSizeY);
        while ((resources.sma.avatar.Board.this.map[x][y]) != null) {
            x = rdm.nextInt(resources.sma.utils.Utils.grideSizeX);
            y = rdm.nextInt(resources.sma.utils.Utils.grideSizeY);
        } 
        map[x][y] = new resources.sma.avatar.Prey(x, y, resources.sma.avatar.Board.this);
        for (int i = 0; i < (resources.sma.utils.Utils.nbHunters); i++) {
            x = rdm.nextInt(resources.sma.utils.Utils.grideSizeX);
            y = rdm.nextInt(resources.sma.utils.Utils.grideSizeY);
            while ((resources.sma.avatar.Board.this.map[x][y]) != null) {
                x = rdm.nextInt(resources.sma.utils.Utils.grideSizeX);
                y = rdm.nextInt(resources.sma.utils.Utils.grideSizeY);
            } 
            map[x][y] = new resources.sma.avatar.Hunter(x, y, resources.sma.avatar.Board.this);
        }
        for (int i = 0; i < (resources.sma.utils.Utils.nbDefenders); i++) {
            x = rdm.nextInt(resources.sma.utils.Utils.grideSizeX);
            y = rdm.nextInt(resources.sma.utils.Utils.grideSizeY);
            while ((resources.sma.avatar.Board.this.map[x][y]) != null) {
                x = rdm.nextInt(resources.sma.utils.Utils.grideSizeX);
                y = rdm.nextInt(resources.sma.utils.Utils.grideSizeY);
            } 
            map[x][y] = new resources.sma.avatar.Defender(x, y, resources.sma.avatar.Board.this);
            resources.sma.avatar.Board.this.defenders.add(((resources.sma.avatar.Defender) (map[x][y])));
        }
    }

    public void decideAll() {
        if (resources.sma.avatar.Board.this.isWin()) {
        }else {
            if (resources.sma.avatar.Board.this.isLoose()) {
            }else {
                if ((resources.sma.avatar.Board.this.nbDefendersAte) == 4) {
                    resources.sma.avatar.Board.this.winner.decide();
                    nbDefendersAte = 5;
                }
                for (resources.sma.avatar.Defender d : resources.sma.avatar.Board.this.defenders) {
                    d.addLife();
                }
                for (resources.sma.avatar.Defender d : resources.sma.avatar.Board.this.defendersAte) {
                    d.addLife();
                    d.decide();
                }
                super.decideAll();
            }
        }
    }

    public java.awt.Color[][] getColor() {
        java.awt.Color[][] res = new java.awt.Color[resources.sma.utils.Utils.grideSizeX][resources.sma.utils.Utils.grideSizeY];
        for (int i = 0; i < (resources.sma.utils.Utils.grideSizeX); i++) {
            for (int j = 0; j < (resources.sma.utils.Utils.grideSizeY); j++) {
                if ((map[i][j]) != null) {
                    res[i][j] = map[i][j].getColor();
                }
            }
        }
        return res;
    }

    public java.util.LinkedList<resources.sma.avatar.Prey> prey() {
        java.util.LinkedList<resources.sma.avatar.Prey> result = new java.util.LinkedList<resources.sma.avatar.Prey>();
        for (int i = 0; i < (resources.sma.utils.Utils.grideSizeX); i++) {
            for (int j = 0; j < (resources.sma.utils.Utils.grideSizeY); j++) {
                if ((map[i][j]) instanceof resources.sma.avatar.Prey) {
                    result.add(((resources.sma.avatar.Prey) (map[i][j])));
                }
            }
        }
        return result;
    }

    public java.lang.String toStringDijkstra() {
        java.lang.String res = "";
        for (int j = 0; j < (resources.sma.utils.Utils.grideSizeX); j++) {
            for (int i = 0; i < (resources.sma.utils.Utils.grideSizeY); i++) {
                if ((resources.sma.avatar.Board.this.dijkstra[i][j]) > 99) {
                    res = (res + (resources.sma.avatar.Board.this.dijkstra[i][j])) + "|";
                }else {
                    if (((resources.sma.avatar.Board.this.dijkstra[i][j]) > 9) || ((resources.sma.avatar.Board.this.dijkstra[i][j]) < 0)) {
                        res = ((res + " ") + (resources.sma.avatar.Board.this.dijkstra[i][j])) + "|";
                    }else {
                        res = ((res + "  ") + (resources.sma.avatar.Board.this.dijkstra[i][j])) + "|";
                    }
                }
            }
            res = res + "\n";
        }
        return res;
    }
}

