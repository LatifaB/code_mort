

package resources.sma.avatar;


public class Prey extends resources.sma.avatar.Avatar implements java.awt.event.KeyListener {
    private float vitesse = 0;

    public Prey(int x, int y, resources.sma.core.Environement environement) {
        super(x, y, environement);
        resources.sma.avatar.Prey.this.color = java.awt.Color.green;
    }

    @java.lang.Override
    public void update() {
        for (int i = 0; i < (resources.sma.utils.Utils.grideSizeX); i++) {
            for (int j = 0; j < (resources.sma.utils.Utils.grideSizeY); j++) {
                if ((resources.sma.avatar.Prey.this.environement.getAgent(i, j)) instanceof resources.sma.avatar.Wall) {
                    ((resources.sma.avatar.Board) (resources.sma.avatar.Prey.this.environement)).setCaseDijkstra(i, j, (-2));
                }else {
                    ((resources.sma.avatar.Board) (resources.sma.avatar.Prey.this.environement)).setCaseDijkstra(i, j, (-1));
                }
            }
        }
        ((resources.sma.avatar.Board) (resources.sma.avatar.Prey.this.environement)).setCaseDijkstra(resources.sma.avatar.Prey.this.x, resources.sma.avatar.Prey.this.y, 1);
        dijkstra(resources.sma.avatar.Prey.this.x, resources.sma.avatar.Prey.this.y);
    }

    private void dijkstra(int i, int j) {
        java.util.LinkedList<java.util.LinkedList<resources.sma.utils.Pair>> listDesVoisinsDesVoisins = new java.util.LinkedList<java.util.LinkedList<resources.sma.utils.Pair>>();
        java.util.LinkedList<resources.sma.utils.Pair> temp = new java.util.LinkedList<resources.sma.utils.Pair>();
        temp.addLast(new resources.sma.utils.Pair(i, j));
        listDesVoisinsDesVoisins.addLast(temp);
        resources.sma.avatar.Prey.this.calculVoisin(listDesVoisinsDesVoisins);
        int distance = 1;
        for (java.util.LinkedList<resources.sma.utils.Pair> listVoisins : listDesVoisinsDesVoisins) {
            for (resources.sma.utils.Pair pair : listVoisins) {
                ((resources.sma.avatar.Board) (resources.sma.avatar.Prey.this.environement)).setCaseDijkstra(pair.first(), pair.second(), distance);
            }
            distance++;
        }
    }

    private void calculVoisin(java.util.LinkedList<java.util.LinkedList<resources.sma.utils.Pair>> listVoisins) {
        if ((listVoisins.getLast().size()) == 0) {
            return ;
        }else {
            java.util.LinkedList<resources.sma.utils.Pair> voisins = new java.util.LinkedList<resources.sma.utils.Pair>();
            for (resources.sma.utils.Pair pair : listVoisins.getLast()) {
                int newX;
                int newY;
                for (int dirX = -1; dirX < 2; dirX++) {
                    newX = (pair.first()) + dirX;
                    for (int dirY = -1; dirY < 2; dirY++) {
                        newY = (pair.second()) + dirY;
                        if (resources.sma.avatar.Prey.this.isOK(newX, newY)) {
                            voisins.add(new resources.sma.utils.Pair(newX, newY));
                        }
                    }
                }
            }
            listVoisins.addLast(voisins);
            resources.sma.avatar.Prey.this.calculVoisin(listVoisins);
        }
    }

    private boolean isOK(int x, int y) {
        if ((((x == (-1)) || (x == (resources.sma.utils.Utils.grideSizeX))) || (y == (-1))) || (y == (resources.sma.utils.Utils.grideSizeY))) {
            return false;
        }
        if ((((resources.sma.avatar.Board) (resources.sma.avatar.Prey.this.environement)).getCaseDijkstra(x, y)) == (-1)) {
            ((resources.sma.avatar.Board) (resources.sma.avatar.Prey.this.environement)).setCaseDijkstra(x, y, 0);
            return true;
        }
        return false;
    }

    @java.lang.Override
    public void decide() {
        if ((vitesse) >= 1) {
            vitesse = 0;
            int i = (resources.sma.avatar.Prey.this.x) + (resources.sma.avatar.Prey.this.dirX);
            int j = (resources.sma.avatar.Prey.this.y) + (resources.sma.avatar.Prey.this.dirY);
            if (!(isNotOccupied(i, j))) {
                return ;
            }
            if (resources.sma.utils.Utils.isThorique()) {
                i = (i + (resources.sma.utils.Utils.grideSizeX)) % (resources.sma.utils.Utils.grideSizeX);
                j = (j + (resources.sma.utils.Utils.grideSizeY)) % (resources.sma.utils.Utils.grideSizeY);
            }
            resources.sma.avatar.Prey.this.environement.setAgent(resources.sma.avatar.Prey.this.x, resources.sma.avatar.Prey.this.y, null);
            resources.sma.avatar.Prey.this.environement.setAgent(i, j, resources.sma.avatar.Prey.this);
            resources.sma.avatar.Prey.this.x = i;
            resources.sma.avatar.Prey.this.y = j;
            update();
        }
        vitesse = (vitesse) + (resources.sma.utils.Utils.speedAvatar);
    }

    private boolean isNotOccupied(int x, int y) {
        if (!(resources.sma.utils.Utils.isThorique())) {
            if ((((x == (-1)) || (x == (resources.sma.utils.Utils.grideSizeX))) || (y == (-1))) || (y == (resources.sma.utils.Utils.grideSizeY))) {
                return false;
            }
        }
        if ((resources.sma.avatar.Prey.this.environement.getAgent(x, y)) instanceof resources.sma.avatar.Winner) {
            ((resources.sma.avatar.Board) (resources.sma.avatar.Prey.this.environement)).win();
        }
        if ((resources.sma.avatar.Prey.this.environement.getAgent(x, y)) instanceof resources.sma.avatar.Defender) {
            ((resources.sma.avatar.Board) (resources.sma.avatar.Prey.this.environement)).defenderDelete(((resources.sma.avatar.Defender) (resources.sma.avatar.Prey.this.environement.getAgent(x, y))));
            ((resources.sma.avatar.Defender) (resources.sma.avatar.Prey.this.environement.getAgent(x, y))).update((-1), (-1));
            ((resources.sma.avatar.Board) (resources.sma.avatar.Prey.this.environement)).setNbDefendersAte();
        }
        return (((resources.sma.avatar.Prey.this.environement.getAgent(x, y)) == null) || ((resources.sma.avatar.Prey.this.environement.getAgent(x, y)) instanceof resources.sma.avatar.Winner)) || ((resources.sma.avatar.Prey.this.environement.getAgent(x, y)) instanceof resources.sma.avatar.Defender);
    }

    @java.lang.Override
    public void keyTyped(java.awt.event.KeyEvent e) {
    }

    @java.lang.Override
    public void keyPressed(java.awt.event.KeyEvent e) {
        switch (e.getKeyCode()) {
            case java.awt.event.KeyEvent.VK_DOWN :
                resources.sma.avatar.Prey.this.dirX = 0;
                resources.sma.avatar.Prey.this.dirY = 1;
                break;
            case java.awt.event.KeyEvent.VK_UP :
                resources.sma.avatar.Prey.this.dirX = 0;
                resources.sma.avatar.Prey.this.dirY = -1;
                break;
            case java.awt.event.KeyEvent.VK_LEFT :
                resources.sma.avatar.Prey.this.dirX = -1;
                resources.sma.avatar.Prey.this.dirY = 0;
                break;
            case java.awt.event.KeyEvent.VK_RIGHT :
                resources.sma.avatar.Prey.this.dirX = 1;
                resources.sma.avatar.Prey.this.dirY = 0;
                break;
            default :
                break;
        }
    }

    @java.lang.Override
    public void keyReleased(java.awt.event.KeyEvent e) {
    }
}

