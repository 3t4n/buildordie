package buildordie.controllers;
import java.awt.*;
import buildordie.interfaces.*;
import buildordie.*;
import java.awt.event.*;

public class ZombieController implements Controller
{
	private int dy=0,dx=0;
	@Override
	public void handleInput(Entity e)
	{}
	@Override
	public void update(Entity e)
	{
		Point posicion = e.getPosition();
		int x = (int)posicion.getX();
		int y = (int)posicion.getY();
		Point jugadorP = Global.jugador.getPosition();

		e.getAnimation().setRotation((int) Math.toDegrees(Math.atan2(jugadorP.getY()-y, jugadorP.getX()-x))+220);
			
		dy = jugadorP.getY()>y?5:-5;
		dx = jugadorP.getX()>x?5:-5;
		e.setPosition(new Point(x+dx,y+dy));
		e.getAnimation().update();
	}
}
