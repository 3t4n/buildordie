package buildordie;

//import java.util.Random;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import buildordie.*;

public class Tile
{
	private Point posicion,offset;
	private int anchura, altura;
	private Color color;
	//private Random randCol = new Random();

	public Tile(Point p, int w, int h, int r){
		posicion = p;
		anchura = w;
		altura = h;
		color = new Color(r);
		offset = new Point(0,0);
	}

	public void update(){
		offset = Global.jugador.getPosition();
	//	posicion = new Point((int)(off.getX()+posicion.getX()), (int)(off.getY()+posicion.getY()));
	}

	public Rectangle getRectangle(){
		return new Rectangle((int)(posicion.getX()-offset.getX()), (int)(posicion.getY()-offset.getY()), anchura, altura);
	}

	public void render(Graphics g){
	//	BufferedImage piso = new BufferedImage(anchura,altura,BufferedImage.TYPE_INT_RGB);
	//	Graphics t = piso.getGraphics();
		g.setColor(Color.black);
		g.fillRect((int)(posicion.getX()-offset.getX()), (int)(posicion.getY()-offset.getY()), anchura, altura);
		g.setColor(color);
		g.fillRect((int)(posicion.getX()-offset.getX()), (int)(posicion.getY()-offset.getY()), anchura-1, altura-1);
	}
}
