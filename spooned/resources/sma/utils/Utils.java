

package resources.sma.utils;


public class Utils {
    public static java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("config");

    public static int grideSizeX = java.lang.Integer.parseInt(resources.sma.utils.Utils.bundle.getString("gridSizeX"));

    public static int grideSizeY = java.lang.Integer.parseInt(resources.sma.utils.Utils.bundle.getString("gridSizeY"));

    public static int canvasSizeX = java.lang.Integer.parseInt(resources.sma.utils.Utils.bundle.getString("canvasSizeX"));

    public static int canvasSizeY = java.lang.Integer.parseInt(resources.sma.utils.Utils.bundle.getString("canvasSizeY"));

    public static int delay = java.lang.Integer.parseInt(resources.sma.utils.Utils.bundle.getString("delay"));

    public static int seed = java.lang.Integer.parseInt(resources.sma.utils.Utils.bundle.getString("seed"));

    public static int refresh = java.lang.Integer.parseInt(resources.sma.utils.Utils.bundle.getString("refresh"));

    public static int nbParticules = java.lang.Integer.parseInt(resources.sma.utils.Utils.bundle.getString("nbParticules"));

    public static int nbTricks = java.lang.Integer.parseInt(resources.sma.utils.Utils.bundle.getString("nbTricks"));

    public static int sharkBreedTime = java.lang.Integer.parseInt(resources.sma.utils.Utils.bundle.getString("sharkBreedTime"));

    public static int sharkStraveTime = java.lang.Integer.parseInt(resources.sma.utils.Utils.bundle.getString("sharkStarveTime"));

    public static int fishBreedTime = java.lang.Integer.parseInt(resources.sma.utils.Utils.bundle.getString("fishBreedTime"));

    public static int nbSharks = java.lang.Integer.parseInt(resources.sma.utils.Utils.bundle.getString("nbSharks"));

    public static int nbFishes = java.lang.Integer.parseInt(resources.sma.utils.Utils.bundle.getString("nbFishes"));

    public static int wallsPercent = java.lang.Integer.parseInt(resources.sma.utils.Utils.bundle.getString("WallsPercent"));

    public static int nbHunters = java.lang.Integer.parseInt(resources.sma.utils.Utils.bundle.getString("NbHunters"));

    public static float speedHunter = java.lang.Float.parseFloat(resources.sma.utils.Utils.bundle.getString("SpeedHunter"));

    public static float speedAvatar = java.lang.Float.parseFloat(resources.sma.utils.Utils.bundle.getString("SpeedAvatar"));

    public static int defenderLife = java.lang.Integer.parseInt(resources.sma.utils.Utils.bundle.getString("DefenderLife"));

    public static int nbDefenders = java.lang.Integer.parseInt(resources.sma.utils.Utils.bundle.getString("NbDefenders"));

    public static java.lang.String scheduling = resources.sma.utils.Utils.bundle.getString("scheduling");

    public static boolean isThorique() {
        return new java.lang.Boolean(resources.sma.utils.Utils.bundle.getString("thorique")).booleanValue();
    }

    public static boolean showGrid() {
        return new java.lang.Boolean(resources.sma.utils.Utils.bundle.getString("grid")).booleanValue();
    }

    public static boolean showTrace() {
        return new java.lang.Boolean(resources.sma.utils.Utils.bundle.getString("trace")).booleanValue();
    }

    public static boolean isInfinity() {
        return (resources.sma.utils.Utils.nbTricks) == 0;
    }

    public static int[] modulo(int x, int y) {
        int[] res = new int[2];
        res[0] = (x + (resources.sma.utils.Utils.grideSizeX)) % (resources.sma.utils.Utils.grideSizeX);
        res[1] = (y + (resources.sma.utils.Utils.grideSizeY)) % (resources.sma.utils.Utils.grideSizeY);
        return res;
    }
}

