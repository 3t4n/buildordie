package buildordie;

import java.awt.*;

public class Tile
{
	private Point posicion;
	private int anchura, altura;
	private BufferedImage piso;
	
	public Tile(Point p, int w, int h){
		posicion = p;
		anchura = w;
		altura = h;
		//piso = Utils.loadImage(d);
	}
	
	public void update(){
		Point off = Global.jugador.getPosition();
		posicion = new Point(off.getX()+posicion.getX(), off.getY()+posicion.getY());
	}
	
	public void render(Graphics g){
		g.setColor(Color.black);
		g.fillRect(point.getX(), point.getY(), anchura, altura);
		
		g.setColor(Color.white);
		g.fillRect(point.getX(), point.getY(), anchura-1, altura-1);
	}
}