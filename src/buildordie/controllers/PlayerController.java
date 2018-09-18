package buildordie.controllers;
import java.awt.*;
import buildordie.interfaces.*;
import buildordie.*;
import java.awt.event.*;

public class PlayerController implements Controller
{
	private int move;
	private int dy=0,dx=0;
	@Override
	public void handleInput(Entity e)
	{


		   move = Global.teclado.justPressed(KeyEvent.VK_D) ? 270
                     : Global.teclado.justPressed(KeyEvent.VK_A) ? 90
                     : Global.teclado.justPressed(KeyEvent.VK_S) ? 0
                     : Global.teclado.justPressed(KeyEvent.VK_W) ? 180
: -1;
  		dx = move==270 ? 5
                     : move==90? -5
                     : 0;

		dy = move==180 ? -5
                     : move==0 ? 5
                     : 0;


	}
	@Override
	public void update(Entity e)
	{
		Point posicion = e.getPosition();
		int x = (int)posicion.getX();
		int y = (int)posicion.getY();
		if(move!=-1)
		{
			e.setPosition(new Point(x+dx,y+dy));
			e.getAnimation().setRotation(move);
			e.getAnimation().update();
		}
		else
		{
			e.getAnimation().setFrame(0);
		}
	}
}
