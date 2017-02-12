package resources.sma.particule;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import resources.sma.utils.Utils;

public class MyJPanelBille extends JPanel{

	private static final long serialVersionUID = 1L;
	protected Color[][] map;
	private int boxSizeX = (int) Utils.canvasSizeX / Utils.grideSizeX;
	private int boxSizeY = (int) Utils.canvasSizeY / Utils.grideSizeY;

	public MyJPanelBille(){
        setPreferredSize(new Dimension(boxSizeX*Utils.grideSizeX, boxSizeY*Utils.grideSizeY));
	}

	  public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(this.map != null){
			for(int i = 0; i < Utils.grideSizeX; i++ ){
				for(int j = 0; j < Utils.grideSizeY; j++){
					if(this.map[i][j] != null){
						g.setColor(this.map[i][j]);
						g.fillOval(i*boxSizeX, j*boxSizeY, boxSizeX, boxSizeY);
						
					}
				}
			}
		}
		if(Utils.showGrid()){
			g.setColor(Color.black);
			g.drawLine(Utils.grideSizeX*boxSizeX, 0, Utils.grideSizeX*boxSizeX, Utils.grideSizeY*boxSizeY);
			g.drawLine(0, Utils.grideSizeY*boxSizeY, Utils.grideSizeX*boxSizeX, Utils.grideSizeY*boxSizeY);
			for(int i = 0; i < Utils.grideSizeX; i++ ){
					g.drawLine(i*boxSizeX, 0, i*boxSizeX, Utils.grideSizeY*boxSizeY);
					g.drawLine(0, i*boxSizeY, Utils.grideSizeX*boxSizeX, i*boxSizeY);
			}
		}
	  }

		public void setMap(Color[][] map){
			this.map = map;
		}
}
