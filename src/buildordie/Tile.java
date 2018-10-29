package buildordie;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import buildordie.*;

public class Tile
{
	private Point posicion;
	private int anchura, altura;
	
	public Tile(Point p, int w, int h){
		posicion = p;
		anchura = w;
		altura = h;
		//piso = Utils.loadImage(d);
	}
	
	public void update(){
		Point off = Global.jugador.getPosition();
		posicion = new Point((int)(off.getX()+posicion.getX()), (int)(off.getY()+posicion.getY()));
	}
	
	public void render(Graphics g){
	//	BufferedImage piso = new BufferedImage(anchura,altura,BufferedImage.TYPE_INT_RGB);
	//	Graphics t = piso.getGraphics();
		g.setColor(Color.black);
		g.fillRect((int)posicion.getX(), (int)posicion.getY(), anchura, altura);
		
		g.setColor(Color.white);
		g.fillRect((int)posicion.getX(), (int)posicion.getY(), anchura-1, altura-1);
		//g.drawImage(piso,(int)posicion.getX(),(int)posicion.getY(),Global.panel);
	}
}
