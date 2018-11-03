package buildordie;

import java.util.ArrayList;
import java.awt.*;

public class World
{
	private int xt,yt,dimensionx,dimensiony;
	private Rectangle camara;
	private ArrayList<ArrayList<Tile>> tiles;
	public World(int xt, int yt, int dimensionx, int dimensiony){
		camara = new Rectangle(0,0,800,600);
		this.xt = xt;
		this.yt = yt;
		this.dimensionx = dimensionx;
		this.dimensiony = dimensiony;
		tiles = new ArrayList<ArrayList<Tile>>();
		for(int i = 0; i < yt; i++){
			ArrayList<Tile> fila = new ArrayList<Tile>();
			for(int j = 0; j < xt; j++){
				fila.add(new Tile(new Point(i*dimensionx,j*dimensiony), dimensionx, dimensiony));
			}
			tiles.add(fila);
		}
	}
	
	public void update(){
		for(int i = 0; i < yt; i++){
			for(int j = 0; j < xt; j++){
				tiles.get(i).get(j).update();
			}
		}
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.black);
		g.fillRect(0,0,800,600);
		for(int i = 0; i < yt; i++){
			for(int j = 0; j < xt; j++){
				if(camara.intersects(tiles.get(i).get(j).getRectangle()));
					tiles.get(i).get(j).render(g);
			}
		}
	}
}
