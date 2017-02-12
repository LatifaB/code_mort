package resources.sma.avatar;


import resources.sma.core.Environement;
import resources.sma.utils.Utils;

import java.awt.*;
import java.util.*;

public class Board extends Environement{

    private Winner winner = new Winner(-1,-1,this);;
    private LinkedList<Defender> defenders = new LinkedList<Defender>();
    private LinkedList<Defender> defendersAte = new LinkedList<Defender>();

    public void defenderDelete(Defender defender){
        this.defenders.remove(defender);
        this.defendersAte.add(defender);
    }

    public void defenderReborn(Defender defender){
        this.defendersAte.remove(defender);
        this.defenders.add(defender);
    }

    public boolean defenderAteContain(Defender defender){
        return this.defendersAte.contains(defender);
    }

    public boolean defendersAte(){
        return this.defendersAte.size() != 0;
    }

    public int defendersNb(){
        return this.nbDefendersAte ;
    }

    public void setNbDefendersAte() {
        this.nbDefendersAte++;
    }

    private int nbDefendersAte = 0;


    private int[][] dijkstra;

    public boolean isLoose() {
        return loose;
    }

    public void loose() {
        this.loose = true;
    }

    private boolean loose = false;

    public boolean isWin() {
        return win;
    }

    public void win() {
        this.win = true;
    }

    private boolean win = false;


    public void setCaseDijkstra(int x, int y, int e) {
        this.dijkstra[x][y] = e;
    }


    public int getCaseDijkstra(int x, int y) {
        return dijkstra[x][y];
    }

    public Board(){
        this.dijkstra = new int[Utils.grideSizeX][Utils.grideSizeY];

        Random rdm = new Random();
        if(Utils.seed != 0){
            rdm.setSeed(Utils.seed);
        }
        int x,y;

        x = rdm.nextInt(Utils.grideSizeX);
        y = rdm.nextInt(Utils.grideSizeY);
        int nbWalls = (Utils.grideSizeX * Utils.grideSizeY) / 100 * Utils.wallsPercent;
        for(int i = 0; i < nbWalls; i++){
            x = rdm.nextInt(Utils.grideSizeX);
            y = rdm.nextInt(Utils.grideSizeY);
            while(this.map[x][y] != null){
                x = rdm.nextInt(Utils.grideSizeX);
                y = rdm.nextInt(Utils.grideSizeY);
            }
            map[x][y] = new Wall(x,y,this);
        }

        x = rdm.nextInt(Utils.grideSizeX);
        y = rdm.nextInt(Utils.grideSizeY);
        while(this.map[x][y] != null){
            x = rdm.nextInt(Utils.grideSizeX);
            y = rdm.nextInt(Utils.grideSizeY);
        }
        map[x][y] = new Prey(x,y,this);

       for(int i = 0; i < Utils.nbHunters; i++){
            x = rdm.nextInt(Utils.grideSizeX);
            y = rdm.nextInt(Utils.grideSizeY);
            while(this.map[x][y] != null){
                x = rdm.nextInt(Utils.grideSizeX);
                y = rdm.nextInt(Utils.grideSizeY);
            }
            map[x][y] = new Hunter(x,y,this);
       }

        for(int i = 0; i < Utils.nbDefenders; i++){
            x = rdm.nextInt(Utils.grideSizeX);
            y = rdm.nextInt(Utils.grideSizeY);
            while(this.map[x][y] != null){
                x = rdm.nextInt(Utils.grideSizeX);
                y = rdm.nextInt(Utils.grideSizeY);
            }
            map[x][y] = new Defender(x,y,this);
            this.defenders.add((Defender) map[x][y]);
        }
    }

    public void decideAll(){
        if(this.isWin()){

        }else{
            if(this.isLoose()){

            }else{
                if(this.nbDefendersAte == 4){
                    this.winner.decide();
                    nbDefendersAte = 5;
                }
                for(Defender d : this.defenders){
                    d.addLife();
                }
                for(Defender d : this.defendersAte){
                    d.addLife();
                    d.decide();
                }
                super.decideAll();
            }
        }
    }

    public Color[][] getColor() {
        Color[][] res = new Color[Utils.grideSizeX][Utils.grideSizeY];
        for(int i = 0; i < Utils.grideSizeX; i++ ){
            for(int j = 0; j < Utils.grideSizeY; j++){
                if(map[i][j] != null){
                    res[i][j] = map[i][j].getColor();
                }
            }
        }
        return res;
    }

    public LinkedList<Prey> prey(){
        LinkedList<Prey> result = new LinkedList<Prey>();
        for(int i = 0; i < Utils.grideSizeX; i++ ){
            for(int j = 0; j < Utils.grideSizeY; j++){
                if(map[i][j] instanceof  Prey){
                    result.add((Prey) map[i][j]);
                }
            }
        }
        return result;
    }

    public String toStringDijkstra(){
        String res = "";
        for(int j = 0; j < Utils.grideSizeX; j++){
            for(int i = 0; i < Utils.grideSizeY; i++){
                if(this.dijkstra[i][j] > 99) {
                    res = res + this.dijkstra[i][j] + "|";
                }else{
                    if(this.dijkstra[i][j] > 9 || this.dijkstra[i][j] < 0){
                        res = res + " " + this.dijkstra[i][j] + "|";
                    }else{
                        res = res + "  " + this.dijkstra[i][j] + "|";
                    }
                }
            }
            res = res + "\n";
        }
        return res;
    }

}
