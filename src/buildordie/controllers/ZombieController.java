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
		Point zombie = e.getPosition();
		Point offset = Global.jugador.getPosition();
		int x = (int)zombie.getX();
		int y = (int)zombie.getY();
		e.getAnimation().setRotation((int) Math.toDegrees(Math.atan2(offset.getY()-y, offset.getX()-x))+220);
			
		dy = 300+offset.getY()>y?5:-5;
		dx = 400-offset.getX()>x?5:-5;
		e.setPosition(new Point(x+dx,y+dy));
		e.getAnimation().update();
	}
}
