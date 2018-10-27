package buildordie;

import java.util.ArrayList;

public class Map
{
	private ArrayList<ArrayList<Tile>> tiles;
	public Map(int xt, int yt, int dimensionx, int dimensiony)
	{
		tiles = new ArrayList<ArrayList<Tile>>();
		for(int i = 0; i < yt; i++){
			ArrayList<Tile> fila = new ArrayList<ArrayList<Tile>>();
			for(int j = 0; j < xt; j++){
				fila.push(new Tile(new Point(x*dimensionx,y*dimensiony), dimensionx, dimensiony);
			}
			tiles.push(fila);
		}
	}
}
