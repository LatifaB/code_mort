

package resources.sma.particule;


public class Bille extends resources.sma.core.Agent {
    protected int pasX;

    protected int pasY;

    public Bille(int x, int y, resources.sma.particule.Surface surface) {
        super(x, y, surface);
        java.util.Random rdm = new java.util.Random();
        int[] pas = new int[]{ 1 , -1 };
        if ((resources.sma.utils.Utils.seed) != 0) {
            rdm.setSeed(resources.sma.utils.Utils.seed);
        }
        resources.sma.particule.Bille.this.pasX = pas[rdm.nextInt(2)];
        resources.sma.particule.Bille.this.pasY = pas[rdm.nextInt(2)];
    }

    public void decide() {
        resources.sma.particule.Bille.this.isMoved = true;
        int i = (resources.sma.particule.Bille.this.x) + (resources.sma.particule.Bille.this.pasX);
        int j = (resources.sma.particule.Bille.this.y) + (resources.sma.particule.Bille.this.pasY);
        if (!(resources.sma.utils.Utils.isThorique())) {
            if ((i == (-1)) || (i == (resources.sma.utils.Utils.grideSizeX))) {
                resources.sma.particule.Bille.this.pasX = (resources.sma.particule.Bille.this.pasX) * (-1);
                resources.sma.particule.Bille.this.changementDeDirection = true;
            }
            if ((j == (-1)) || (j == (resources.sma.utils.Utils.grideSizeY))) {
                resources.sma.particule.Bille.this.pasY = (resources.sma.particule.Bille.this.pasY) * (-1);
                resources.sma.particule.Bille.this.changementDeDirection = true;
            }
            i = (resources.sma.particule.Bille.this.x) + (resources.sma.particule.Bille.this.pasX);
            j = (resources.sma.particule.Bille.this.y) + (resources.sma.particule.Bille.this.pasY);
        }
        if (resources.sma.utils.Utils.isThorique()) {
            i = (i + (resources.sma.utils.Utils.grideSizeX)) % (resources.sma.utils.Utils.grideSizeX);
            j = (j + (resources.sma.utils.Utils.grideSizeY)) % (resources.sma.utils.Utils.grideSizeY);
        }
        if ((environement.getAgent(i, j)) != null) {
            echange(((resources.sma.particule.Bille) (environement.getAgent(i, j))));
        }else {
            update();
        }
        if ((changementDeDirection) == true) {
            java.lang.System.out.println("Agent;");
            changementDeDirection = false;
        }
    }

    private void echange(resources.sma.particule.Bille agent) {
        int aux = agent.getPasX();
        agent.setPasX(resources.sma.particule.Bille.this.pasX);
        resources.sma.particule.Bille.this.pasX = aux;
        aux = agent.getPasY();
        agent.setPasY(resources.sma.particule.Bille.this.pasY);
        resources.sma.particule.Bille.this.pasY = aux;
        resources.sma.particule.Bille.this.changementDeDirection = true;
    }

    public void update() {
        int i = (resources.sma.particule.Bille.this.x) + (resources.sma.particule.Bille.this.pasX);
        int j = (resources.sma.particule.Bille.this.y) + (resources.sma.particule.Bille.this.pasY);
        if (resources.sma.utils.Utils.isThorique()) {
            i = (i + (resources.sma.utils.Utils.grideSizeX)) % (resources.sma.utils.Utils.grideSizeX);
            j = (j + (resources.sma.utils.Utils.grideSizeY)) % (resources.sma.utils.Utils.grideSizeY);
        }
        environement.setAgent(resources.sma.particule.Bille.this.x, resources.sma.particule.Bille.this.y, null);
        resources.sma.particule.Bille.this.x = i;
        resources.sma.particule.Bille.this.y = j;
        environement.setAgent(i, j, resources.sma.particule.Bille.this);
    }

    private void setPasY(int pasY2) {
        resources.sma.particule.Bille.this.pasY = pasY2;
    }

    private int getPasY() {
        return resources.sma.particule.Bille.this.pasY;
    }

    private void setPasX(int pasX2) {
        resources.sma.particule.Bille.this.pasX = pasX2;
    }

    private int getPasX() {
        return resources.sma.particule.Bille.this.pasX;
    }
}

