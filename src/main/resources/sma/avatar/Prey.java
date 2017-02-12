package resources.sma.avatar;

import resources.sma.core.Environement;
import resources.sma.utils.Pair;
import resources.sma.utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;


public class Prey extends Avatar implements KeyListener {
    private float vitesse = 0;

    public Prey(int x, int y, Environement environement) {
        super(x, y, environement);
        this.color = Color.green;
    }

    @Override
    public void update() {
        for(int i = 0; i < Utils.grideSizeX; i++){
            for(int j = 0; j < Utils.grideSizeY; j++){
                if(this.environement.getAgent(i,j) instanceof Wall){
                    ((Board) this.environement).setCaseDijkstra(i, j,-2);
                }else {
                    ((Board) this.environement).setCaseDijkstra(i, j,-1);
                }
            }
        }
        ((Board) this.environement).setCaseDijkstra(this.x, this.y,1);
        dijkstra(this.x,this.y);
    }

    private void dijkstra(int i, int j){
        LinkedList<LinkedList<Pair>> listDesVoisinsDesVoisins = new LinkedList<LinkedList<Pair>>();
        LinkedList<Pair> temp = new LinkedList<Pair>();
        temp.addLast(new Pair(i,j));
        listDesVoisinsDesVoisins.addLast(temp);
        this.calculVoisin(listDesVoisinsDesVoisins);
        int distance = 1;
        for (LinkedList<Pair> listVoisins : listDesVoisinsDesVoisins) {
            for(Pair pair : listVoisins){
                ((Board) this.environement).setCaseDijkstra(pair.first(), pair.second(), distance);
            }
            distance++;
        }
    }

    private void calculVoisin(LinkedList<LinkedList<Pair>> listVoisins) {
        if(listVoisins.getLast().size() == 0){
            return;
        }else {
            LinkedList<Pair> voisins = new LinkedList<Pair>();
            for (Pair pair : listVoisins.getLast()) {
                int newX, newY;
                for (int dirX = -1; dirX < 2; dirX++) {
                    newX = pair.first() + dirX;
                    for (int dirY = -1; dirY < 2; dirY++) {
                        newY = pair.second() + dirY;
                        if (this.isOK(newX, newY)) {
                            voisins.add(new Pair(newX, newY));
                        }
                    }
                }
            }
            listVoisins.addLast(voisins);
            this.calculVoisin(listVoisins);
        }
    }

    private boolean isOK(int x, int y){
        if(x == -1 || x == Utils.grideSizeX || y == -1 || y == Utils.grideSizeY){
            return false;
        }
        if(((Board) this.environement).getCaseDijkstra(x, y) == -1) {
            ((Board) this.environement).setCaseDijkstra(x, y, 0);
            return true ;
        }
        return false;
    }

    @Override
    public void decide() {
        if(vitesse  >= 1){
            vitesse = 0;
            int i = this.x + this.dirX;
            int j = this.y + this.dirY;
            if (!isNotOccupied(i, j)) {
                return;
            }

            if (Utils.isThorique()) {
                i = (i + Utils.grideSizeX) % Utils.grideSizeX;
                j = (j + Utils.grideSizeY) % Utils.grideSizeY;
            }

            this.environement.setAgent(this.x, this.y, null);
            this.environement.setAgent(i, j, this);
            this.x = i;
            this.y = j;
            update();
        }
        vitesse = vitesse + Utils.speedAvatar;
    }

    private boolean isNotOccupied(int x, int y){
        if(!Utils.isThorique()) {
            if (x == -1 || x == Utils.grideSizeX || y == -1 || y == Utils.grideSizeY) {
                return false;
            }
        }
        if(this.environement.getAgent(x, y) instanceof Winner){
            ((Board) this.environement).win();
        }
        if(this.environement.getAgent(x, y) instanceof Defender){
            ((Board) this.environement).defenderDelete((Defender)this.environement.getAgent(x, y));
            ((Defender)this.environement.getAgent(x, y)).update(-1,-1);
            ((Board) this.environement).setNbDefendersAte();
        }
        return this.environement.getAgent(x, y) == null
                || this.environement.getAgent(x, y) instanceof Winner
                || this.environement.getAgent(x, y) instanceof Defender;

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_DOWN :
                this.dirX = 0;
                this.dirY = 1;
                break;
            case KeyEvent.VK_UP :
                this.dirX = 0;
                this.dirY = -1;
                break;
            case KeyEvent.VK_LEFT :
                this.dirX = -1;
                this.dirY = 0;
                break;
            case KeyEvent.VK_RIGHT:
                this.dirX = 1;
                this.dirY = 0;
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
