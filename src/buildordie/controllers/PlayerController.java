package buildordie.controllers;
import java.awt.*;
import buildordie.interfaces.*;

public class PlayerController implements Controller
{
	private boolean move=false;
	@Override
	public void handleInput(Entity e)
	{
	}
	@Override
	public void update(Entity e)
	{
		Point posicion = e.getPosition();
		int x = (int)posicion.getX();
		int y = (int)posicion.getY()-10;
		e.setPosition(new Point(x,y));
		e.getAnimation().update();
	}
}
